var Circle = function(constuctorConfig) {

    this.x = constuctorConfig.x;
    this.y = constuctorConfig.y;
    this.r = constuctorConfig.r;
    this.background = constuctorConfig.background || '#00ff00';
};

Circle.prototype.render = function(context) {

    context.beginPath();
    context.arc(this.x, this.y, this.r, 0, 2 * Math.PI);
    context.fillStyle = this.background;
    context.fill();
    context.closePath();
};

Circle.prototype.setEndPoint = function(config) {

    this.endX = config.endX;
    this.endY = config.endY;
    this.procesDimentions();
};

Circle.prototype.procesDimentions = function() {
    this.r  = this.endX - this.x;
};