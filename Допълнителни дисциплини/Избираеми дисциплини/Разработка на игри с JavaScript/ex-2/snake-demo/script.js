var canvas      = document.getElementById("game-board");
var context     = canvas.getContext('2d');
var intervalReference = null;

var BoardConfig     = {
    TILE_SIZE       : 25,
    MAX_TILE_COUNT  : 16,
    BOARD_SIZE      : function() {
        return (BoardConfig.TILE_SIZE * BoardConfig.MAX_TILE_COUNT);
    }
};

var directionMap   = {
    'ArrowDown' : 'DOWN',
    'ArrowUp'   : 'UP',
    'ArrowLeft' : 'LEFT',
    'ArrowRight': 'RIGHT'
};

var direction       = 'RIGHT';

var gameManagerCollection = [];


var gameManagerStartEnd = function() {
    clearInterval(intervalReference);
};

var calculateGameState = function(activeCharacter) {

    for(var i = 0; i < gameManagerCollection.length; i++) {

        var isXOverlap = activeCharacter.x == gameManagerCollection[i].x;
        var isYOverlap = activeCharacter.y == gameManagerCollection[i].y;
        var hasCollided = isXOverlap && isYOverlap;

        if(hasCollided) {

            if(gameManagerCollection[i].type == 'obstacle') {
                console.log("GAME OVER");
                gameManagerStartEnd();
            }

            if(gameManagerCollection[i].type == 'food') {
                gameManagerCollection[i].isVisible = false;
                // 
                console.log("GROW");
            }
        }
    }
};

var tile = new Tile({
    x           : 0,
    y           : 0,
    background  : "#00ff00",
    type        : 'snake'
});

var obstacle = new Tile({
    x           : 5,
    y           : 5,
    background  : "#ff0000",
    type        : 'obstacle'
});


var food = new Tile({
    x           : 10,
    y           : 5,
    background  : "#0000ff",
    type        : 'food'
});

gameManagerCollection.push(obstacle);
gameManagerCollection.push(food);


intervalReference = setInterval(function() {
    
    context.beginPath();
    context.clearRect(0, 0, 400, 400);


    if(direction == 'RIGHT') {
        tile.x = tile.x + 25;
    }

    if(direction == 'DOWN') {
        tile.y = tile.y + 25;
    }

    if(direction == 'LEFT') {
        tile.x = tile.x - 25;
    }

    if(direction == 'UP') {
        tile.y = tile.y - 25;
    }

    if(tile.x > BoardConfig.BOARD_SIZE()) {
        tile.x = 0;
    }

    if(tile.y > BoardConfig.BOARD_SIZE()) {
        tile.y = 0;
    }

    if(tile.x < 0) {
        tile.x = BoardConfig.BOARD_SIZE();
    }

    if(tile.y < 0) {
        tile.y = BoardConfig.BOARD_SIZE();
    }
    
    calculateGameState(tile);

    tile.render(context);
    obstacle.render(context);
    food.render(context);

    context.closePath();
}, 200);

document.body.addEventListener('keydown', function(e) {
    direction = directionMap[e.key];
});