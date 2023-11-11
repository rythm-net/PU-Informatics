float system_time;
int leafsCollected;
int totalLeafsCreated;

void GUI_bar() {


  float xCoord = width - 200;

  fill(0, 0, 255);
  rect(xCoord, 0, 200, 50);


  fill(255);
  textSize(16);
  text("Game 0.01", xCoord + 10, 16);

  text((int)gameTime, xCoord + 10, 36);

  fill(255, 0, 0);
  text(leafPS.leafs.size(), xCoord + 40, 36);
  fill(0, 255, 0);
  text(leafsCollected, xCoord + 60, 36);

  fill(0, 255, 0);
  text(leafPS.leafs.size()+"/"+totalLeafsCreated, xCoord + 120, 36);
}
