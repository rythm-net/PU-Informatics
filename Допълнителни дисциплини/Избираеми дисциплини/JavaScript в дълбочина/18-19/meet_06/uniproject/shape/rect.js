var Rectangle = function(x, y, width, height) {
    
    this.x = x;
    this.y = y;
    this.width = width;
    this.height = height;

    this.name   = null;
};

Rectangle.prototype.finish = function(endX, endY) {
    
    // var width   = endX - this.x;
    // var height  = endY - this.y;
    // this.width  = width;
    // this.height = height;

    this.width  = (endX - this.x);
    this.height = (endY - this.y);    
};

Rectangle.prototype.render = function(context) {

    context.beginPath();
    context.rect(this.x, this.y, this.width, this.height);
    context.fill();
    context.closePath();
};