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
    	if(row >= 8 || col >= 8){
	    	return true;
    	}
    	if(puzzle[row][col] != 0){
	    if(col < 7){
		solveH(row,col+1);
	    }else{
		solveH(row+1,0);
	    }
    	}else{
	    temp = 0;
	    for(int i = 1; i < 10; i++){
		temp = i;
		if(checkBox(row,col,temp) && checkHorizontal(row,temp) 
		   && checkVertical(col,temp)){
		    puzzle[row][col] = temp;
		    if(col < 7){
			solveH(row,col+1);
		    }else{
			solveH(row+1,0);
		    }
		}
	    }
	    if(row == 0){
		return false;
	    }else if(col == 0){
		solveH(row-1, 9);
	    }else{
		solveH(row, col-1);
	    }
	}
	return false;
    }

    private int checkQuadrant(int row, int col){
	if (row < 3 && col < 3){
	    return 1;
	}
	if (row < 3 && col < 6){
	    return 2;
	}
	if (row < 3 && col < 9){
	    return 3;
	}
	if (row < 6 && col < 3){
	    return 4;
	}
	if (row < 6 && col < 6){
	    return 5;
	}
	if (row < 6 && col < 9){
	    return 6;
	}
	if (row < 9 && col < 3){
	    return 7;
	}
	if (row < 9 && col < 6){
	    return 8;
	}
	if (row < 9 && col < 9){
	    return 9;
	}
	return -1;
    }

    public boolean checkBox(int row, int col, int v){
		if(checkQuadrant(row,col) == 1){
			for(int i = 0; i < 3; i++){
				for(int j = 0; j < 3; j++){
					if(puzzle[i][j] == v){
						return false;
					}
				}
			}
		}else{
			return true;
		}
		if(checkQuadrant(row,col) == 2){
			for(int i = 0; i < 3; i++){
				for(int j = 3; j < 6; j++){
					if(puzzle[i][j] == v){
						return false;
					}
				}
			}
		}else{
			return true;
		}
		if(checkQuadrant(row,col) == 3){
			for(int i = 0; i < 3; i++){
				for(int j = 6; j < 9; j++){
					if(puzzle[i][j] == v){
						return false;
					}
				}
			}
		}else{
			return true;
		}
		if(checkQuadrant(row,col) == 4){
			for(int i = 3; i < 6; i++){
				for(int j = 0; j < 3; j++){
					if(puzzle[i][j] == v){
						return false;
					}
				}
			}
		}else{
			return true;
		}
		if(checkQuadrant(row,col) == 5){
			for(int i = 3; i < 6; i++){
				for(int j = 3; j < 6; j++){
					if(puzzle[i][j] == v){
						return false;
					}
				}
			}
		}else{
			return true;
		}
		if(checkQuadrant(row,col) == 6){
			for(int i = 3; i < 6; i++){
				for(int j = 6; j < 9; j++){
					if(puzzle[i][j] == v){
						return false;
					}
				}
			}
		}else{
			return true;
		}
		if(checkQuadrant(row,col) == 7){
			for(int i = 6; i < 9; i++){
				for(int j = 0; j < 3; j++){
					if(puzzle[i][j] == v){
						return false;
					}
				}
			}
		}else{
			return true;
		}
		if(checkQuadrant(row,col) == 8){
			for(int i = 6; i < 9; i++){
				for(int j = 3; j < 6; j++){
					if(puzzle[i][j] == v){
						return false;
					}
				}
			}
		}else{
			return true;
		}
		if(checkQuadrant(row,col) == 9){
			for(int i = 6; i < 9; i++){
				for(int j = 6; j < 9; j++){
					if(puzzle[i][j] == v){
						return false;
					}
				}
			}
		}else{
			return true;
		}
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
	//System.out.println(test.checkBox(0,1,9));
	//System.out.println(test.checkHorizontal(1,4));
	//System.out.println(test.checkVertical(3,7));
	System.out.println(test.solve());
	System.out.println(test.toString());
    }
}
