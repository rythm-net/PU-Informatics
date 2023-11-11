Mover mover;
Leaf leaf;
LeafParticleSystem leafs;
PVector gravity = new PVector(0, 0.0098);
PVector wind = new PVector(0.000095, 0);



void setup() {
  size(920, 720);
  setupBackgroundImage();
  mover = new Mover(new PVector(200, 200), new PVector(-1, 1));

  leafs = new LeafParticleSystem(mover);
}

void draw() {
  background(255);
  image(bgImg, 0, 0);

  leafs.run();

  mover.display();
  mover.applyForce(gravity);
  mover.applyForce(wind);
}

void mousePressed() {
  leafs.addLeaf();
}
