// Декларирайте булева променлива IS_DEBUG_ON и променлива от низов тип APPLICATION_MODE. 

// Инициализирайте ги с произволни стойности.
var IS_DEBUG_ON = true;
var APPLICATION_MODE = "Development";

// Декларирайте обект ApplicationUtil който да съдържа една единствена функция print. 

// Разпишете функцията ApplicationUtil така че да приема един единствен аргумент и да го печата на конзолата на браузъра

// Разпишете функцията ApplicationUtil.print така че да има възможност печатаният елемент да се огради с допълнителен стринг 
// които да декорита печатаната стойност 
// Пример :
// $ * Hello World *
// $ ^^ Hello World ^^


var ApplicationUtil = {

    print: function(element, separator) {

        var separatorReferenceFunction = function(separator) {

            // Example 4
            if(separator) {
                return separator;
            }
             
            return " -- ";


            // Example 3
            // return (separator) ? separator : " -- ";
            
            // Example 2
            // var separatorreference = (separator) ? separator : " -- ";
            // return separatorreference;

            // Example 1
            // if(separator) {
            //     return separator;
            // }
            // else {
            //     return " -- ";
            // }
        };


        // Example with Gards
        // ================================================      
        var separatorReferance = null;
        var elementReference = null;

        //separatorReferance  = (separator) ? separator : "" 
        separatorReferance  = separatorReferenceFunction(separator);

        elementReference    = (element) ? element : "Sorry example 4 "; 

        // if(separator) {
        //     separatorReferance = separator;
        // }
        // else {
        //     separatorReferance = "";
        // }

        


        // if(element) {
        //     elementReference = element;
        // }
        // else {
        //     elementReference = "Sorry example 3 ";
        // }

        var printResult = separatorReferance + " " + elementReference + " " + separatorReferance;

        if(IS_DEBUG_ON) {
            console.log(printResult);
        }

        // Example with If - Else
        // ================================================
        // if(separator) {

        //     var printResult = separator + " " + element + " " + separator;
        //     console.log(printResult);
        // }
        // else {

        //     if(element) {
        //         var printResult = element;
        //         console.log(printResult);
        //     }
        //     else {
        //         console.log("Sorry");
        //     }
        // }

        // Original example
        // ================================================
        // var printResult = separator + " " + element + " " + separator;
        // console.log(printResult);
    }
};

var procedureRef = ApplicationUtil.print("Hello World week 2");
var procedureRef = "Hello World";
console.log(procedureRef);


function functionOverloadingJs(element) {
    console.log("First instance");
};

function functionOverloadingJs(element, separator) {
    console.log("Overloaded example");
};

functionOverloadingJs();
functionOverloadingJs("Hello world");
functionOverloadingJs("Hello world", "*");


// example with no arguments
ApplicationUtil.print();

// example with separator
 ApplicationUtil.print("Hello World", "*");

// example without separator
 ApplicationUtil.print("Hello World");

// example with many elements
ApplicationUtil.print("Hello World", "*", 10, {}, []);

// Контакетаниця на стрингове примерен код 
// ==================================================================
// concat strings
var template = "Hello : ";
var username = "Mihail";
var templateHelloString = template + username;
console.log(templateHelloString);

// concat string and number
var template = "Total sum : ";
var totalSum = 10;
var templateTotalSum = template + totalSum;
console.log(templateTotalSum);

// concat string numbers
var stringNumberBase = "10";
var stringNumberPow = "2";
var templateStringNumbers = stringNumberBase + stringNumberPow;
console.log(templateStringNumbers);

// concat string and number
var stringNumberBaseNumber = 10;
var stringNumberPowString = "2";
var templateStringWithNumber = stringNumberBaseNumber + stringNumberPowString;
console.log(templateStringWithNumber);


// If example
var numberReference = 10;
// false
// undefined
// 0
// null
if(numberReference > 10) {
    console.log("Expression is true");
}
else {
    console.log("Expression is false");   
}



// * Разширете функцията UTIL.printMulty така че да приема произволен брой аргументи и да ги печата на екрана едно по едно
//ApplicationUtil.printMulty("a", "b", "c", "d");

ApplicationUtil.printMulty = function(test) {
    // for // while // do-while // for in

    for(var i = 1; i < arguments.length; i++) {
        console.log(arguments[i]);
    }

    console.log(arguments);
    var collection  = [1,2,3,4,5,6,7,8]
    var arrayLength =  collection.length;

    for(var i = 0; i < arrayLength; i++) {
        console.log('Loop element');
        console.log(collection[i]);
    }
};

ApplicationUtil.printMulty();
console.log("====")
ApplicationUtil.printMulty("a");
console.log("====")
ApplicationUtil.printMulty("a", 10);

// Да се състави функция която клонира масиви. Какво ли значи това ? :)
var collectionA = [1,2,3,4,5,6,7,8];
var collectionB = collectionA;
//var collectionC = copyArrayCollection(collectionA);
var collectionC = copyArrayCollection([]);


function copyArrayCollection(collectionReference) {

    // $
    // Array.isArray(collectionReference)

    // Check for instance
    console.log("-")
    console.log(collectionReference instanceof Array);
    console.log(typeof collectionReference);

    // if(!collectionReference) {
    //     return [];
    // }

    // if(!collectionReference.length) {
    //     return [];
    // }

    // var arrayBuffer = collectionReference[0];
    // collectionReference[0] = '$';


    console.log("@@");
    console.log(collectionReference.length);
    console.log("@@");

    var arrayCopy = [];
    for(var i = 0; i < collectionReference.length; i++) {
        // Example 1
        //arrayCopy[i] = collectionReference[i];

        // Example 2 : build in methods
        //arrayCopy.push(collectionReference[i]);
    }

    return arrayCopy;
}


// collectionB[0] = 100;

// var stringCollection = "Hello world";

console.log("Collection Example clone")
collectionB[0] = 100;
console.log(collectionA);
console.log(collectionB);
console.log(collectionC);
console.log(stringCollection[1]);
stringCollection[0] = 'Y';
console.log(stringCollection);


for(var i = 0; i < stringCollection.length; i++) {
    console.log(stringCollection[i]);
}