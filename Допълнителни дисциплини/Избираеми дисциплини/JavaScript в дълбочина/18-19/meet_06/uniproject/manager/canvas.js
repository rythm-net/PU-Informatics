// get canvas element 
var canvas  = document.getElementById("canvas");
var context = canvas.getContext('2d');

var CanvasManager = {};

CanvasManager.canvas    = null; 
CanvasManager.context   = null;

CanvasManager.init = function(element) {
    // var canvas  = document.getElementById(element);
    // var context = canvas.getContext('2d');    

    this.canvas = document.getElementById(element);
    this.context = this.canvas.getContext('2d');
};

// Contains all shapes of the canvas application
CanvasManager.layerShapeCollection = [];

// Contains the active shape object
CanvasManager.shapeReference = null;


CanvasManager.process = function(element) {

    this.push(element);
    this.shapeReference = element;
};

CanvasManager.push = function(element) {
    this.layerShapeCollection.push(element);
};

CanvasManager.isShapeActive = function() {
    return (this.shapeReference != null);
};

CanvasManager.getActiveShape = function() {
    return this.shapeReference;
};


CanvasManager.render = function() {

    // clear canvas container 
    this.context.clearRect(0,0, this.canvas.width, this.canvas.height);

    // render shape objects 
    for(var i = 0; i < this.layerShapeCollection.length; i++) {
        this.layerShapeCollection[i].render(this.context);
    }
};

CanvasManager.renderFinish = function() {
    this.shapeReference = null;
};


CanvasManager.onStart = function(callback) {
    this.canvas.addEventListener('mousedown', callback);
}

CanvasManager.onProcess = function(callback) {
    this.canvas.addEventListener('mousemove', callback);
};

CanvasManager.onFinish = function(callback) {
    this.canvas.addEventListener('mouseup', callback);
};