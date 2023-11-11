class NPC extends GameObject {
  Mover hero;

  NPC(Mover h, PVector l, PVector v) {
    super(l, v);
    
    hero = h;

    // loadVisuals("../mario-left.png", "../mario-right.png", 50);
  }

  void display() {
    // display visuals
    fill(255, 255, 0);
    circle(location.x, location.y, 50);
    noFill();
    update();
    isShot();
  }


  // Eventually modify update()
  // apply force
  // intersect with player
  // intersect with shots
  // use ability/use weapon/cast spell

  /*
   * Check if NPC is shot
   */ 
  void isShot() {
    for (int i = hero.shots.size()-1; i >= 0; i--) {
      Shot f = hero.shots.get(i);

      float d = f.location.dist(location);
      if ( d < 25 ) {
        fill(255, 0, 0);
        circle(f.location.x, f.location.y, 50);
        noFill();
      }
    }
  }
}
