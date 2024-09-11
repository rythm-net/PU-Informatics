// startScreenFunctionNew();

startScreenFunction();

function startScreenFunction() {
    console.log("*Hello World");

    // return "Hello World";
    return undefined;
}

var callbackVariableReference = startScreenFunction();
console.log(callbackVariableReference);


anonimusConsoleLog();

var anonimusConsoleLog = function() {
    console.log("Anonimus call");
}

anonimusConsoleLog();


var anonimusFunction = function() {
    return 126;
}

console.log(anonimusFunction());
//
(function() {
    return 126;
})();