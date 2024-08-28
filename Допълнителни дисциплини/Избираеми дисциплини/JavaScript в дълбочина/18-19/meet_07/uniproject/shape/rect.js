//var Rectangle = function(x, y, width, height) {
    var Rectangle = function(rectProperties) {
    
    // this.x = x;
    // this.y = y;
    // this.width = width;
    // this.height = height;

    // this.name   = null;

    this.x      = rectProperties.x;
    this.y      = rectProperties.y;
    this.width  = rectProperties.width;
    this.height = rectProperties.height;

    this.name   = rectProperties.name;
};

Rectangle.prototype.finish = function(endX, endY) {
    
    this.width  = (endX - this.x);
    this.height = (endY - this.y);    
};

Rectangle.prototype.render = function(context) {

    context.beginPath();
    context.rect(this.x, this.y, this.width, this.height);
    context.fill();
    context.closePath();
};

Rectangle.prototype.isIntersectable = function(externalX, externalY) {

    var isXInterseptable = (this.x <= externalX) && (this.x + this.width >= externalX);
    var isYInterseptable = (this.y <= externalY) && (this.y + this.height >= externalY);
    // this.x < externalX < (this.x + this.width)
    // 10 < 

    return isXInterseptable && isYInterseptable;
};


Rectangle.prototype.move = function(externalX, externalY) {

    this.x = externalX;
    this.y = externalY;
};


Rectangle.prototype.getName = function() {
    return this.name;
};