boolean timeReset = true;

void startGame() {

  if ((int)gameTime % 5 == 1 && timeReset && (leafPS.leafs.size() < 11)) {
    leafPS.addLeaf((int)gameTime/3);
    timeReset = false;
  }

  if ((int)gameTime % 5 == 4) {
    timeReset = true;
  }
}
