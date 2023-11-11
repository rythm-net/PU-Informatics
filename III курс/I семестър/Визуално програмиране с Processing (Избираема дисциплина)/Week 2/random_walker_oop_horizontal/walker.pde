class Walker {
  // properties
  float x, y;
  float step;
  float size;
  color c;

  // constructor
  Walker(float _x, float _y, float _w, float _s, color _c) {
    x = _x;
    y = _y;
    step = _s;
    size = _w;
    c = _c;
    
  }

  // functions
  void Move(boolean moveX, boolean moveY) {
    int r = (int)random(1, 5);

    if (moveX) {
      switch(r) {
      case 1:
        x += step;
        break;
      case 2:
        x -= step;
        break;
      }
    }

    if (moveY) {
      switch(r) {
      case 1:
        y += step;
        break;
      case 2:
        y -= step;
        break;
      }
    }
  }

  void Display() {
    stroke(c);
    strokeWeight(size);
    //stroke(color(random(255),  random(255), random(255)));
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
