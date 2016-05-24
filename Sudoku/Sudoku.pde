import java.util.*;
Cell[][] grid;
int[][] puzzle;

int cols = 9;
int rows = 9;

char state = 'e';

void setup() {
  size(1080, 810);
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

int getX(){
  return mouseX / 90;
}
  
int getY(){
  return mouseY / 90;
}
  
void addOne(){
    int temp = puzzle[getY()][getX()];
    if (temp == 9){
      puzzle[getY()][getX()] = 0;
      grid[getX()][getY()].num = 0;
    } else {
      puzzle[getY()][getX()] = temp+1;
      grid[getX()][getY()].num = temp+1;
    }
} 
  
void mousePressed(){
  if (mouseX < 810 && mouseY < 810)
    addOne();
  else if (mouseX >= 857 && mouseX <= 1033 & mouseY >= 247 && mouseY <= 293){
    SudokuSolver.solve(puzzle);
    for (int i = 0; i < 9; i++){
      for (int j = 0; j < 9; j++){
        grid[i][j].num = puzzle[j][i];
      }
    }
  }
  else if (mouseX >= 857 && mouseX <= 1033 & mouseY >= 517 && mouseY <= 563)
    for (int i = 0; i < 9; i++){
      for (int j = 0; j < 9; j++){
        puzzle[i][j] = 0;
        grid[i][j].num = 0;
      }
    }
  for (int i = 0; i < 9; i++)
    println(Arrays.toString(puzzle[i]));
  println();
  }

void draw() {
  //background(255);
  if (mouseX >= 857 && mouseX <= 1033 & mouseY >= 247 && mouseY <= 293)
    fill(200);
  else
    fill(255);
  rect(855,245,180,50,10);
  textSize(40);
  fill(50);
  text("Solve",895,285);
  if (mouseX >= 857 && mouseX <= 1033 & mouseY >= 517 && mouseY <= 563)
    fill(200);
  else
    fill(255);
  rect(855,515,180,50,10);
  textSize(40);
  fill(50);
  text("Reset",895,555);
  if(state == 'm') {//Main Menu
  }
  if(state == 'p') {//Play
  }
  if(state == 'e') {//Level Editor
    for (int i=0; i<rows; i++) {
      for (int j=0; j<cols; j++) {
        grid[i][j].rollover(mouseX,mouseY);
        grid[i][j].display();
        //grid[i][j].displayOver();
      }
    }
  }
}