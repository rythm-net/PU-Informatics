/*
  Setup background details
 */

PImage bgImg;

void setupBackgroundImage() {
  bgImg = loadImage("../bg1.png");
  bgImg.resize(width, height);
}

/*
  Setup background moving details
 */

class LeafParticleSystem {
  PImage leafImage;
  ArrayList<Leaf> leafs;
  Mover hero;

  LeafParticleSystem(Mover h) {
    leafImage = loadImage("leaf.png");
    hero = h;
    leafs = new ArrayList<Leaf>();
  }

  void addLeaf() {
    totalLeafsCreated++;
    leafs.add(new Leaf(leafImage));
  }

  void addLeaf(int n) {
    for (int i = 0; i < n; i++) {
      totalLeafsCreated++;
      leafs.add(new Leaf(leafImage));
    }
  }

  void run() {
    for (int i = leafs.size()-1; i >= 0; i--) {
      Leaf f = leafs.get(i);

      f.display();

      float d = f.location.dist(hero.location);
      if ( d < 25 ) {
        leafs.remove(i);
        fill(255,0,0);
        circle(f.location.x, f.location.y, 50);
        noFill();
      }

      if (f.location.x > width) {
        leafs.remove(i);
        leafs.add(new Leaf(leafImage));
      }
    }
  }
}

class Leaf {
  PVector location, velocity, acceleration;
  Float mass;
  PImage leafImage;

  Leaf(PImage _leafImage) {
    leafImage = _leafImage;
    location = new PVector(-20, random(height));
    velocity = new PVector(random(5), 0);
    acceleration = new PVector(0, 0);
    mass = random(1, 20);
  }

  void display() {
    // stroke(5);
    // circle(location.x, location.y, 50);
    image(leafImage, location.x, location.y);
    update();
  }

  void applyForce(PVector f) {
    PVector force = PVector.mult(f, mass);
    acceleration.add(force);
  }

  void update() {
    location.add(velocity);
    velocity.add(acceleration);

    applyForce(wind);

    // random up/down
    location.add(new PVector(0, random(-1, 1)));
  }
}
