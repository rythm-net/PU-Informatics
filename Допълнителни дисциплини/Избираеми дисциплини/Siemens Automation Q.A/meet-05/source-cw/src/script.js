// Всички стойности на клиентската карта
var customCardFirstDigit   = generateFirstDigit();
var customCardSecondDigit  = generateSecondDigit(customCardFirstDigit); 
var customCardThirdDigit   = generateThirdDigit(); 
var customCardFourthDigit  = generateFourthDigit(); 
var customCardFifthDigit   = generateFifthDigit(); 
var customCardSixtDigit    = generateSixthDigit(
                            customCardFirstDigit, 
                            customCardSecondDigit,
                            customCardThirdDigit, 
                            customCardFourthDigit,
                            customCardFifthDigit ); 

console.log(
    `${customCardFirstDigit}${customCardFifthDigit}${customCardThirdDigit}${customCardFourthDigit}${customCardFifthDigit}${customCardSixtDigit}`
);

// // да се напише функция - която повдига число на квадрат
// function square(number) {
//     return number * number;
// }

// function squareAdd5(number) {
//     return (number * number) + 5;
// }

// // да се напише функция - която повдига число на куб
// function cube(number) {
//     return number * number * number;
// }

// // без конкретно тяло
// function calculate(number, callback) {
//     return callback(number);
// }

// var squareResult = calculate(10, function(number) {
//     return number * number;
// })

// var squareResultAndExtraNumber = calculate(10, function(number) {
//     return (number * number) + getRandom(1,5);
// })


// function increment() {

//     var number = 0;
//     // number++;
//     // return number;

//     return ++number;
// }

// var externalVariable = increment();
// console.log(externalVariable);


// var dataCollection = [1,2,3,4,5];
// console.log(dataCollection[0]);

// var dateOfBirth1 = prompt("Въведи година на раждане");
// var dateOfBirth2 = prompt("Въведи година на раждане");

// console.log(+dateOfBirth1[3]);
// console.log(+dateOfBirth2[3]);