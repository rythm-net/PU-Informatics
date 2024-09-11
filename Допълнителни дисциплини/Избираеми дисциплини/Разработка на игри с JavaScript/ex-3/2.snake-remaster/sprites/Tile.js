var Tile = function(constructorObject) {

    this.row    = constructorObject.row;
    this.col    = constructorObject.col;
    this.color  = constructorObject.color;
    
    // move to render method
    // this.x      = (this.row * BoardConfig.TILE_SIZE);
    // this.y      = (this.col * BoardConfig.TILE_SIZE);
    this.side   =  BoardConfig.TILE_SIZE;
};

Tile.prototype.render = function(context) {
    
    var x      = (this.col * BoardConfig.TILE_SIZE);
    var y      = (this.row * BoardConfig.TILE_SIZE);

    context.beginPath();
    context.rect(x, y, this.side, this.side)
    context.fillStyle = this.color;
    context.fill();
    context.closePath();
};