var canvas  = document.getElementById("canvas");
RenderManager.init(canvas);

RenderManager.pushNewObject(new Rectangle({
    x       : 10,
    y       : 10,
    width   : 150,
    height  : 150    
}));

RenderManager.pushNewObject(new Rectangle({
    x       : 200,
    y       : 200,
    width   : 150,
    height  : 150    
}));

RenderManager.render();
