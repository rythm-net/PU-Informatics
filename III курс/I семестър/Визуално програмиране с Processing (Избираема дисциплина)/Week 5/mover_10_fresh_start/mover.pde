class Mover {
  PVector location; // текуща позиция на обекта
  PVector velocity; // скорост / промяната в позицията във времето / посока на движение
  PVector acceleration; // ускорение
  float mass = 25;
  float topSpeed = 10;
  PImage moverImageLeft;
  PImage moverImageRight;
  boolean direction = true;

  Mover(PVector l, PVector v) {
    location = l;
    velocity = v;

    acceleration = new PVector(0, 0);

    moverImageLeft = loadImage("../mario-left.png");
    moverImageLeft.resize(50, 50);
    moverImageRight = loadImage("../mario-right.png");
    moverImageRight.resize(50, 50);
  }

  void display() {
    fill(0, 255, 0);
    circle(location.x, location.y, 50);
    noFill();
    if (direction) {
      image(moverImageLeft, location.x - moverImageLeft.width/2, location.y - moverImageLeft.height/2);
    } else {
      image(moverImageRight, location.x - moverImageRight.width/2, location.y - moverImageRight.height/2);
    }

    update();
  }

  void update() {

    if (mousePressed) {
      moveWithMouse();
    } else if (keyPressed) {
      moveWithKey();
    } else {
      velocity.add(acceleration);
    }
    velocity.add(acceleration);

    velocity.limit(topSpeed);
    location.add(velocity);

    // acceleration.mult(0);

    checkEdges();
  }

  void applyForce(PVector f) {
    PVector force = PVector.div(f, mass);
    acceleration.add(force);
  }

  void checkEdges() {
    if (location.x > width-30) {
      velocity.x *= -0.5 ;
      location.x = width-30;
    } else if (location.x < 30) {
      velocity.x *= -1;
      location.x = 30;
    }

    if (location.y > height-120) {
      velocity.y *= -0.7;
      location.y = height-120;
    } else if (location.y < 30) {
      velocity.y *= -1;
      location.y = 30;
    }
  }

  // move with key
  float stepSize = 5;
  void moveWithKey() {
    PVector dirKey = location;

    if (key == 'a' || key == 'A') {
      dirKey.x -= stepSize;
      if(!direction) direction = true;
    }
    if (key == 'd' || key == 'D') {
      dirKey.x += stepSize;
      if(direction) direction = false;
    }
    if (key == 'w' || key == 'W') {
      dirKey.y -= stepSize;
    }
    if (key == 's' || key == 'S') {
      dirKey.y += stepSize;
    }

    // Calculate movement position
    PVector dir = PVector.sub(dirKey, location);
   
    // There are different ways to move:
    // #1 Standard - move player and apply gravity
    dir.mult(2);
    acceleration.add(dir);

    // #2 Avenger - player does not care about natural forces
    // dir.mult(0.8);
    // velocity = dir;
  }

  // move to mouse
  void moveWithMouse() {
    PVector mouse = new PVector(mouseX, mouseY);
    PVector dir = PVector.sub(mouse, location);
    // dir.normalize();
    dir.mult(0.8);
    velocity = dir;
  }
}
