// # Седмица 4 - Java Script в дълбочина 
// # =================================================================================================================

// Преговор
//  създайте функция която приема масив от обекти съдържащи свойствата min, max, avg
// * да се върнат всички обекти чиито min свойства са по-големи от 10
// * да се върнат всички обекти сумата на които min и max е четно число
// * да се върнат всички обекти които нямат avg свойство или то е нулева стойност

var objectCollection = [
    { min: 10, max: 100, avg: 50},
    { min: 25, max: 150, avg: 75},
    { min: 1, max: 10,   avg: 5 },
    { min: 0, max: 78,   avg: 43},
    { min: 5, max: 271,  avg: 3 },
    { min: 10, max: 10,  avg: 5 }
];

var filterCallback = function(collection, callback) {
    // Base function

    var expressionResult = null;
    var resultCollection = [];
    for(var i = 0; i < collection.length; i++) {
        
        // Exmple 1:
        expressionResult = callback(collection[i]);
        if(expressionResult) {
            resultCollection.push(collection[i]);
        }

        // Example 2:
        // if(callback(collection[i])) {
        //     resultCollection.push(collection[i]);
        // }

        // Example 3: NO NO NO NO NO NO NO
        // if(callback(collection[i])) 
        //     resultCollection.push(collection[i]);
        //     resultCollection.push(collection[i]);
        
            
    }

    return resultCollection;
};


filterCallback(objectCollection, function(objectElement) {

    // Example 1: return element 
    // if(objectElement.min > 10) {
    //     return objectElement;
    // }

    // Example 2:true / false expression
    return (objectElement.min > 10) ;
});


filterCallback(objectCollection, function(objectElement) {

    // Example 1
    // var expressionCalulation = (objectElement.min + objectElement.max);
    // return (expressionCalulation % 2 == 0 );

    // Example 2
    // return ((objectElement.min + objectElement.max) % 2 ) == 0;
});

filterCallback(objectCollection, function(objectElement) {
    
    // Example 1
    // if(objectElement.avg == 0) {
    //     return true;
    // }

    // if(objectElement.avg == undefined) {
    //     return true;
    // }

    // if(objectElement.avg == null) {
    //     return true;
    // }    

    // return false;

    // Example 2 : Expression
    // return (objectElement.avg == 0) || 
    //        (objectElement.avg == undefined) || 
    //        (objectElement.avg == null);


    // Example 
    return !objectElement.avg;
});



// Object in JS
// var o = {};
// var objectNew = {
//     propertyOne : "value1"
// };

// var objectSeparated = {};
// objectSeparated.propertySeparated = "separatedValue";

//var objectObject = new Object();


// Example object instance

// Създайте обект, потребител, който съдържа следните свойства 
// * първо име
// * фамилия
// * факултетен номер
// * възраст
// * родно място
// * списък с изучавани дисциплини

var firstName = "Pesho";
var lastName = "Peshev";


var Student = {}; // $123

// namespace


// inner object
Student = { // $124

    // inner 

    fullName : function() {
        return Student.firstName + ' ' + Student.lastName;
    },

    firstName: 'Mihail',
    lastName: 'Petrov',
    uniNumber: '1101261005',
    age: 27,
    city: 'Plovdiv',
    subjectCollection: ['Intro to programing 1', 'Intro to programing 2', 'Intro to JS'],
    mentorObject : {
        primaryMentor: 'Vladimir Valkanov',
        secondary: 'Stanimir Stojanov'
    }
};

Student.getMyAge = function() { // $124 
    return Student.age;
}

// namespace 
var objectConstructor = function(firstName) {

    var Blueprint = {
        firstName: null,
        sayMyName : function() {
            return Blueprint.firstName
        }
    };

    Blueprint.firstName = firstName;
    return Blueprint;
};


// var Ivan    = objectConstructor("Ivancho");
// var Dragan  = objectConstructor("Drancho");

// console.log(Ivan.sayMyName())
// console.log(Dragan.sayMyName())




// console.log(Student.firstName);
// console.log(Student.subjectCollection[0]);
// console.log(Student.mentorObject.primaryMentor);
// Student.firstName = "Ivan";
// Student.subjectCollection[0] = "Intro to C#";
// Student.mentorObject.primaryMentor = "Nikola Vulchanov";
// console.log(Student.firstName);
// console.log(Student.subjectCollection[0]);
// console.log(Student.mentorObject.primaryMentor);
// console.log("=====")
// console.log(Student.fullName());
// console.log(Student.getMyAge()); // 27


// създайте инстанция на обекта с вашето име и дефинирайте стойности които са характерни за вас


// да се създаде форма за добавяне на потребители - студенти
var divElement = document.getElementById("util");

// shortcut 
// divElement.innerHTML = "<h1>Hello World</h1>";
// divElement.style.background = "#ff0000";
// console.log(divElement); 


// DOM parser
var newDivElement = document.createElement("div");
var newHelloWorldTextNode = document.createTextNode("Hello World from TExt Node");
newDivElement.appendChild(newHelloWorldTextNode);
divElement.appendChild(newDivElement);

// HTML parser
//divElement.innerHTML = "<div>Hello World</div>";

var textElement = function(element, text) {

    // get element 
    var innerElement = document.getElementById(element);

    // create text node 
    var textNode = document.createTextNode(text);

    // append text node to innerElement
    innerElement.appendChild(textNode);
};

textElement("util", "This is abstract text method");

var DOMat = {
    get: function(id) {
        return document.getElementById(id);
    },

    text: function(id, text) {

        // console.log("=====")
        // console.log(this);
        // console.log(DOMat);
        // console.log("=====")        

        var innerElement = this.get(id);
        var textNode = document.createTextNode(text);
        innerElement.appendChild(textNode);
    }
};

//DOMat.text("util", "DOMat mu e maikata");


// get elements by class
// var element = document.getElementsByClassName("form-input");
// console.log(element);

// getElementsByTagName
// document.getElementsByName


// var queryElement = document.querySelector(".form-input");
// var queryElement = document.querySelectorAll(".form-input");
// console.log("*");
// console.log(queryElement);

var studentCollection = [];

var createNewStudent = function(firstName, lastName) {

    var StudentBlueprint = {
        fname: null,
        lname: null
    };

    StudentBlueprint.fname = firstName;
    StudentBlueprint.lname = lastName;

    return StudentBlueprint;
};



// Student form elements
var studentFirstName = document.getElementById("student--first-name");
var studentLastName  = document.getElementById("student--last-name");
var actionSaveStudent = document.getElementById("action-student--save-student");


// Dosie form elements
var dosieFirstName = document.getElementById("dosie--first-name");
var diesLastName = document.getElementById("dosie--last-name");

// List element
var listCollection = document.getElementById("list");

studentFirstName.addEventListener('input', function(e) {
    //console.log("Type Type Type");
    //dosieFirstName.innerHTML = studentFirstName.value;
    //console.log(e);

    // dosieFirstName.innerHTML += e.data;

    dosieFirstName.innerHTML = studentFirstName.value;
});

studentLastName.addEventListener('input', function() {
    diesLastName.innerHTML = studentLastName.value;
});

actionSaveStudent.addEventListener('click', function(e) {

    e.preventDefault();

    var newStudent = createNewStudent(studentFirstName.value, studentLastName.value);
    studentCollection.push(newStudent);
    //console.log("Save student")
    //console.log(studentFirstName.value);
    //console.log(studentLastName.value);

    var domFragmentCollection = [];
    for(var i = 0; i < studentCollection.length; i++) {
        var element = "<h1>" + studentCollection[i].fname + "</h1><h2>" + studentCollection[i].lname + "</h2>";
        domFragmentCollection.push(element);
        
        // "<h1>Mihail</h1></h2>Petrov</h2>";
        // listCollection.innerHTML += "<h1>" + studentCollection[i].fname + "</h1><h2>" + studentCollection[i].lname + "</h2>";
    }

    var collectionJoin = domFragmentCollection.join('');
    listCollection.innerHTML = collectionJoin;
});



// да се създаде, форма за визуализация на потребители