class Cell {
  float x,y; //Location
  float w,h; //Size
  float r,g,b; //Color
  int num; //Number
  boolean mouse;
 
  Cell(float tempX, float tempY, float tempW, float tempH, int tempNum) {
    x = tempX;
    y = tempY;
    w = tempW;
    h = tempH;
    num = tempNum;
    mouse = false;
  }
  
  /*void addOne(){
    int temp = puzzle[getY()][getX()];
    puzzle[getY()][getX()] = temp+1;
    grid[getY()][getX()].num = temp+1;
  } 
  
  int getX(){
    if(mouseX < 90){
      return 0;
    }
    if(mouseX < 180){
      return 1;
    }
    if(mouseX < 270){
      return 2;
    }
    if(mouseX < 360){
      return 3;
    }
    if(mouseX < 450){
      return 4;
    }
    if(mouseX < 540){
      return 5;
    }
    if(mouseX < 630){
      return 6;
    }
    if(mouseX < 720){
      return 7;
    }
    if(mouseX < 810){
      return 8;
    }
    return -1;
  }
  
  int getY(){
    if(mouseY < 90){
      return 0;
    }
    if(mouseY < 180){
      return 1;
    }
    if(mouseY < 270){
      return 2;
    }
    if(mouseY < 360){
      return 3;
    }
    if(mouseY < 450){
      return 4;
    }
    if(mouseY < 540){
      return 5;
    }
    if(mouseY < 630){
      return 6;
    }
    if(mouseY < 720){
      return 7;
    }
    if(mouseY < 810){
      return 8;
    }
    return -1;
  }*/
  
  void display() {
    if(mouse) {
      fill(#74FFA3);
      //addOne();
    }else{
      fill(255);
    }
    strokeWeight(1);
    rect(x,y,w,h);
    strokeWeight(4);
    line(270,0,270,810);
    line(540,0,540,810);
    line(0,0,0,810);
    line(0,0,810,0);
    line(0,270,810,270);
    line(0,540,810,540);
    line(0,810,810,810);
    line(810,0,810,810);
    //println(getY() + ", " + getX());
  }
  
  /*void mousePressed(){
      addOne();
  }*/
  
  void rollover(int mx, int my) {
    if(mx>x && mx<x+w && my>y && my<y+h) {
      mouse = true;
    }else{
      mouse = false;
    }
  }
}        