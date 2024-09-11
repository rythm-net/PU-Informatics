//var sampleVariable;
var scoreCount;
// console.log(sampleVariable);

// Number 
scoreCount = 10;

// String 
gameTitle = 'Hello Snake';

// Boolean 
var isActive = true;

// Array
var collection = [
    '10', 10, true
];

// 
console.log(collection);
console.log(collection.length);
console.log("***");

collection[5] = 10;

// Add element at the end of the collection
collection.push("END ELEMENT");
collection.shift();
collection.unshift('FIRST ELEMENT');
collection.pop();
for(var i = 0; i < collection.length; i++) {
    console.log(collection[i]);   
}

var ObjectMap = {
    'levelCount'        : 10,
    'maxScore'          : 1000,
    'maxNumberOfLives'  : 3,
    'availableLives'    : 1,
    'gameTitle'         : 'Hello Snake',
    leveConfiguration   :  {
        level1 : {
            title : 'Green Zone'
        },
        
        level2 : {
            title : 'Red Zone'
        },

        level3 : {
            title : 'Blue Zone'
        }
    },
    flowConfiguration : {
        isAlive : true,
        hasAcssessToThisSword : 1
    }
};

var ForThisUser = {
    has : {
        live : {
            count : 10
        }
    }
}

if(ForThisUser.has.live.count > 10) {

} 


console.log('***')
console.log('Number of levels ' + ObjectMap.levelCount);
console.log('Max score ' + ObjectMap['maxScore'])

console.log('***')
console.log(ObjectMap.leveConfiguration); // returns object
console.log(ObjectMap.leveConfiguration.level1.title);

console.log('***')
if(ObjectMap.flowConfiguration.isAlive) {
    console.log("User is still alive")
}

if(ObjectMap.flowConfiguration.hasAcssessToThisSword) {
    console.log("Ta da ad ad daaaaaaaaaamm");
}

var hasLives        = (ObjectMap.availableLives > 0);
var isGameRuning    = true;
var isAlive         = hasLives && isGameRuning; // true / false

if(isAlive) {

}

if(10) {
    console.log("Number value is true");
}

if("sdssd") {
    console.log("Sample string value is true");
}

if("") {
    console.log("Sample string value is true");
}

