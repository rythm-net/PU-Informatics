ArrayList<Walker> walkers;

void setup() {
  size(320, 320);
  background(0);
  strokeWeight(7);

  walkers = new ArrayList<Walker>();
  walkers.add(new Walker(width/2, height/2, 11, color(255, 0, 0)));
}

void draw() {

  for (Walker w : walkers) {
    w.Display();
    w.Move();
  }

}
