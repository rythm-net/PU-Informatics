var Tile = function(constructorConfig) {

    this.x      = (constructorConfig.x * 25);
    this.y      = (constructorConfig.y * 25);
    this.width  = 25;
    this.height = 25;
    this.background = constructorConfig.background;
    this.type       = constructorConfig.type;
    this.isVisible   = true;
};

Tile.prototype.render = function(context) {

    if(this.isVisible) {
        context.beginPath();
        context.rect(this.x, this.y, this.width, this.height);
        context.fillStyle   = this.background;
        context.strokeStyle = '#000000';
        context.stroke();
        context.fill();
        context.closePath();    
    }
};