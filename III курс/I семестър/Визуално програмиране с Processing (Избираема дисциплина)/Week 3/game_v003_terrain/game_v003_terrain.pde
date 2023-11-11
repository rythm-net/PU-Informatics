Player player;
Terrain platform1;
Terrain platform2;
PImage background;


void setup() {
  size(920, 520);

  background = loadImage("assets/background2.jpg");
  background.resize(width, height);

  platform1 = new Terrain(100, height-100, width-200, 50);
  platform2 = new Terrain(300, height-350, width/2, 50);

  player = new Player(500, 300, 50, 50);
}

void draw() {
  image(background, 0, 0);


  platform1.Display();
  platform2.Display();
  player.Display();
}
