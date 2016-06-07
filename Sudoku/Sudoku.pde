import java.util.*;
Cell[][] grid;
int[][] puzzle;

int cols = 9;
int rows = 9;

int screen = 0;

boolean isError;
boolean wrongSol;

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
  if(screen == 1 || !grid[getX()][getY()].generated){
    int temp = puzzle[getY()][getX()];
    if (temp == 9){
      puzzle[getY()][getX()] = 0;
      grid[getX()][getY()].num = 0;
    } else {
      puzzle[getY()][getX()] = temp+1;
      grid[getX()][getY()].num = temp+1;
    }
  }
} 
  
void mousePressed(){
  //main menu screen
  if(screen == 0){
    if(mouseX < 390 && mouseX > 240 && mouseY > 480 && mouseY < 540 && !isError){
      screen = 1;
    }
    if(mouseX > 740 && mouseX < 950 && mouseY > 480 && mouseY < 540 && !isError){
      screen = 2;
    }
  }
  //solver screen
  else if(screen == 1){
  //click on grid
  if (mouseX < 810 && mouseY < 810 && !isError)
    addOne();
  //solve puzzle
  else if (mouseX >= 857 && mouseX <= 1033 & mouseY >= 247 && mouseY <= 293 && !isError){
    if (!SudokuSolver.solve(puzzle))
      isError = true;
    for (int i = 0; i < 9; i++){
      for (int j = 0; j < 9; j++){
        grid[i][j].num = puzzle[j][i];
      }
    }
  }
  //restart number input
  else if (mouseX >= 857 && mouseX <= 1033 & mouseY >= 517 && mouseY <= 563 && !isError)
    for (int i = 0; i < 9; i++){
      for (int j = 0; j < 9; j++){
        puzzle[i][j] = 0;
        grid[i][j].num = 0;
      }
    }
    //if there is an error and want to continue
    else if (mouseX >= 257 && mouseX <= 372 & mouseY >= 402 && mouseY <= 448 && isError){
      isError = false;
    }
    //if there is an error and want to restart
    else if (mouseX >= 432 && mouseX <= 553 & mouseY >= 402 && mouseY <= 448 && isError){
      isError = false;
      for (int i = 0; i < 9; i++){
        for (int j = 0; j < 9; j++){
          puzzle[i][j] = 0;
          grid[i][j].num = 0;
        }
      }
    }
    //go back to menu
    else if(mouseX < 1080 && mouseX > 860 && mouseY < 110 && mouseY > 50){
      isError = false;
            for (int i = 0; i < 9; i++){
          for (int j = 0; j < 9; j++){
            puzzle[i][j] = 0;
            grid[i][j].num = 0;
        }
      }
        screen = 0;
    }
  }
  //generator screen
  else if(screen == 2){
    //go back to menu
    if(mouseX > 855 && mouseX < 1035 && mouseY > 65 && mouseY < 115){
      isError = false;
      for (int i = 0; i < 9; i++){
          for (int j = 0; j < 9; j++){
            puzzle[i][j] = 0;
            grid[i][j].num = 0;
            grid[i][j].generated = true;
        }
      }
      screen = 0;
    }
    //easy puzzle
    else if (mouseX >= 857 && mouseX <= 1033 & mouseY >= 247 && mouseY <= 293 && !isError){
      SudokuGenerator.generate(0,puzzle);
      for (int i = 0; i < 9; i++){
        for (int j = 0; j < 9; j++){
          grid[i][j].num = puzzle[j][i];
          if(grid[i][j].num != 0)
            grid[i][j].generated = true;
          else
            grid[i][j].generated = false;
        }
      }
    }
    //medium puzzle
    else if (mouseX >= 857 && mouseX <= 1033 & mouseY >= 337 && mouseY <= 383 && !isError){
      SudokuGenerator.generate(1,puzzle);
      for (int i = 0; i < 9; i++){
        for (int j = 0; j < 9; j++){
          grid[i][j].num = puzzle[j][i];
          if(grid[i][j].num != 0)
            grid[i][j].generated = true;
          else
            grid[i][j].generated = false;
        }
      }
    }
    //hard puzzle
    else if (mouseX >= 857 && mouseX <= 1033 & mouseY >= 427 && mouseY <= 473 && !isError){
      SudokuGenerator.generate(2,puzzle);
      for (int i = 0; i < 9; i++){
        for (int j = 0; j < 9; j++){
          grid[i][j].num = puzzle[j][i];
          if(grid[i][j].num != 0)
            grid[i][j].generated = true;
          else
            grid[i][j].generated = false;
        }
      }
    }     
    //puzzle entry
    else if (mouseX < 810 && mouseY < 810 && !isError){
      addOne();
    }
    //check entry
    else if (mouseX >= 857 && mouseX <= 1033 & mouseY >= 607 && mouseY <= 653 && !isError){
      for(int i = 0; i < 9; i++){
        for (int j = 0; j < 9; j++){
          if(puzzle[i][j] == 0)
            wrongSol = true;
            break;
        }
      }
      if (!wrongSol)
        if(!SudokuSolver.checkNum(puzzle))
          wrongSol = true;
      isError = true;
    }
    //want to fix puzzle
    else if (mouseX >= 257 && mouseX <= 372 & mouseY >= 402 && mouseY <= 448 && isError && wrongSol){
      isError = false;
    }
    //want to restart puzzle
    else if (mouseX >= 432 && mouseX <= 553 & mouseY >= 402 && mouseY <= 448 && isError && wrongSol){
      isError = false;
      for (int i = 0; i < 9; i++){
        for (int j = 0; j < 9; j++){
          if(!grid[j][i].generated){
            puzzle[i][j] = 0;
            grid[j][i].num = 0;
          }
        }
      }
    }
    //solved puzzle
    else if (mouseX >= 352 && mouseX <= 458 & mouseY >= 402 && mouseY <= 448 && isError && !wrongSol){
      for (int i = 0; i < 9; i++){
        for (int j = 0; j < 9; j++){
          puzzle[i][j] = 0;
          grid[i][j].num = 0;
        }
      }
    }
  }
  }

void draw() {
  if(screen == 0){
    background(255);
    strokeWeight(4);
    fill(0);
    textSize(40);
    text("Sudoku Solver & Generator", 280, 330);
    if (mouseX >= 242 && mouseX <= 388 & mouseY >= 482 && mouseY <= 538)
      fill(200);
    else
      fill(255);
    rect(240, 480, 150, 60, 10);
    textSize(40);
    fill(0);
    text("Solver", 256, 525);
    if (mouseX >= 742 && mouseX <= 948 & mouseY >= 482 && mouseY <= 538)
      fill(200);
    else
      fill(255);
    rect(740, 480, 210, 60, 10);
    textSize(40);
    fill(0); 
    text("Generator", 750, 525);
    if (mouseX >= 462 && mouseX <= 698 & mouseY >= 602 && mouseY <= 658)
      fill(200);
    else
      fill(255);
    rect(460, 600, 240, 60, 10);
    textSize(40);
    fill(0);
    text("Recognizer", 472, 645);
    
  }
  if(screen == 1){
    background(255);
    if (mouseX >= 857 && mouseX <= 1033 & mouseY >= 247 && mouseY <= 293)
      fill(200);
    else
      fill(255);
    rect(855,245,180,50,10);
    textSize(40);
    fill(0);
    text("Solve",895,285);
    if (mouseX >= 857 && mouseX <= 1033 & mouseY >= 517 && mouseY <= 563)
      fill(200);
    else
      fill(255);
    rect(855,515,180,50,10);
    textSize(40);
    fill(0);
    text("Reset",895,555);
    fill(255);
    if (mouseX >= 857 && mouseX <= 1033 & mouseY >= 67 && mouseY <= 113)
      fill(200);
    else 
      fill(255);
    rect(855,65,180,50,10);
    textSize(40);
    fill(0);
    text("Menu",895,105);
  if(!isError) {
    for (int i=0; i<rows; i++) {
      for (int j=0; j<cols; j++) {
        grid[i][j].rollover(mouseX,mouseY);
        grid[i][j].display();
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
  /*case 3:
    SudokuGenerator.draw();
    generator = true;
    */
  }
  if(screen == 2){
    background(255);
    if (mouseX >= 857 && mouseX <= 1033 & mouseY >= 67 && mouseY <= 113)
      fill(200);
    else 
      fill(255);
    rect(855,65,180,50,10);
    textSize(40);
    fill(0);
    text("Menu",895,105);
    if (mouseX >= 857 && mouseX <= 1033 & mouseY >= 247 && mouseY <= 293)
      fill(200);
    else 
      fill(255);
    rect(855,245,180,50,10);
    textSize(40);
    fill(0);
    text("Easy",905,285);
    if (mouseX >= 857 && mouseX <= 1033 & mouseY >= 337 && mouseY <= 383)
      fill(200);
    else 
      fill(255);
    rect(855,335,180,50,10);
    textSize(40);
    fill(0);
    text("Medium",870,375);
    if (mouseX >= 857 && mouseX <= 1033 & mouseY >= 427 && mouseY <= 473)
      fill(200);
    else 
      fill(255);
    rect(855,425,180,50,10);
    textSize(40);
    fill(0);
    text("Hard",900,465);
    if (mouseX >= 857 && mouseX <= 1033 & mouseY >= 607 && mouseY <= 653)
      fill(200);
    else 
      fill(255);
    rect(855,605,180,50,10);
    textSize(40);
    fill(0);
    text("Done",895,645);
    if(!isError){
      for (int i=0; i<rows; i++) {
        for (int j=0; j<cols; j++) {
          grid[i][j].rollover(mouseX,mouseY);
          grid[i][j].display();
        }
      }
    }
    else if(isError && wrongSol){
      fill(255);
      rect(205,330,400,150);
      textSize(25);
      fill(0);
      text("Invalid solution.",302,380);
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
    else if(isError && !wrongSol){
      fill(255);
      rect(205,330,400,150);
      textSize(25);
      fill(0);
      text("Congratulations, you solved the puzzle!",302,380);
      if (mouseX >= 352 && mouseX <= 458 & mouseY >= 402 && mouseY <= 448)
         fill(200);
       else 
         fill(255);
       rect(350,400,110,50,10);
       fill(0);
       text("OK",387,435);
    }
  }
}