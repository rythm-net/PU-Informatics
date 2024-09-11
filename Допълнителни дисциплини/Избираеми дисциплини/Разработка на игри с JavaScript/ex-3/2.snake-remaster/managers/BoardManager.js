var BoardManager = {};

BoardManager.init = function(canvas) {
    
    _this           = this;
    _this.canvas     = canvas;
    _this.context    = _this.canvas.getContext('2d');

    // Reference pointers
    _this.snakeReference         = null;

    // 
    _this.characterCollection    = [];
    _this.gameDirection          = BoardConfig.DIRECTION.RIGHT;

    _this.loadLevel();

    _this.gameLoopReference = setInterval(_this.gameLoop, BoardConfig.GAME_LOOP);
    _this.render();
};

BoardManager.loadLevel = function() {

    var loadFood = function() {

        // init food 
        var FoodMap = [
            { row: 5    , col: 5  },
            { row: 10   , col: 5  },
            { row: 9    , col: 2  },
            { row: 17   , col: 6  },
            { row: 25   , col: 25 },
        ];

        for(var i = 0; i < FoodMap.length; i++) {
            
            var foodCoordinate  = FoodMap[i];
            var foodReference   = new Food(foodCoordinate); 
            _this.characterCollection.push(foodReference);
        }
    };

    loadFood();

    var loadObstacle = function() {

        // init food 
        var ObstacleMap = [
            { row: 5    , col: 15  },
            { row: 10   , col: 2  },
            { row: 9    , col: 16  },
        ];

        for(var i = 0; i < ObstacleMap.length; i++) {
            
            var obstacleCoordinate  = ObstacleMap[i];
            var obstacleReference   = new Obstacle(obstacleCoordinate); 
            _this.characterCollection.push(obstacleReference);
        }
    };

    loadObstacle();


    var loadSnake = function() {
        
        _this.snakeReference = new Snake({
            row : 3, 
            col : 3
        });

        // Remove the Snake character
        // _this.characterCollection.push(_this.snakeReference);
    };

    loadSnake();
};

BoardManager.gameLoop = function() {

    // Snake move logic
    // ====================================================
    _this.snakeReference.move(_this.gameDirection);

    // Collision detection logic
    // ====================================================
    for(var i = 0; i < _this.characterCollection.length; i++) {
        
        if(_this.characterCollection[i].doesCollide(_this.snakeReference.row, _this.snakeReference.col)) {
            
            if(_this.characterCollection[i].isDeadly()) {
                clearInterval(_this.gameLoopReference);
            }

            if(_this.characterCollection[i].isConsumable()) {
                _this.snakeReference.grow(_this.gameDirection);
            }
        }
    }
    
    _this.clear();
    _this.render(_this.context);
};

BoardManager.setDirection = function(direction) {

    var DirectionMap = {
        'ArrowLeft'     : BoardConfig.DIRECTION.LEFT,
        'ArrowRight'    : BoardConfig.DIRECTION.RIGHT,
        'ArrowUp'       : BoardConfig.DIRECTION.UP,
        'ArrowDown'     : BoardConfig.DIRECTION.DOWN,
    };
 
    if(DirectionMap[direction]) {
        _this.gameDirection = DirectionMap[direction];
    }
};

BoardManager.render = function() {

    for(var i = 0; i < _this.characterCollection.length; i++) {
        _this.characterCollection[i].render(_this.context);
    }

    _this.snakeReference.render(_this.context);
};

BoardManager.clear = function() {
    _this.context.clearRect(0, 0, _this.canvas.width, _this.canvas.height);
};