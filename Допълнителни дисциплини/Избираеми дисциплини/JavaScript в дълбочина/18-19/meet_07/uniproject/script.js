CanvasManager.init("canvas");

// get all tool actions
var actionRectangle = document.getElementById("action--rect");
var actionCircle    = document.getElementById("action--circle");
var actionMove      = document.getElementById("action--move");
var panelProperty   = document.getElementById("property-panel");

actionRectangle.addEventListener('click', function() {
    CanvasManager.setActiveTool("rect");
});

actionCircle.addEventListener('click', function() {
    CanvasManager.setActiveTool("circle");
});

actionMove.addEventListener("click", function() {
    CanvasManager.setActiveTool("move");
});


CanvasManager.onStart(function(e) {

    // What is the current active tool 
    if(CanvasManager.getActiveTool()) {

        var x = e.clientX;
        var y = e.clientY;

        if(CanvasManager.getActiveTool() == "move") {

            var shapeReferense = CanvasManager.getIntersection(x, y);
            if(shapeReferense) {
                CanvasManager.setActiveShape(shapeReferense);

                // visualise object name property
                //panelProperty.innerHTML = shapeReferense.getName();
                PubSub.publish("USER_CLICK_ON_SHAPE", shapeReferense);
            }
        }

        if(CanvasManager.getActiveTool() == "rect") {
            //CanvasManager.process(new Rectangle(x, y));
            CanvasManager.process(new Rectangle({
                x       : x,
                y       : y,
                name    : `Rectangle ${Util.maintanens.generateId()}`
            }));
        }
    }
});

CanvasManager.onProcess(function(e) {

    var x = e.clientX;
    var y = e.clientY;

    if(CanvasManager.getActiveTool() == "move" && CanvasManager.isShapeActive()) {
        (CanvasManager.getActiveShape()).move(x, y);
    }

    if(CanvasManager.getActiveTool() == "rect" && CanvasManager.isShapeActive()) {
        (CanvasManager.getActiveShape()).finish(x, y);    
    }

    CanvasManager.render();
});

CanvasManager.onFinish(function(e) {
    CanvasManager.renderFinish();
});



// *** other commponent 
PubSub.subscibe('USER_CLICK_ON_SHAPE', function(shapeObject) {
    panelProperty.innerHTML = shapeObject.getName();
});




///

function Human0(name) {
    this.name = name
}

var Human = function(name) {
  this.name = name;
};


var Human1 = (name) => {
  this.name = name;
};

var h1 = new Human0("Misho");
var h2 = new Human("Gosho");
var h3 = new Human1("Pesho");

//console.log(h1);
//nsole.log(h2);
