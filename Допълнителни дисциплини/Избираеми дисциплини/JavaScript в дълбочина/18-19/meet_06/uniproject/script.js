CanvasManager.init("canvas");

// utilitilty variables 
//var layerShapeCollection    = [];
//var shapeReference          = null;

// get all tool actions
var actionRectangle = document.getElementById("action--rect");
var actionCircle = document.getElementById("action--circle");
var actionMove = document.getElementById("action--move");


CanvasManager.onStart(function(e) {
    // Create new Rectangel shape 
    var x = e.clientX;
    var y = e.clientY;
    //shapeReference = new Rectangle(x, y);
    //CanvasManager.shapeReference = new Rectangle(x, y);
    //layerShapeCollection.push(shapeReference);
    //CanvasManager.layerShapeCollection.push(CanvasManager.shapeReference);
    CanvasManager.process(new Rectangle(x, y));
    
    // console.log(e);
});

CanvasManager.onProcess(function(e) {

    // we are sure that reference is not null
    if(!CanvasManager.isShapeActive()) return;

    // Change shape properrties
    // width height
    // var width = e.clientX - shapeReference.x;
    // var height = e.clientY - shapeReference.y;

    // shapeReference.width = width;
    // shapeReference.height = height;
    (CanvasManager.getActiveShape()).finish(e.clientX, e.clientY);
    
    
    // Render functionality
    // context.clearRect(0, 0, 500, 500);
    // for(var i = 0; i < layerShapeCollection.length; i++) {
    //     (layerShapeCollection[i]).render(context);
    // }
    CanvasManager.render();
});

CanvasManager.onFinish(function(e) {
    // prosses to the next shape 
    // var width = e.clientX - shapeReference.x;
    // var height = e.clientY - shapeReference.y;

    // shapeReference.width = width;
    // shapeReference.height = height;
    // shapeReference = null;

    // console.log(layerShapeCollection);
    // for(var i = 0; i < layerShapeCollection.length; i++) {
    //     (layerShapeCollection[i]).render(context);
    // }


    CanvasManager.renderFinish();
    //shapeReference = null;
});