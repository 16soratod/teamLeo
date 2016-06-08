import java.util.*;
import java.io.*;

public class Sudoku{
    private int[][] puzzle;
    private int temp;

    public Sudoku(String filename){
	try {
	    Scanner in = new Scanner(new File(filename));
	    puzzle = new int[9][9];
	    String s = "";
	    while (in.hasNextLine()){
		s += in.nextLine();
	    }
	    for (int i = 0; i < 9; i++){
		for (int j = 0; j < 9; j++){
		    puzzle[i][j] = s.charAt(i*9+j)  - '0';
		}
	    }
	} catch (FileNotFoundException e) {
	    System.out.println("File not found");
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

    public boolean solve(){
    	return solveH(0,0);
    }

    public boolean solveH(int row, int col){
    	if(row == 9){
	    	return true;
    	}
    	if(puzzle[row][col] != 0){
	    if(col <= 7 && solveH(row,col+1)){
		return true;
	    }else if (col > 7 && solveH(row+1,0)){
		return true;
	    }
    	}else{
	    for(int i = 1; i < 10; i++){
		temp = i;
		if(checkBox(row,col,temp) && checkHorizontal(row,temp) 
		   && checkVertical(col,temp)){
		    puzzle[row][col] = temp;
		    if(col <= 7 && solveH(row,col+1)){
			return true;
		    }else if (col > 7 && solveH(row+1,0)){
			return true;
		    }
		}
	    }
	    puzzle[row][col] = 0;
	}
	return false;
    }

    public boolean checkBox(int row, int col, int v){
	int r = row / 3 * 3;
	int c = col / 3 * 3;
	for (int i = r; i < r + 3; i++)
	    for (int j = c; j < c + 3; j++)
		if (puzzle[i][j] == v)
		    return false;
	return true;
    }

    public boolean checkHorizontal(int row, int v){
    	for(int i = 0; i < 9; i++){
	    if(puzzle[row][i] == v)
		return false;
    	}
	return true;
    }

    public boolean checkVertical(int col, int v){
	for (int i = 0; i < 9; i++){
	    if(puzzle[i][col] == v)
		return false;
    	}
	return true;
    }

    public static void main(String[] args){
	Sudoku test = new Sudoku("puzzle.txt");
	System.out.println(test.toString());
	//System.out.println(test.checkBox(0,1,9));
	//System.out.println(test.checkHorizontal(1,4));
	//System.out.println(test.checkVertical(3,7));
	System.out.println(test.solve());
	System.out.println(test.toString());
    }
}
