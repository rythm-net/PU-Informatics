class NPC extends GameObject {
  Mover hero;

  NPC(PVector l, PVector v) {
    super(l, v);

    loadVisuals("../mario-left.png", "../mario-right.png", 50);
  }

  void display() {
    // display visuals
    fill(255,255,0);
    circle(location.x, location.y, 50);
    noFill();
    update();
  }
  
  // update
  // apply force
  // intersect with player
  // use ability/use weapon/cast spell
}
