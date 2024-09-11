var RenderManager = {

    objectCollection    : [],

    createObjectAction  : null,
    modifyObjectAction  : null, 

    activeObject        : null,

    init                : function(canvasReference) {
        this.context = canvasReference.getContext('2d');
    },

    pushNewObject       : function(object) {

        // this.activeObject = object;
        this.setCurrent(object);
        this.objectCollection.push(object);
    },

    render              : function() {
        
        console.log(this.objectCollection);

        // cleare active canvas
        this.context.beginPath();
        this.context.clearRect(0, 0, 800, 800);
        
        // redraw all of the objects
        for(var i = 0; i < this.objectCollection.length; i++) {
            this.objectCollection[i].render(this.context);
        }

        this.context.closePath();
    },

    contains               : function(x, y) {

        for(var i = 0; i < this.objectCollection.length; i++) {
            
            if(this.objectCollection[i].contains(x, y)) {
                return this.objectCollection[i];
            }
        }

        return null;
    },

    getCurrent          : function() {
        return this.activeObject;
    },

    setCurrent          : function(current) {
        this.activeObject = current;
    },

    resetCurrent        : function() {
        this.activeObject = null;
    },

    setCreateObjectAction : function(action) {

        this.resetCurrent();
        this.modifyObjectAction = null;
        this.createObjectAction = action;
    },

    getCreateObject : function(config) {

        if(this.createObjectAction == RenderManager.enums.objects.RECTANGLE) {
            return new Rectangle(config);
        }

        if(this.createObjectAction == RenderManager.enums.objects.CIRCLE) {
            return new Circle(config);
        }
    },

    setModifyObjectAction : function(action) {
        
        this.resetCurrent();
        this.createObjectAction = null;
        this.modifyObjectAction = action;
    }
};



RenderManager.enums = {

    objects     : {
        RECTANGLE   : 'rectangle',
        CIRCLE      : 'circle'
    },

    actions     : {
        MOVE        : 'move'
    }
};