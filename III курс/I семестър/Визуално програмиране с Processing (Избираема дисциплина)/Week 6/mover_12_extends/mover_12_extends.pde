Mover mover;
Leaf leaf;
LeafParticleSystem leafPS;
PVector gravity = new PVector(0, 0.0098);
PVector wind = new PVector(0.000095, 0);

float gameTime;

void setup() {
  size(920, 720);
  setupBackgroundImage();
  mover = new Mover(new PVector(200, 200), new PVector(-1, 1), 25, 10);

  leafPS = new LeafParticleSystem(mover);
}

void draw() {
  background(255);
  image(bgImg, 0, 0);

  leafPS.run();

  mover.display();
  mover.applyForce(gravity);
  mover.applyForce(wind);
  
  GUI_bar();
  
  gameTime += 1/frameRate;
  
  startGame();
}

void mousePressed() {
  leafPS.addLeaf();
}
