Ball b;
PVector gravity = new PVector(0, 0.08);
PVector wind = new PVector(0.05, 0);

void setup() {
  size(720, 640);

  b = new Ball(new PVector(200, 300), PVector.random2D());
}

void draw() {
  background(255);

  b.display();
  b.applyForce(gravity);
  b.applyForce(wind);
}

class Ball {
  float mass = 10;
  PVector location;
  PVector velocity; // change in location over time
  PVector acceleration; // change in velocity over time

  Ball(PVector l, PVector d) {
    location = l;
    velocity = d;
    acceleration = new PVector(0,0);
  }

  void display() {
    fill(255, 255, 0);
    circle(location.x, location.y, 50);
    noFill();

    fill(255, 0, 0);
    circle(10+velocity.x, 10+velocity.y, 10);
    fill(0, 255, 0);
    circle(40+acceleration.x, 10+acceleration.y, 10);

    update();
    checkEdges();
  }

  void update() {
    location.add(velocity);
    velocity.add(acceleration);
    acceleration.mult(0);
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
