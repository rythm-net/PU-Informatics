class Terrain extends GameObject {
  Terrain(float _x, float _y, float _w, float _h) {
    super(_x, _y, _w, _h);
    image = loadImage("assets/terrain_sand.jpg");
    image.resize((int)w,(int)h);
  }
  
  void Display() {
    image(image, x,y); 
  }
}
