function isOdd(number) {
    return number % 2 != 0;
}

function isEven(number) {
    return !isOdd(number);
}

function getRandom(minNumber, maxNumber) {
    return Math.ceil((Math.random() * (maxNumber - minNumber) + minNumber));
}