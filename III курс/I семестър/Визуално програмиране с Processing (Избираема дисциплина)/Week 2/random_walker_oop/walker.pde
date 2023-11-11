class Walker {
  // properties
  int x, y;
  int step;
  color c;

  // constructor
  Walker(int _x, int _y, int _s, color _c) {
    x = _x;
    y = _y;
    step = _s;
    c = _c;
  }

  // functions
  void Move() {
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
  }

  void Display() {
    stroke(c);
    point(x, y);
  }

  void Reset() {
    if (x<0 || x>width) {
      x = width/2;
      stroke(random(255), random(255), random(255));
    }
    if (y<0 || y>height) {
      y= height/2;
      stroke(random(255), random(255), random(255));
    }
  }
}
