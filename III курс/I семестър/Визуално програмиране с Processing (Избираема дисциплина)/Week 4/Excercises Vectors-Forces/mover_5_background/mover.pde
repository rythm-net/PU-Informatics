class Mover {
  PVector location; // текуща позиция на обекта
  PVector velocity; // скорост / промяната в позицията във времето / посока на движение
  PVector acceleration; // ускорение
  float mass = 25;

  Mover(PVector l, PVector v) {
    location = l;
    velocity = v;

    acceleration = new PVector(0, 0);
  }

  void display() {
    // fill(0, 255, 0);
    // circle(location.x, location.y, 50);
    // noFill();
    image(moverImage, location.x - 50, location.y-50);


    update();
  }

  void update() {
    location.add(velocity);

    println(velocity.y);
    // if (velocity.y < 3) {
    velocity.add(acceleration);
    // }

    // acceleration.mult(0);

    checkEdges();
  }

  void applyForce(PVector f) {
    PVector force = PVector.div(f, mass);
    acceleration.add(force);
  }

  void checkEdges() {
    if (location.x > width) {
      velocity.x *= -1;
    } else if (location.x < 0) {
      velocity.x *= -1;
    }

    if (location.y > height) {
      velocity.y *= -1;
    } else if (location.y < 0) {
      velocity.y *= -1;
    }
  }
}
