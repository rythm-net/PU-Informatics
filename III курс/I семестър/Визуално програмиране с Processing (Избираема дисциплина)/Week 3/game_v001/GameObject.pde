class GameObject {
   float x, y;
   float w, h;
   boolean is_visible;
   
   GameObject(float _x, float _y, float _w, float _h) {
     is_visible = true;
     x = _x;
     y = _y;
     w = _w;
     h = _h;
   }
   
   void Display() {
      rect(x,y,w,h); 
   }
}
