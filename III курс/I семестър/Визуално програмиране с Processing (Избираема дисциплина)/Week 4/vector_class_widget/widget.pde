class Widget {
  PVector origin;
  PVector velocity;

  Widget (PVector o, PVector v) {
    origin = o;
    velocity = v.mult(10);
  }

  void move() {
    origin.add(velocity); 

    if (origin.x > width - 50 || origin.x < 50) {
      velocity.x *= -1;
    }
    if (origin.y > height - 50 || origin.y < 50) {
      velocity.y *= -1;
    }
    ellipseMode(CENTER);
    ellipse(origin.x, origin.y, 70, 70);
  }
}
