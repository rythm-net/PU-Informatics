class Mover extends GameObject {
  PVector aimDirection;
  ArrayList<Shot> shots;
  PImage shotImage;

  Mover(PVector l, PVector v) {
    super(l, v);
    aimDirection = new PVector(0, 0);

    shots = new ArrayList<Shot>();

    shotImage = loadImage("leaf.png");
    loadVisuals("../mario-left.png", "../mario-right.png", 50);
  }

  void display() {

    /*
     * Draw a circle over the character location
     */
    fill(0, 255, 0);
    circle(location.x, location.y, 50);
    noFill();

    /*
     * Display character image
     */
    if (direction) {
      image(visualLeft, location.x - visualLeft.width/2, location.y - visualLeft.height/2);
    } else {
      image(visualRight, location.x - visualRight.width/2, location.y - visualRight.height/2);
    }

    /*
     * Weapons and stuff
     */
    calculateWeaponDirection();
    displayShots();

    /*
     * Update character location and abilities
     */
    update();
  }

  void update() {
    
    /*
     * Move character with keys or mouse
     * or leave him to the physical forces
     */
    if (mousePressed && (mouseButton == RIGHT)) {
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

    /*
     * Use character abilities
     */
    if (mouseButton == LEFT) {
      println(mouseButton);
      addShot(new PVector(location.x, location.y), aimDirection);
    }

    /*
     * Check if character is about to leave the screen
     */ 
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

  /*
   * Move with keyboard
   */ 
  float stepSize = 5;
  void moveWithKey() {
    PVector dirKey = location;

    if (key == 'a' || key == 'A') {
      dirKey.x -= stepSize;
      if (!direction) direction = true;
    }
    if (key == 'd' || key == 'D') {
      dirKey.x += stepSize;
      if (direction) direction = false;
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

  /*
   * Move character to mouse location
   */ 
  void moveWithMouse() {
    PVector mouse = new PVector(mouseX, mouseY);
    PVector dir = PVector.sub(mouse, location);
    // dir.normalize();
    dir.mult(0.8);
    velocity = dir;
  }

  /*
   * Calculate aim direction
   */ 
  void calculateWeaponDirection() {
    PVector mouse = new PVector(mouseX, mouseY);
    PVector dir = PVector.sub(mouse, location);
    dir.normalize();
    dir.mult(150);

    aimDirection = PVector.add(location, dir);
    // velocity = dir;
    fill(255, 0, 0);
    circle(aimDirection.x, aimDirection.y, 30);
    noFill();
  }
  
  /*
   * Shoot
   */ 
  void addShot(PVector l, PVector d) {

    println("shoot");
    shots.add(new Shot(shotImage, l, d));
  }
  
  /*
   * Display active shots
   */ 
  void displayShots() {
    for (int i = shots.size()-1; i >= 0; i--) {
      Shot f = shots.get(i);

      f.display();

      if ((f.location.x > width || f.location.x < 0) || (f.location.y > height || f.location.y < 0)) {
        println("removed");
        shots.remove(i);
      }
    }
  }
}
