// In browser alert window
// alert("Hello world"); -- do not use

// In broweser console messige tool
console.log("Hello world from console");

// in C#
// String csharpVariable = "Test";
var jsVariable       = "Test in Js";
var numberVariable   = 10;
var floatVariable    = 10.5;
var boolVariable     = true;
var stringVariable   = "Hello World";
var arrayVariable    = [];
var objectArray      = {};
var dateVariable     = new Date();
var functionVariable = function() {};

console.log(jsVariable)
console.log(numberVariable)
console.log(floatVariable)
console.log(boolVariable)
console.log(stringVariable)
console.log(arrayVariable)
console.log(objectArray)
console.log(dateVariable)
console.log(functionVariable)


// (expresion)
// [array]
// {object}
// Array example
var arrayCollection = [1,1,1,1,1, "Hello World", [], [[[[]]]], {}, true];
console.log(arrayCollection);

var objectCollection = {
    "key" : "value",
    "number" : 10,

    //  do not use
    "inner Object" : {},
    "innerArray" : [1,2,3,4,5,6],
    "punctionPointer" : function() {

    },

    // use
    nameWithNoParantasies : true
};

console.log(objectCollection);



// C# 
// -------
// String sampleMethod(int a, int b) {
//     return "Test Mest";
// }

function functionName() {
    return "Hello world from function";
}

// C#
// DateTime.now();
// DateTime timeObject = DateTime.now();
var stringFunctionResult = functionName();
console.log("====");
console.log(stringFunctionResult);
// execute function directly
console.log(functionName());


// function with void
function voidFunction() {
    var a = 10 + 10;
    console.log("Call from inside voidFunction");
}

// call : voidFunction();
console.log(voidFunction());
console.log(voidFunction);

// no execution
var functionReference = voidFunction;
console.log(functionReference);
console.log(functionReference());


// variable declaration
var variableDeclartaion;
console.log("Var declaration only:");
console.log(variableDeclartaion);


// var functionExpresion;
console.log(functionExpresion());
var functionExpresion = function() {
    return " %%%%> Function Expresion result";
};


console.log(functionConstructor());
function functionConstructor() {
    return " ===> Function Constructor result";
}