describe('As an application user I wish to test all of the calculator basic operations', () => {

    it('should test basic addition, 1 + 1 must equals 2', () => {

        // arange
        const number1DomElement                 = get("number-1")
        const operationAddDomElement            = get("operation-add");
        const operationCalculationDomElement    = get("operation-calculation");
        const displayDomElement                 = get("display");

        // act
        number1DomElement.click();
        operationAddDomElement.click();
        number1DomElement.click();
        operationCalculationDomElement.click();

        // assert
        assert.isEquals(displayDomElement.innerText, 2);
    });


    it('should test basic substraction, 1 - 1 must equals 0', () => {

        const number1DomElement                 = get("number-1")
        const operationSubDomElement            = get("operation-sub");
        const operationCalculationDomElement    = get("operation-calculation");
        const displayDomElement                 = get("display");        

        number1DomElement.click();
        operationSubDomElement.click();
        number1DomElement.click();
        operationCalculationDomElement.click();

        // assert
        assert.isEquals(displayDomElement.innerText, 0);
    })
});



// // Като потребител на системата - трябва да мога
// // да избера числа и операция събиране 
// // и да изведа коректен резултат на екрана
// function testBasicAddition() {

//     console.log("Test basic addition. 1 + 1 must equals 2");

//     // взимам всички DOM елементи които ще кликам
//     const number1DomElement = document.getElementById("number-1");
//     const operationAddDomElement = document.getElementById("operation-add");
//     const operationCalculationDomElement = document.getElementById("operation-calculation");
//     const displayDomElement = document.getElementById("display");

//     // избирам числото 1 и го кликам
//     number1DomElement.click();
//     // избирам операция + и я крикам
//     operationAddDomElement.click();
//     // избирам числото 1 и го кликам
//     number1DomElement.click();

//     // избирам операция = и я кликал
//     operationCalculationDomElement.click();

//     // верифицирай текущия резултат
//     const currentValue = displayDomElement.innerText;
//     if(currentValue == 2) {
//         console.info("SUCCESS");
//     }
//     else {
//         console.error(`FAIL - current value ${currentValue} expected 2`);
//     }
// }

// function testBasicSubstraction() {

//     console.log("Test basic substraction. 1 - 1 must equals 0");

//     // взимам всички DOM елементи които ще кликам
//     const number1DomElement                 = document.getElementById("number-1");
//     const operationSubDomElement            = document.getElementById("operation-sub");
//     const operationCalculationDomElement    = document.getElementById("operation-calculation");
//     const displayDomElement                 = document.getElementById("display");

//     // избирам числото 1 и го кликам
//     number1DomElement.click();
//     // избирам операция - и я крикам
//     operationSubDomElement.click();
//     // избирам числото 1 и го кликам
//     number1DomElement.click();

//     // избирам операция = и я кликал
//     operationCalculationDomElement.click();

//     // верифицирай текущия резултат
//     const currentValue = displayDomElement.innerText;
//     if(currentValue == 0) {
//         console.info("SUCCESS");
//     }
//     else {
//         console.error(`FAIL - ${currentValue} expected 0`);
//     }
// }

// // извикване на функция
// testBasicAddition();
// testBasicSubstraction();