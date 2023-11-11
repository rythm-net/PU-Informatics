class Shot {
  PVector location, velocity, acceleration;
  float mass;
  PImage shotImage;
  float speed = 5; 

  Shot(PImage _shotImage, PVector l, PVector d) {
    shotImage = _shotImage;

    location = l;
    
    PVector dir = PVector.sub(d, l);
    
    velocity = dir.normalize();// new PVector(random(5), 0);
    velocity.mult(speed);
    acceleration = new PVector(0, 0);
    mass = random(1, 20);
  }

  void display() {
    fill(0, 255, 255);
    circle(location.x, location.y, 15);
    // image(shotImage, location.x, location.y);
    update();
  }

  void update() {
    location.add(velocity);
    // velocity.add(acceleration);

    // random up/down
    // location.add(new PVector(0, random(-1, 1)));
  }
}
