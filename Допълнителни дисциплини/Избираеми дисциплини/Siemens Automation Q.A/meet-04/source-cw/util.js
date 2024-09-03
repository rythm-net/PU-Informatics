// function isEven(number) {

//     const result = number % 2 == 0;
//     return result;
// }

function isOdd(number) {

    // const result = number % 2 != 0;
    // return result;

    return number % 2 != 0;
}

function isEven(number) {
    return !isOdd(number);
}

function getRandom(minNumber, maxNumber) {
    return Math.ceil((Math.random() * (maxNumber - minNumber) + minNumber));
}