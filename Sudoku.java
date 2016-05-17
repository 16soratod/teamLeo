import java.util.*;
import java.io.*;

public class Sudoku{
    private int[][] puzzle;

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
		    puzzle[i][j] = s.charAt(i*9+j) - '0';
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

    public static void main(String[] args){
	Sudoku test = new Sudoku("puzzles.txt");
	System.out.println(test.toString());
    }
}
