import java.util.*;
import java.io.*;

public class Parser{
	private int[][] puzzle;
	private int temp;

	public Parser(String file){
		try {
	   		Scanner in = new Scanner(new File(file));
	    	puzzle = new int[9][9];
	    	String s = "";
	    	while (in.hasNextLine()){
				s += in.nextLine();
				//System.out.println(s);
	    	}
	    	int row = 0;
	    	int col = 0;
	    	for(int j = 1; j < 18; j+=2){
	    		if(s.charAt(j) == ' '){
	    			puzzle[row][col] = 0;
	    			col++;
	    		}else{
	    			puzzle[row][col] = s.charAt(j) - '0';
	    			col++;
	    		}
	    	}
	    	row = 1;
	    	col = 0;
	    	for(int j = 19; j < 36; j+=2){
	    		if(s.charAt(j) == ' '){
	    			puzzle[row][col] = 0;
	    			col++;
	    		}else{
	    			puzzle[row][col] = s.charAt(j) - '0';
	    			col++;
	    		}
	    	}
	    	row = 2;
	    	col = 0;
	    	for(int j = 37; j < 54; j+=2){
	    		if(s.charAt(j) == ' '){
	    			puzzle[row][col] = 0;
	    			col++;
	    		}else{
	    			puzzle[row][col] = s.charAt(j) - '0';
	    			col++;
	    		}
	    	}
	    	row = 3;
	    	col = 0;
	    	for(int j = 55; j < 72; j+=2){
	    		if(s.charAt(j) == ' '){
	    			puzzle[row][col] = 0;
	    			col++;
	    		}else{
	    			puzzle[row][col] = s.charAt(j) - '0';
	    			col++;
	    		}
	    	}
	    	row = 4;
	    	col = 0;
	    	for(int j = 73; j < 90; j+=2){
	    		if(s.charAt(j) == ' '){
	    			puzzle[row][col] = 0;
	    			col++;
	    		}else{
	    			puzzle[row][col] = s.charAt(j) - '0';
	    			col++;
	    		}
	    	}
	    	row = 5;
	    	col = 0;
	    	for(int j = 91; j < 108; j+=2){
	    		if(s.charAt(j) == ' '){
	    			puzzle[row][col] = 0;
	    			col++;
	    		}else{
	    			puzzle[row][col] = s.charAt(j) - '0';
	    			col++;
	    		}
	    	}
	    	row = 6;
	    	col = 0;
	    	for(int j = 109; j < 126; j+=2){
	    		if(s.charAt(j) == ' '){
	    			puzzle[row][col] = 0;
	    			col++;
	    		}else{
	    			puzzle[row][col] = s.charAt(j) - '0';
	    			col++;
	    		}
	    	}
	    	row = 7;
	    	col = 0;
	    	for(int j = 127; j < 144; j+=2){
	    		if(s.charAt(j) == ' '){
	    			puzzle[row][col] = 0;
	    			col++;
	    		}else{
	    			puzzle[row][col] = s.charAt(j) - '0';
	    			col++;
	    		}
	    	}
	    	row = 8;
	    	col = 0;
	    	for(int j = 145; j < 162; j+=2){
	    		if(s.charAt(j) == ' '){
	    			puzzle[row][col] = 0;
	    			col++;
	    		}else{
	    			puzzle[row][col] = s.charAt(j) - '0';
	    			col++;
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

    public static void main(String[] args) throws FileNotFoundException{
    	File file = new File("puzzle.txt");
    	Parser test = new Parser("result.txt");
    	System.out.println(test.toString());
    	    try
    	{
        	PrintWriter printWriter = new PrintWriter(file);
        	printWriter.println (test.toString());
       		printWriter.close();       
    	}
    	catch (FileNotFoundException ex)  
    	{
    		System.out.println("Error");
    	}
    }

}