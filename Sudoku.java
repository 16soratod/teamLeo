import java.util.*;
import java.io.*;

public class Sudoku{
    private int[][] puzzle;

    public Sudoku(String filename){
	try {
	    Scanner in = new Scanner(new File(filename));
	    puzzle = new int[9][9];
	    String s = ""
	    While (in.hasNextLine()){
		s += in.nextLine();
	    }
	    for (int i = 0; i < 9; i++){
		for (int j = 0; j < 9; j++){
		    puzzle[i][j] = ;
		    System.out.println(puzzle[i][j]);
		}
	    }
	} catch (FileNotFoundException e) {
	    System.out.println("File not found");
	}
    }

    //public String 

    public static void main(String[] args){
	Sudoku test = new Sudoku("puzzles.txt");
    }
}
