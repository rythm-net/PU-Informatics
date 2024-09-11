variableWitotDefinition = 10;

var GameEngine = {

    start : function() {
        return {
            'name' : 'Mihail Petrov'
        }
    },

    startNewLevel : function(levelNumber) {

        if(arguments.length == 3) {
            console.log("Start level " + levelNumber);
            console.log("My name is " + arguments[2]);
        }

        if(arguments.length == 1) {
            console.log("Start level " + levelNumber);            
        }

        if(arguments.length == 0) {
            console.log("Start new game");
        }
    },

    startNewRPGAdventure : function() {
        return "RPG CONFIG INIT";
    },

    startNewAdventure : function(adventureConfig) {

        if(adventureConfig.type == 'Action') {
            return 'Start new Action Game'
        }
        
        if(adventureConfig.type == 'RPG') {
            return GameEngine.startNewRPGAdventure(); 
        }

        return "Strategy game";
    },

    globalHiScore : function() {
        var maxHiScore = 150000;
        console.log(maxHiScore);
    }
};

// console.log(GameEngine.start);
// var userName = GameEngine.start();
// console.log(userName);

// Start level
GameEngine.startNewLevel();

console.log(GameEngine.startNewAdventure({
    type        : 'Action',
    maxLevel    : 10
}));

// Variable experiments
// GameEngine.globalHiScore();
// console.log(maxHiScore);

var agregate = function(collection, callback) {
    
    var resultCollection = [];
    for(var i = 0; i < collection.length; i++) {
        // var element = callback(collection[i])
        // resultCollection.push(element);

        if(callback(collection[i])) {
            resultCollection.push(collection[i]); 
        }
    }

    return resultCollection;
};

var even = function(collection) {
    return agregate(collection, function(element) {
        return (element % 2 == 0);
    });
};

var moreThanThree = function(collection) {
    return agregate(collection, function(element) {
        return element > 3;
    })
};

console.log(even([
    1,1,1,1,1,5,4,8,8,83,4,1
]));


var customMap = function(collection, callback) {
    
    var resultCollection = [];

    for(var i = 0; i < collection.length; i++) {
        var element = callback(collection[i]);
        resultCollection.push(element);
    }

    return resultCollection;
}

console.log("$$$");
console.log(customMap([1,2,3,4,5,6], function(element) {
    return element * 5
}));


var mathPower = function(power) {

    if(power == 2) {

        return function(number) {
            return number * number;
        }
    }

    if(power == 3) {
        
        return function(number) {
            return number * number * number;
        }
    }
}

console.log("%%%")
console.log((mathPower(3))(10));