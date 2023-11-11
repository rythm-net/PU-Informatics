class Player extends GameObject {

  Player(float _x, float _y, float _w, float _h) {
    super(_x, _y, _w, _h);
  }

  void Move(char code) {
    switch(code) {
    case 'a':
      player.x -= 5;
      break;
    case 'd':
      player.x += 5;
      break;
    case 'w':
      player.y -= 10;
      break;
    case 's':
      player.y += 10;
      break;
    default:          
      println("key pressed "+code);   // don't match the switch parameter
      break;
    }
  }
}
