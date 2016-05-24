import java.util.*;
import java.io.*;

public class SudokuSolver{

    public static boolean solve(int[][] puzzle){
    	return solveH(0,0,puzzle);
    }

    public static boolean solveH(int row, int col, int[][] puzzle){
    	if(row == 9){
	    	return true;
    	}
	int temp;
    	if(puzzle[row][col] != 0){
	    if(col <= 7 && solveH(row,col+1,puzzle)){
		return true;
	    }else if (col > 7 && solveH(row+1,0,puzzle)){
		return true;
	    }
    	}else{
	    for(int i = 1; i < 10; i++){
		temp = i;
		if(checkBox(row,col,temp,puzzle) && checkHorizontal(row,temp,puzzle) 
		   && checkVertical(col,temp,puzzle)){
		    puzzle[row][col] = temp;
		    if(col <= 7 && solveH(row,col+1,puzzle)){
			return true;
		    }else if (col > 7 && solveH(row+1,0,puzzle)){
			return true;
		    }
		}
	    }
	    puzzle[row][col] = 0;
	}
	return false;
    }

    public static boolean checkBox(int row, int col, int v, int[][] puzzle){
	int r = row / 3 * 3;
	int c = col / 3 * 3;
	for (int i = r; i < r + 3; i++)
	    for (int j = c; j < c + 3; j++)
		if (puzzle[i][j] == v)
		    return false;
	return true;
    }

    public static boolean checkHorizontal(int row, int v, int[][] puzzle){
    	for(int i = 0; i < 9; i++){
	    if(puzzle[row][i] == v)
		return false;
    	}
	return true;
    }

    public static boolean checkVertical(int col, int v, int[][] puzzle){
	for (int i = 0; i < 9; i++){
	    if(puzzle[i][col] == v)
		return false;
    	}
	return true;
    }

}