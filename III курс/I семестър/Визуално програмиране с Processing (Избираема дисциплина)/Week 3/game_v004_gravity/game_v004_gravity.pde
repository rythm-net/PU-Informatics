Player player;
Terrain platform1;
PImage background;


void setup() {
  size(920, 520);

  background = loadImage("assets/background2.jpg");
  background.resize(width, height);

  platform1 = new Terrain(100, height-150, width-200, 50);

  player = new Player(500, 200, 50, 50);
}

void draw() {
  image(background, 0, 0);


  platform1.Display();
  platform1.PlayerIntersects(player);
  player.Display();
}
