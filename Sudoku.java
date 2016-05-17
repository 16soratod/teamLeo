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

    public int[][] solve(){
    	return solveH(0,0);
    }

    public boolean solveH(int row, int col){
    	if(col >= puzzle.length){
    		return true;
    	}
    	if(puzzle[row][col] != 0){
    		if(col < 8){
    			solveH(row,col+1);
    		}else{
    			solveH(row+1,col);
    		}
    	}else{
    		temp = ( int ) (Math.random(10) + 1);

    	}
    	if(checkBox(row,col) && checkHorizontal(row) && checkVertical()){
    		if(col < 8){
    			solveH(row,col+1);
    		}else{
    			solveH(row+1,col);
    		}
    	}

    }

    public boolean checkBox(int row, int col, int v){

    }

    public boolean checkHorizontal(int row, int v){
    	for(int i = 0; i < 9; i++){
    		if(puzzle[row][])
    	}
    }

    public boolean checkVertical(int row, int v){

    }

    public static void main(String[] args){
	Sudoku test = new Sudoku("puzzles.txt");
	System.out.println(test.toString());
    }
}
