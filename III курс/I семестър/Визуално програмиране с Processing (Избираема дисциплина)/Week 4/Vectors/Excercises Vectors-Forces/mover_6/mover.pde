class Mover {
  PVector location; // текуща позиция на обекта
  PVector velocity; // скорост / промяната в позицията във времето / посока на движение
  PVector acceleration; // ускорение
  float mass = 25;
  float topSpeed = 10;

  Mover(PVector l, PVector v) {
    location = l;
    velocity = v;

    acceleration = new PVector(0, 0);
  }

  void display() {
    fill(0, 255, 0);
    circle(location.x, location.y, 50);
    noFill();
    // image(moverImage, location.x - 50, location.y-50);


    update();
  }

  void update() {

    PVector mouse = new PVector(mouseX, mouseY);
    PVector dir = PVector.sub(mouse, location);
    dir.normalize();
    dir.mult(2);
    acceleration = dir;
    

    println(velocity.y);

    // PVector rand = PVector.random2D();
    // rand.limit(0.001);
    // acceleration.add(rand);
    
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
      velocity.x *= -1;
      location.x = width-30;
    } else if (location.x < 30) {
      velocity.x *= -1;
      location.x = 30;
    }

    if (location.y > height-30) {
      velocity.y *= -1;
      location.y = height-30;
    } else if (location.y < 30) {
      velocity.y *= -1;
      location.y = 30;
    }
  }
}
