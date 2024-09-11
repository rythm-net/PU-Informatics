var callbackVariableReference;
var anonimusConsoleLog;
var anonimusFunction;
// startScreenFunctionNew();

startScreenFunction();

function startScreenFunction() {
    console.log("*Hello World");

    // return "Hello World";
    return undefined;
}

callbackVariableReference = startScreenFunction();
console.log(callbackVariableReference);


anonimusConsoleLog();
undefined();

anonimusConsoleLog = function() {
    console.log("Anonimus call");
}

anonimusConsoleLog();


anonimusFunction = function() {
    var scoreExpression;
    scoreExpression = 126;
    return scoreExpression;
}

console.log(anonimusFunction());
//
(function() {
    return 126;
})();