var createRectangle = document.getElementById("rectangle");
var createCircle    = document.getElementById("circle");
var actionMove      = document.getElementById("move");

var canvas  = document.getElementById("canvas");
RenderManager.init(canvas);
 
canvas.addEventListener('mousedown', function(e) {
    
    console.log(RenderManager);

    if(RenderManager.createObjectAction) {
        
        var objectReference = RenderManager.getCreateObject({
            x : e.clientX,
            y : e.clientY
        });

        RenderManager.pushNewObject(objectReference);
    }

    if(RenderManager.modifyObjectAction == RenderManager.enums.actions.MOVE) {
        
        // console.log("Move action");
        // console.log(RenderManager.contains(e.clientX, e.clientY));
        var objectReference = RenderManager.contains(e.clientX, e.clientY);
        RenderManager.setCurrent(objectReference);
    }

    /*
    var objectReference = new Circle({
        x : e.clientX,
        y : e.clientY
    });

    RenderManager.pushNewObject(objectReference);
    */
});

canvas.addEventListener('mousemove', function(e) {
    
    if(RenderManager.getCurrent()) {

        if(RenderManager.createObjectAction) {

            RenderManager.getCurrent().setEndPoint({
                endX : e.clientX,
                endY : e.clientY
            });
        }

        if(RenderManager.modifyObjectAction == RenderManager.enums.actions.MOVE) {

            RenderManager.getCurrent().x = e.clientX;
            RenderManager.getCurrent().y = e.clientY;
        }

        RenderManager.render();
    }
});

canvas.addEventListener('mouseup', function() {
    RenderManager.resetCurrent();
});


createRectangle.addEventListener('click', function() {
    RenderManager.setCreateObjectAction(RenderManager.enums.objects.RECTANGLE);
});

createCircle.addEventListener('click', function() {
    RenderManager.setCreateObjectAction(RenderManager.enums.objects.CIRCLE);
});

actionMove.addEventListener('click', function() {
    RenderManager.setModifyObjectAction(RenderManager.enums.actions.MOVE);
});