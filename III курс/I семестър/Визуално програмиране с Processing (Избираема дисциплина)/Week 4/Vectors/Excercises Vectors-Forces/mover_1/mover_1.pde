Mover mover;

void setup() {
   size(640, 460); 
   mover = new Mover(new PVector(200,200), new PVector(-1,1));
}

void draw() {
   background(255); 
   
   mover.display();
}

void mousePressed() {
   noLoop(); 
}
void mouseReleased() {
   loop(); 
}
