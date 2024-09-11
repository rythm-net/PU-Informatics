var Rectangle = function(constructorConfig) {

    this.x          = constructorConfig.x;
    this.y          = constructorConfig.y;
    this.width      = constructorConfig.width;
    this.height     = constructorConfig.height;
    this.background = constructorConfig.background || "#ff0000";
};

Rectangle.prototype.setEndPoint = function(config) {

    this.endX = config.endX;
    this.endY = config.endY;
    this.procesDimentions();
};


Rectangle.prototype.procesDimentions = function() {
    
    this.width  = this.endX - this.x;
    this.height = this.endY - this.y;
};

Rectangle.prototype.render = function(context) {

    context.rect(this.x, this.y, this.width, this.height);
    context.fillStyle = this.background;
    context.fill();
};

Rectangle.prototype.contains = function(x, y) {

    return ((this.x < x) && (x <= this.x + this.width)) &&
           ((this.y < y) && (y <= this.y + this.height))
};