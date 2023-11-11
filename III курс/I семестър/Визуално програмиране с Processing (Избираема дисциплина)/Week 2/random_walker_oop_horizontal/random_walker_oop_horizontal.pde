ArrayList<Walker> walkers;

void setup() {
  size(320, 320);
  background(0);
  strokeWeight(7);

  walkers = new ArrayList<Walker>();

  for (int i = 0; i < 33; i++) {
    walkers.add(new Walker(random(30, width-30), random(30, height-30), random(1, 11),random(1, 11), color(random(255), random(255), random(255))));
  }
}

void draw() {


  for (Walker w : walkers) {
    w.Display();
    if (mousePressed) {
      w.Move(false, true);
    } else {
      w.Move(true, false);
    }
  }
}

void keyPressed() {
  if (key == ' ') {
      saveFrame("line-######.png");
  } 
}
