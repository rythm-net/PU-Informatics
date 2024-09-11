var Snake = function(constructorObject) {

    this.row            = constructorObject.row;
    this.col            = constructorObject.col;
    this.headColor      = "#ff0000";
    this.bodyColor      = "#000000"; 
    
    this.tileCollection = [];
    this.tileCollection.push(new Tile({
        row     : this.row,
        col     : this.col,
        color   : this.headColor 
    }));
};

Snake.prototype.moveLeft = function() {

    this.col -= 1;

    // Update all tiles 
    for(var i = 0; i < this.tileCollection.length; i++) {
         this.tileCollection[i].col -= 1; 
    }
};

Snake.prototype.moveRight = function() {

    var headTile = this.tileCollection[0];
    this.col += 1;

    for(var i = 0; i < this.tileCollection.length; i++) {
        // this.tileCollection[i].col += 1;

        if(this.tileCollection[i].row != headTile.row) {
            this.tileCollection[i].row += 1; 
        }
        else {
            this.tileCollection[i].col += 1;
        }
    }
};

Snake.prototype.moveUp = function() {

    var headTile = this.tileCollection[0];
    this.row             -= 1;

    for(var i = 0; i < this.tileCollection.length; i++) {

        if(this.tileCollection[i].col != headTile.col) {
            this.tileCollection[i].col -= 1; 
        }
        else {
            this.tileCollection[i].row -= 1;
        }
    }
};

Snake.prototype.moveDown = function() {

    var headTile = this.tileCollection[0];
    this.row     += 1;

    for(var i = 0; i < this.tileCollection.length; i++) {

        if(this.tileCollection[i].col != headTile.col) {
            this.tileCollection[i].col -= 1; 
        }
        else {
            this.tileCollection[i].row += 1;
        }
    }
};

Snake.prototype.move = function(direction) {
    
    if(direction == BoardConfig.DIRECTION.LEFT) {
        _this.snakeReference.moveLeft();
    }

    if(direction == BoardConfig.DIRECTION.RIGHT) {
        _this.snakeReference.moveRight();
    }
    
    if(direction == BoardConfig.DIRECTION.UP) {
        _this.snakeReference.moveUp();
    }
    
    if(direction == BoardConfig.DIRECTION.DOWN) {
        _this.snakeReference.moveDown();
    }  
};


Snake.prototype.grow = function(direction) {

    var lastTile = this.tileCollection[this.tileCollection.length - 1];
    this.tileCollection.push(new Tile({
        row     : lastTile.row,
        col     : (lastTile.col + 1),
        color   : this.bodyColor
    }))

};

Snake.prototype.render = function(context) {

    for(var i = 0; i < this.tileCollection.length; i++) {
        this.tileCollection[i].render(context);
    }
};