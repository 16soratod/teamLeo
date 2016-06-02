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
    }

    public void rowSwap(){
	int row1 = (int)(Math.random()*9);
	int row2 = (int)(Math.random()*2)+1;
	row2 = (row1 / 3 * 3) + ((row1 + row2) % 3);
	System.out.println(row1 + ", " + row2);
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
	System.out.println(col1 + ", " + col2);
	for(int i = 0; i < 9; i++){
	    int temp = puzzle[i][col1];
	    puzzle[i][col1] = puzzle[i][col2];
	    puzzle[i][col2] = temp;
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
	a.rowSwap();
	System.out.println(a.toString());
	a.colSwap();
	System.out.println(a.toString());
    }
}
