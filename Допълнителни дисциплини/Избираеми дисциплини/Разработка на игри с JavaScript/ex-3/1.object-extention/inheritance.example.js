var Shape = function(x, y, shapeType) {
    this.x = x;
    this.y = y;
    this.shapeType = shapeType;
};

Shape.prototype.shapeInfo = function() {

    return "My type is " + this.shapeType + " my coordinates are x : " + this.x + " and y " + this.y;
};


var Rectangle = function(x, y, shapeType) {
    this.x = x;
    this.y = y;
    this.shapeType = shapeType;
};

// Implement inheritance
// extends
// Rectangle.prototype = Shape.prototype;

Rectangle.prototype.shapeInfo = function() {
    return "Extended shapeInfo : My name is just " + this.shapeType;
};

var rect = new Rectangle(10, 10, "rect");
console.log(rect);
console.log(rect.shapeInfo());
console.log(rect instanceof Rectangle);
console.log(rect instanceof Shape);