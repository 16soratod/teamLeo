import java.util.*;
Cell[][] grid;
int[][] puzzle;

int cols = 9;
int rows = 9;

char state = 'e';

void setup() {
  size(810, 810);
  background(255);
  //set up grid
  grid = new Cell[cols][rows];
  for(int i=0; i<cols; i++) {
    for (int j=0; j<rows; j++) {
      grid[i][j] = new Cell(i*90,j*90,90,90,0);
    }
  }
  //set up puzzle board
  puzzle = new int[cols][rows];
  for(int i = 0; i < cols; i++){
    for(int j = 0; j < rows; j++){
      puzzle[i][j] = 0;
    }
  }
}

void draw() {
  //background(255);
  if(state == 'm') {//Main Menu
  }
  if(state == 'p') {//Play
  }
  if(state == 'e') {//Level Editor
    for (int i=0; i<cols; i++) {
      for (int j=0; j<rows; j++) {
        grid[i][j].rollover(mouseX,mouseY);
        grid[i][j].display();
        //grid[i][j].displayOver();
        //grid[i][j].addOne();  
        grid[i][j].update();
      }
    }
  }
  System.out.println(Arrays.toString(puzzle[0]));
}