Mover mover;
PVector gravity = new PVector(0, 0.00098);

void setup() {
   size(640, 460); 
   mover = new Mover(new PVector(200,200), new PVector(-1,1));
}

void draw() {
   background(255); 
   
   mover.display();
   mover.applyForce(gravity);
}

void mousePressed() {
   noLoop(); 
}
void mouseReleased() {
   loop(); 
}
