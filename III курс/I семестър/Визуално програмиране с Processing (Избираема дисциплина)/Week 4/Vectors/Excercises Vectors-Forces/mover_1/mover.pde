class Mover {
  PVector location; // текуща позиция на обекта
  PVector velocity; // скорост / промяната в позицията във времето / посока на движение
  PVector acceleration; // ускорение

  Mover(PVector l, PVector v) {
    location = l;
    velocity = v;

    acceleration = new PVector(0, 0.01);
  }

  void display() {
    fill(0, 255, 0);
    circle(location.x, location.y, 50);
    noFill();

    update();
  }

  void update() {
    location.add(velocity);
    println(velocity.y);
    if (velocity.y < 3) {
      velocity.add(acceleration);
    }

    checkEdges();
  }

  void checkEdges() {
    if (location.x > width) {
      location.x = 0;
    } else if (location.x < 0) {
      location.x = width;
    }

    if (location.y > height) {
      location.y = 0;
    } else if (location.y < 0) {
      location.y = height;
    }
  }
}
