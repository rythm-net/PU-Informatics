Mover mover;
Leaf leaf;
LeafParticleSystem leafs;
PVector gravity = new PVector(0, 0.00098);
PVector wind = new PVector(0.000095, 0);
PImage leafImage;
PImage moverImage;
void setup() {
  size(640, 460);
  mover = new Mover(new PVector(200, 200), new PVector(-1, 1));
  leaf = new Leaf();
  leafs = new LeafParticleSystem();

  leafImage = loadImage("leaf.png");
  moverImage = loadImage("sonic.png");
}

void draw() {
  background(255);

  leaf.display();
  leafs.run();

  mover.display();
  mover.applyForce(gravity);
  mover.applyForce(wind);
}

void mousePressed() {
  leafs.addLeaf();
}
