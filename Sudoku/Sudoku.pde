import java.util.*;
Cell[][] grid;
int[][] puzzle;

int cols = 9;
int rows = 9;

char state = 'e';
boolean isError;

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
  
  //set up for demo
  
  /*grid[2][0].num = 6;
  grid[5][0].num = 7;
  grid[6][0].num = 3;
  grid[1][1].num = 1;
  grid[2][1].num = 8;
  grid[5][1].num = 9;
  grid[7][1].num = 5;
  grid[0][2].num = 5;
  grid[7][2].num = 6;
  grid[8][2].num = 4;
  grid[0][3].num = 9;
  grid[1][3].num = 2; 
  grid[4][3].num = 8;
  grid[3][4].num = 7; 
  grid[4][4].num = 6;
  grid[5][4].num = 3;
  grid[4][5].num = 9;
  grid[7][5].num = 7;
  grid[8][5].num = 5; 
  grid[0][6].num = 6;
  grid[1][6].num = 3;
  grid[8][6].num = 8;
  grid[1][7].num = 9;
  grid[3][7].num = 3;
  grid[6][7].num = 5;
  grid[7][7].num = 2;
  grid[2][8].num = 2;
  grid[3][8].num = 4; 
  grid[6][8].num = 6;*/
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
  if (mouseX < 810 && mouseY < 810 && !isError)
    addOne();
  else if (mouseX >= 857 && mouseX <= 1033 & mouseY >= 247 && mouseY <= 293 && !isError){
    if (!SudokuSolver.solve(puzzle))
      isError = true;
    for (int i = 0; i < 9; i++){
      for (int j = 0; j < 9; j++){
        grid[i][j].num = puzzle[j][i];
      }
    }
  }
  else if (mouseX >= 857 && mouseX <= 1033 & mouseY >= 517 && mouseY <= 563 && !isError)
    for (int i = 0; i < 9; i++){
      for (int j = 0; j < 9; j++){
        puzzle[i][j] = 0;
        grid[i][j].num = 0;
      }
    }
    else if (mouseX >= 257 && mouseX <= 372 & mouseY >= 402 && mouseY <= 448 && isError){
      isError = false;
    }
    else if (mouseX >= 432 && mouseX <= 553 & mouseY >= 402 && mouseY <= 448 && isError){
      isError = false;
      for (int i = 0; i < 9; i++){
        for (int j = 0; j < 9; j++){
          puzzle[i][j] = 0;
          grid[i][j].num = 0;
        }
      }
    }
  /*for (int i = 0; i < 9; i++)
    println(Arrays.toString(puzzle[i]));
  println();*/
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
  if(state == 'e' && !isError) {//Level Editor
    for (int i=0; i<rows; i++) {
      for (int j=0; j<cols; j++) {
        grid[i][j].rollover(mouseX,mouseY);
        grid[i][j].display();
        //grid[i][j].displayOver();
      }
    }
  }
  if(isError){
    fill(255);
    rect(205,330,400,150);
    textSize(25);
    fill(0);
    text("Invalid input. Please try again.",225,380);
    if (mouseX >= 257 && mouseX <= 372 & mouseY >= 402 && mouseY <= 448)
      fill(200);
    else 
      fill(255);
    rect(255,400,125,50,10);
    fill(0);
    text("Continue",262,435);
    if (mouseX >= 432 && mouseX <= 553 & mouseY >= 402 && mouseY <= 448)
      fill(200);
    else 
      fill(255);
    rect(430,400,125,50,10);
    fill(0);
    text("Restart",450,435);
  }
}