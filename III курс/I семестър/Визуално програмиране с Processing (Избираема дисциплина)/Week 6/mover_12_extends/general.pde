class GameObject {
  // Physics
  PVector location; // текуща позиция на обекта
  PVector velocity; // скорост / промяната в позицията във времето / посока на движение
  PVector acceleration; // ускорение
  float mass; // тегло 
  float topSpeed; // максимална скорост
  
  // Visual
  PImage visualLeft;
  PImage visualRight;
  boolean direction = true;

  GameObject(PVector l, PVector v, float m, float tSpeed) {
    location = l;
    velocity = v;
    mass = m;
    topSpeed = tSpeed;

    acceleration = new PVector(0, 0);
  }

  void loadVisuals(String fileLocationLeft, String fileLocationRight, int resize) {
    visualLeft = loadImage(fileLocationLeft);
    visualLeft.resize(resize, resize);
    visualRight = loadImage(fileLocationRight);
    visualRight.resize(resize, resize);
  }

  void display() {
    // display visuals 
    
    update();
  }

  void update() {

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
}
