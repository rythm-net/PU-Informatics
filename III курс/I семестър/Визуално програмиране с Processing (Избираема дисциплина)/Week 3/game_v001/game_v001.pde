GameObject first;
Player player;

void setup() {
  size(800, 420);
  
  first = new GameObject(width/2, height/2, 50, 30);
  player = new Player(500,300, 50,50);
}

void draw() {
   first.Display();
   player.Display();
}
