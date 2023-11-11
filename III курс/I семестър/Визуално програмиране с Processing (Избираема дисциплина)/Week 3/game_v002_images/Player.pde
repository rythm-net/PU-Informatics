class Player extends GameObject {
  char direction;
  PImage image_right;

  Player(float _x, float _y, float _w, float _h) {
    super(_x, _y, _w, _h);
    image = loadImage("assets/mario.png");
    image_right = loadImage("assets/mario_right.png");
  }

  void Display() {
    if (direction == 'a') {
      image(image, x, y);
    } else {
      image(image_right, x, y);
    }
  }

  void Move(char code) {
    switch(code) {
    case 'a':
      player.x -= 5;
      direction = 'a';
      break;
    case 'd':
      player.x += 5;
      direction = 'd';
      break;
    case 'w':
      player.y -= 10;
      direction = 'w';
      break;
    case 's':
      player.y += 10;
      direction = 's';
      break;
    default:
      println("key pressed "+code);   // don't match the switch parameter
      break;
    }
  }
}
