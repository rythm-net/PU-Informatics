class Mover {
  PVector location; // текуща позиция на обекта
  PVector velocity; // скорост / промяната в позицията във времето / посока на движение
  PVector acceleration; // ускорение
  float mass = 25;
  float topSpeed = 10;
  PImage moverImage;

  Mover(PVector l, PVector v) {
    location = l;
    velocity = v;

    acceleration = new PVector(0, 0);

    moverImage = loadImage("../mario.png");
    moverImage.resize(50,50);
  }

  void display() {

    fill(0, 255, 0);
    circle(location.x, location.y, 50);
    noFill();
    image(moverImage, location.x - moverImage.width/2, location.y- moverImage.height/2);


    update();
  }

  void update() {

    /* Go to mouse */ 
    /*
    PVector mouse = new PVector(mouseX, mouseY);
    PVector dir = PVector.sub(mouse, location);
    dir.normalize();
    dir.mult(0.1);
    acceleration = dir;
    */

    /* Go to Random point */ 
    /*
    PVector rand = PVector.random2D();
    rand.limit(0.001);
    acceleration.add(rand);
    */

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
    }
    if (key == 'd' || key == 'D') {
      dirKey.x += stepSize;
    }
    if (key == 'w' || key == 'W') {
      dirKey.y -= stepSize;
    }
    if (key == 's' || key == 'S') {
      dirKey.y += stepSize;
    }

    PVector dir = PVector.sub(dirKey, location);
    dir.mult(0.8);

    // There are different ways to move:
    // acceleration.add(dir);
    // velocity.add(dir);
    velocity = dir;
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
