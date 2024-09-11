var Obstacle = function(constructorObject) {

    this.row    = constructorObject.row;
    this.col    = constructorObject.col;
    this.color  = "#0000ff";

    this.tileReference = new Tile({
        row     : this.row,
        col     : this.col,
        color   : this.color
    });
};

Obstacle.prototype.doesCollide = function(row, col) {

    return (this.row == row) &&
           (this.col == col); 
};

Obstacle.prototype.isConsumable = function() {
    return false;
};

Obstacle.prototype.isDeadly = function() {
    return true;
};

Obstacle.prototype.render = function(context) {
    this.tileReference.render(context);
};