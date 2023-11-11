Ball b;

void setup() {
  size(720, 640);

  b = new Ball(new PVector(200, 300), PVector.random2D());
}

void draw() {
  background(255);

  b.display();
}

class Ball {
  float mass = 1;
  PVector location;
  PVector velocity; // change in location over time
  PVector acceleration = PVector.random2D(); // change in velocity over time

  Ball(PVector l, PVector d) {
    location = l;
    velocity = d;
    velocity = velocity.mult(0);
  }

  void display() {
    fill(255, 255, 0);
    circle(location.x, location.y, 50);
    noFill();
    
    update();
    checkEdges();
  }

  void update() {
    location.add(velocity);
    velocity.add(acceleration);
  }

  void applyForce(PVector f) {
    PVector force = PVector.div(f, mass);
    acceleration.add(f);
  }

  void checkEdges() {
    if (location.x > width) {
      location.x = width;
      velocity.x *= -1;
    } else if (location.x < 0) {
      location.x = 0;
      velocity.x *= -1;
    }

    if (location.y > height ) {
      location.y = height;
      velocity.y *= -1;
    } else if (location.y < 0) {
      location.y = 0;
      velocity.y *= -1;
    }
  }
}
