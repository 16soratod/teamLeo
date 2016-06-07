import java.util.*;

public class SudokuGenerator{

    public static void generate(int difficulty, int[][] puzzle){
	for(int i = 0; i < 9; i++){
	    for(int j = 0; j < 9; j++){
		puzzle[i][j] = 0;
	    }
	}
	//generate solved puzzle and shuffle
	SudokuSolver.solve(puzzle);
	for(int i = 0; i < 100; i++){
	    int rand = (int)(Math.random()*4);
	    if(rand == 0) 
		rowSwap(puzzle);
	    else if(rand == 1)
		colSwap(puzzle);
	    else if(rand == 2)
		hBoxSwap(puzzle);
	    else
		vBoxSwap(puzzle);
	}
	int fails = 0;
        int r = (int)(Math.random()*9);
	int c = (int)(Math.random()*9);
	//remove first element
	puzzle[r][c] = 0;
	for(int j = 0; j < 49 + (3 * difficulty); j++){
	    if(!deleteCell(puzzle)){
		fails++;
		if(fails >= 5)
		    j--;
	    }
	}
    }

    public static void rowSwap(int[][] puzzle){
	int row1 = (int)(Math.random()*9);
	int row2 = (int)(Math.random()*2)+1;
	row2 = (row1 / 3 * 3) + ((row1 + row2) % 3);
	for(int i = 0; i < 9; i++){
	    int temp = puzzle[row1][i];
	    puzzle[row1][i] = puzzle[row2][i];
	    puzzle[row2][i] = temp;
	}
    }

    public static void colSwap(int[][] puzzle){
	int col1 = (int)(Math.random()*9);
	int col2 = (int)(Math.random()*2)+1;
	col2 = (col1 / 3 * 3) + ((col1 + col2) % 3);
	for(int i = 0; i < 9; i++){
	    int temp = puzzle[i][col1];
	    puzzle[i][col1] = puzzle[i][col2];
	    puzzle[i][col2] = temp;
	}
    }

    public static void hBoxSwap(int[][] puzzle){
	int box1 = (int)(Math.random()*3);
	int box2 = (int)(Math.random()*2)+1;
	box2 = (box1 + box2) % 3 * 3;
	box1 *= 3;
	for(int i = 0; i < 3; i++){
	    for(int j = 0; j < 9; j++){
		int temp = puzzle[box1+i][j];
		puzzle[box1+i][j] = puzzle[box2+i][j];
		puzzle[box2+i][j] = temp;
	    }
	}
    }

    public static void vBoxSwap(int[][] puzzle){
	int box1 = (int)(Math.random()*3);
	int box2 = (int)(Math.random()*2)+1;
	box2 = (box1 + box2) % 3 * 3;
	box1 *= 3;
	for(int i = 0; i < 3; i++){
	    for(int j = 0; j < 9; j++){
		int temp = puzzle[j][box1+i];
		puzzle[j][box1+i] = puzzle[j][box2+i];
		puzzle[j][box2+i] = temp;
	    }
	}
    }

    //copied from solver and modified to add back 0s on success
    public static boolean solveH(int row, int col, int[][] puzzle){
    	if(row == 9){
	    	return true;
    	}
    	if(puzzle[row][col] != 0){
	    if(col <= 7 && solveH(row,col+1,puzzle)){
		return true;
	    }else if (col > 7 && solveH(row+1,0,puzzle)){
		return true;
	    }
    	}else{
	    for(int i = 1; i < 10; i++){
		if(SudokuSolver.checkBox(row,col,i,puzzle)
		   && SudokuSolver.checkHorizontal(row,i,puzzle) 
		   && SudokuSolver.checkVertical(col,i,puzzle)){
		    puzzle[row][col] = i;
		    if(col <= 7 && solveH(row,col+1,puzzle)){
			puzzle[row][col] = 0;
			return true;
		    }else if (col > 7 && solveH(row+1,0,puzzle)){
			puzzle[row][col] = 0;
			return true;
		    }
		}
	    }
	    puzzle[row][col] = 0;
	}
	return false;
    }
    
    public static boolean deleteCell(int[][] puzzle){
	int r = (int)(Math.random()*9);
	int c = (int)(Math.random()*9);
	if (puzzle[r][c] == 0)
	    return false;
	int temp = puzzle[r][c];
	for(int i = 1; i < 10; i++){
	    //check if i isn't the removed value and if it is a valid input
	    if(i != temp && SudokuSolver.checkBox(r,c,i,puzzle)
	       && SudokuSolver.checkHorizontal(r,i,puzzle) 
	       && SudokuSolver.checkVertical(c,i,puzzle)){
		puzzle[r][c] = i;
		if(solveH(0,0,puzzle)){
		    puzzle[r][c] = temp;
		    return false;
		}
	    }
	}
	puzzle[r][c] = 0;
	return true;
    }
}