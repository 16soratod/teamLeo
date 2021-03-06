class Cell {
  float x,y; //Location
  float w,h; //Size
  float r,g,b; //Color
  int num; //Number
  boolean generated;
  boolean mouse;
 
  Cell(float tempX, float tempY, float tempW, float tempH, int tempNum) {
    x = tempX;
    y = tempY;
    w = tempW;
    h = tempH;
    num = tempNum;
    generated = true;
    mouse = false;
  }
  
  void display() {
    if(mouse) {
      fill(#74FFA3);
    }else{
      fill(255);
    }
    strokeWeight(1);
    rect(x,y,w,h);
    if (num > 0){
      textSize(40); 
      if (generated)
        fill(0);
      else
        fill(150);
      text(num,x+35,y+60);
    }
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
  
  void rollover(int mx, int my) {
    if(mx>x && mx<x+w && my>y && my<y+h) {
      mouse = true;
    }else{
      mouse = false;
    }
  }
}        