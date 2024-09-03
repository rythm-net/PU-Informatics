// const number1Button =  document.getElementById("number-1");
const numberButtonCollection    = document.getElementsByClassName("number");
const operationAdd              = document.getElementById("operation-add");
const operationSub              = document.getElementById("operation-sub");

const opeationCalculation = document.getElementById("operation-calculation");
const display             = document.getElementById("display");

let calculatorSum = null;
let operator      = 0;
let currentOperation = null;

for(let i = 0; i < numberButtonCollection.length; i++) {

    const element   = numberButtonCollection[i];
    const text      = +element.getAttribute('data-number');

    element.addEventListener('click', () => {
        operator            = text;
        display.innerHTML   = text;
    });
}

operationAdd.addEventListener('click', () => {

    currentOperation    = 'add';
    calculatorSum       = calculatorSum + operator;
    display.innerHTML   = calculatorSum;
});

operationSub.addEventListener('click', () => {

    currentOperation    = 'sub';

    if(calculatorSum == null) {
        calculatorSum = operator;    
    }
    else {
        calculatorSum       = calculatorSum - operator; // -1
    }

    display.innerHTML   = calculatorSum;
});

opeationCalculation.addEventListener('click', () => {

    if(currentOperation == 'add') {
        calculatorSum       = calculatorSum + operator;    
    }

    if(currentOperation == 'sub') {
        calculatorSum       = calculatorSum - operator;
    }

    display.innerHTML = calculatorSum;
});