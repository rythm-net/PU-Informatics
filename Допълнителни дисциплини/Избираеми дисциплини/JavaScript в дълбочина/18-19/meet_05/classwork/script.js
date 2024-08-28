// Revision
var Object = {};
var ObjectFactory = function (name, age) {
    var ObjectBluePrint = {
        //
    };
    return ObjectBluePrint;
};


var TodoTask = function (taskTitle, taskPriority, taskStatus) {

    var internalFunction = function () {
        return 1025;
    };
    this.title = taskTitle;
    this.priority = taskPriority;
    this.status = internalFunction();
    this.getTaskSignature = function () {
        return this.title + " * " + this.priority + " * " + this.status;
    }
    // Example with returning opbject
    // return "Hello World";
    // When used with NEW keyword
    // return {
    // title : "Sample task",
    // priority : '10',
    // status : 'Done'
    // };
};
// {}
TodoTask.prototype.examplePrototype = function () {
    return "Example for task " + this.title;
};
var objectTodoTask = {
    title: "Sample task",
    priority: '10',
    status: 'Done'
};
var basicTask = new TodoTask("Sample task constructor", 10, "Done");
var complexTask = new TodoTask("Comple", 5, "Doing");
var noNewTask = TodoTask("Comple", 5, "Doing");
console.log(basicTask);
console.log(basicTask.getTaskSignature());
console.log(complexTask);
console.log(complexTask.getTaskSignature());
console.log(noNewTask);
console.log(objectTodoTask);
console.log("*********")
// No No: Only object literals - Not functions
//console.log(TodoTask.getTaskSignature());
// No No : undefined
//console.log(TodoTask().getTaskSignature());
// console.log((TodoTask()).split());
// console.log("Hello World".split());
//console.log((new TodoTask()).getTaskSignature());
console.log((new TodoTask()));