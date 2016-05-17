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
    	if(row >= 8 && col >= 8){
	    return true;
    	}
    	if(puzzle[row][col] != 0){
	    if(col < 7){
		solveH(row,col+1);
	    }else{
		solveH(row+1,0);
	    }
    	}else{
	    temp = 1;
	    if(checkBox(row,col,temp) && checkHorizontal(row,temp) 
	       && checkVertical(col,temp)){
		puzzle[row][col] = temp;
		if(col < 8){
		    solveH(row,col+1);
		}else{
		    solveH(row+1,col);
		}
	    } else {
		temp++;
	    }
	}
	return false;
    }

    private int checkQuadrant(int row, int col){
	if (row < 3 && col < 3)
	    return 1;
	if (row < 3 && col < 6)
	    return 2;
	if (row < 3 && col < 9)
	    return 3;
	if (row < 6 && col < 3)
	    return 4;
	if (row < 6 && col < 6)
	    return 5;
	if (row < 6 && col < 9)
	    return 6;
	if (row < 9 && col < 3)
	    return 7;
	if (row < 9 && col < 6)
	    return 8;
	if (row < 9 && col < 9)
	    return 9;
    }

    public boolean checkBox(int row, int col, int v){
	return false;
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
	Sudoku test = new Sudoku("puzzles.txt");
	System.out.println(test.toString());
    }
}
