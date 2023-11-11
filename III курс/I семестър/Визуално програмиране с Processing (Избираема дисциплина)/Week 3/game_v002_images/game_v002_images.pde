GameObject first;
Player player;
PImage background;

void setup() {
  size(920, 520);

  background = loadImage("assets/background.png");
  background.resize(width, height);
  first = new GameObject(width/2, height/2, 50, 30);
  player = new Player(500, 300, 50, 50);
}

void draw() {
  image(background, 0, 0);
  first.Display();
  player.Display();
}
