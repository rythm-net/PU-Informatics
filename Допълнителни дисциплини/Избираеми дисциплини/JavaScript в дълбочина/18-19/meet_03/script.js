// # Седмица 3 - Java Script в дълбочина 
// # =================================================================================================================

// Създайте функция, която намира всички тройки в подадена като единствен аргумент колекция и връща масив съдържащ всички намерени елементи на квадрат, 
// ако няма тройки нека връща празен масив. 
// * Направете проверка дали подаденият аргумент е точно един. Ако е нарушено условието функцията връща празен масив
// * Направете проверка дали подаденият аргумент е от правилният тип.

var customPow = function(element) {
    return element * element;
};


var findAllElementsThree = function(collection) {

    var foundCollectionWithElement = [];

    var isNotSingleArguments    = (arguments.length != 1);
    var isNotArray              = !Array.isArray(collection);
    var isNotProcessable        = isNotSingleArguments ||  isNotArray;

    // Example 1
    // if((arguments.length != 1) || !Array.isArray(collection)) {
    //     return foundCollectionWithElement;
    // }

    if(arguments.length != 1) {
        return foundCollectionWithElement;
    }  
    
    if(!Array.isArray(collection)) {
        return foundCollectionWithElement;
    }


    for(var i = 0; i < collection.length; i++) {
        if(collection[i] == 3) {

            // Example with Math function object
            foundCollectionWithElement.push(Math.pow(collection[i], 2));

            // Example with custom function
            // foundCollectionWithElement.push(customPow(collection[i]));
        }
    }

    return foundCollectionWithElement;
};

// създайте обект наречен CollectionUtil, който ще съдържа функции за работа с колекции.  
// * добавете функция която да обхожда масиви и да визуализира резултата от тях по произволен начин
// * добавете функция filter която приема колекция и връща нова на базата на някакво филтриращо условие
// * добавете функция map която приема колекция и връща нова на базата на произволно мапиращо условие

// Declare an object
// var CollectionUtil = {
//     forEach : function() {
//     }
// };

var CollectionUtil = {};
CollectionUtil.forEach = function(collection, callback) {

    for(var i = 0; i < collection.length; i++) {
        callback(collection[i], collection, i);
    }
};

// console.log("Example 1");
CollectionUtil.forEach([1,2,3,4,5,6,7], function(numberElement) {
    // console.log(' ** ' + numberElement + ' **');
});

// console.log("Example 2");
CollectionUtil.forEach([1,2,3,4,5,6,7], function(numberElement) {
    // console.log(' Element of collection is' + numberElement);
});

// console.log("Example 3");
CollectionUtil.forEach([1,2,3,4,5,6,7], function(numberElement, innerFunctionCollection) {
    // console.log("Collection original:");
    // console.log(innerFunctionCollection);
    // console.log(' Element of collection is ' + numberElement);
});

// console.log("Example 4");
CollectionUtil.forEach([1,2,3,4,5,6,7], function(numberElement, innerFunctionCollection, iterationIndex) {
    // console.log("Collection original: ");
    // console.log(innerFunctionCollection);
    // console.log("Iteration index: ");
    // console.log(iterationIndex);
    // console.log(' Element of collection is ' + numberElement);
});

//console.log("Example 5");
//CollectionUtil.forEach([1,2,3,4,5,6,7], 10);


CollectionUtil.filter = function(collection, callback) {
    
    var resultFilterCollection = []; 
    var callbackResult = null;
    for(var i = 0; i < collection.length; i++) {

        // // Example in body 1 
        // if(collection[i] > 5) {
        //     resultFilterCollection.push(collection[i]);
        // }

        // // Example in body 2
        // if(collection[i] %2 == 0) {
        //     resultFilterCollection.push(collection[i]);
        // }

        // Example with callback with elements
        // callbackResult = callback(collection[i]);
        // if(callbackResult != undefined) {
        //     resultFilterCollection.push(callbackResult);
        // }

        callbackResult = callback(collection[i]);
        if(callbackResult) {
            resultFilterCollection.push(collection[i]);
        }
    }

    return resultFilterCollection;
};


//console.log("Filter Example: 1");
var resultCollection = CollectionUtil.filter([1,2,3,4,5,6,7,8,9,10], function(element) {

    // if(element > 5) {
    //     return element;
    // }

    // if(element > 5) {
    //     return true;
    // }

    return (element > 5);
});
// console.log(resultCollection);
// [1,2,3,4,5,6,7,8,9,10];
// > 5 => [6,7,8,9,10]
// > %2 => [2,4,6,8,10]


// underscore
CollectionUtil.map = function(collection, callback) {

    var resultCollection = [];
    for(var i = 0; i < collection.length; i++) {
        resultCollection.push(callback(collection[i]));
    }
};

CollectionUtil.map([1,2,3,4,5,6,7,8], function(element) {
    return element * 2;
});

function scopeFunctionA() {
    console.log(exampleElement);
    exampleElement = 10;
}

//var exampleElement = 'Hello World';
// var scopeFunctionA = function() {
//     exampleElement = 10;
// };

// console.log("#Example: function scope")
// scopeFunctionA();
// console.log(exampleElement);

// (function() {
//     console.log("Call from anonimus function");
//     console.log(exampleElement);
// })()


// var exampleElement;


// var exampleElement;
// var exampleElement;
// exampleElement = 'Hello World';
// exampleElement = 'Secong String variable';

(function() {
    var exampleElement = 'Hello World';
})();

(function() {

    var exampleElement;
    console.log(exampleElement);
    exampleElement = 'Secong String variable';

    // console.log(exampleElement);
    // var exampleElement = 'Secong String variable';

})();

// 
//console.log(exampleElement);