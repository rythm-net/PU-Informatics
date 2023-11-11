int x, y;
int step;

void setup() {
  size(320, 320);
  background(0);
  strokeWeight(7);
  stroke(255);
  x = width/2;
  y = height/2;
  step = 4;
}

void draw() {
  int r = (int)random(1, 5);
  println(r);
  switch(r) {
  case 1:
    x += step;
    break;
  case 2:
    y += step;
    break;
  case 3:
    x -= step;
    break;
  case 4:
    y -= step;
    break;
  }
  point(x, y);
  
  /*
  if (x<0 || x>width) {
    x = width/2;
    stroke(random(255), random(255), random(255));
  }
  if (y<0 || y>height) {
    y= height/2;
    //stroke(random(255), random(255), random(255));
  }
  */
}
