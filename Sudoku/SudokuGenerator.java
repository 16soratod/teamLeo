import java.util.*;

public class SudokuGenerator{
    public int[][] puzzle = new int[9][9];

    public SudokuGenerator(){
	for(int i = 0; i < 9; i++){
	    for(int j = 0; j < 9; j++){
		puzzle[i][j] = 0;
	    }
	}
	SudokuSolver.solve(puzzle);
	for(int i = 0; i < 100; i++){
	    int rand = (int)(Math.random()*4);
	    if(rand == 0) 
		rowSwap();
	    else if(rand == 1)
		colSwap();
	    else if(rand == 2)
		hBoxSwap();
	    else
		vBoxSwap();
	}
    }

    public void rowSwap(){
	int row1 = (int)(Math.random()*9);
	int row2 = (int)(Math.random()*2)+1;
	row2 = (row1 / 3 * 3) + ((row1 + row2) % 3);
	//System.out.println(row1 + ", " + row2);
	for(int i = 0; i < 9; i++){
	    int temp = puzzle[row1][i];
	    puzzle[row1][i] = puzzle[row2][i];
	    puzzle[row2][i] = temp;
	}
    }

    public void colSwap(){
	int col1 = (int)(Math.random()*9);
	int col2 = (int)(Math.random()*2)+1;
	col2 = (col1 / 3 * 3) + ((col1 + col2) % 3);
	//System.out.println(col1 + ", " + col2);
	for(int i = 0; i < 9; i++){
	    int temp = puzzle[i][col1];
	    puzzle[i][col1] = puzzle[i][col2];
	    puzzle[i][col2] = temp;
	}
    }

    public void hBoxSwap(){
	int box1 = (int)(Math.random()*3);
	int box2 = (int)(Math.random()*2)+1;
	box2 = (box1 + box2) % 3 * 3;
	box1 *= 3;
	//System.out.println(box1 + ", " + box2);
	for(int i = 0; i < 3; i++){
	    for(int j = 0; j < 9; j++){
		int temp = puzzle[box1+i][j];
		puzzle[box1+i][j] = puzzle[box2+i][j];
		puzzle[box2+i][j] = temp;
	    }
	}
    }

    public void vBoxSwap(){
	int box1 = (int)(Math.random()*3);
	int box2 = (int)(Math.random()*2)+1;
	box2 = (box1 + box2) % 3 * 3;
	box1 *= 3;
	//System.out.println(box1 + ", " + box2);
	for(int i = 0; i < 3; i++){
	    for(int j = 0; j < 9; j++){
		int temp = puzzle[j][box1+i];
		puzzle[j][box1+i] = puzzle[j][box2+i];
		puzzle[j][box2+i] = temp;
	    }
	}
    }

    public String toString(){
	String retSt = "";
        for (int i = 0; i < 9; i++){
	    for (int j = 0; j < 9; j++){
		retSt += puzzle[i][j];
	    }
	    retSt += "\n";
	}
	return retSt;
    }

    public static void main(String[] args){
	SudokuGenerator a = new SudokuGenerator();
	System.out.println(a.toString());
	/*a.rowSwap();
	System.out.println(a.toString());
	a.colSwap();
	System.out.println(a.toString());
	a.hBoxSwap();
	System.out.println(a.toString());
	a.vBoxSwap();
	System.out.println(a.toString());*/
    }
}
