class Terrain extends GameObject {
  Terrain(float _x, float _y, float _w, float _h) {
    super(_x, _y, _w, _h);
    image = loadImage("assets/terrain_sand.jpg");
    image.resize((int)w, (int)h);
  }

  void Display() {
    image(image, x, y);
  }

  void PlayerIntersects(Player p) {

    if ((p.y < this.y && p.y > this.y-50)) {
      // println("1");
    }
    if (player.x > this.x && player.x < this.x + this.w) {
      // println("2");
    }
    if ((p.y < this.y && p.y > this.y-50) && (player.x > this.x && player.x < this.x + this.w)) {
      p.in_air = false;
    } else {
      p.in_air = true;
    }
  }
}
