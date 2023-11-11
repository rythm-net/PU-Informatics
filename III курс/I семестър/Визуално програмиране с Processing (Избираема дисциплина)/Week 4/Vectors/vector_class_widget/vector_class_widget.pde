Widget w1, w2, w3;
PVector v = new PVector(8,3);

void setup() {
  size(800, 640); 
  w1 = new Widget(new PVector(100,200), PVector.random2D());
  w2 = new Widget(new PVector(300,500), PVector.random2D());
  w3 = new Widget(new PVector(500,100), PVector.random2D());
}

void draw() {
  w1.move();
  w2.move();
  w3.move();
}
