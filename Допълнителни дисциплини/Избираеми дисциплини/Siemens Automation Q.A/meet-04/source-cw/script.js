// конфигурационни константи

// годината спрямо която определяме, 
// какъв ще бъде типът на потребителя
const CONFIGURATION_CUSTOMER_YEAR = 1965;

// Всички стойности на клиентската карта
var customCardFirstDigit   = 0;
var customCardSecondDigit  = 0; 
var customCardThirdDigit   = 0; 
var customCardFourthDigit  = 0; 
var customCardFifthDigit   = 0; 
var customCardSixtDigit    = 0; 

function generateFirstDigit() {

    var generatedDigit   = 0; 

    // Първа цифра
    const customerYearOfBirth   = 1992;
    const currentYear           = (new Date()).getFullYear(); // ?? какво забога е това
    const customerAge = currentYear - customerYearOfBirth;

    function getFirstDigit() {

        const customerRandomCoeficient = getRandom(1, 7);
        return parseInt(customerAge / customerRandomCoeficient);
    }

    function isProcessable(number) {
        return isOdd(number) || (number >= 10);
    }

    // цифрата трябва да е ЧЕТНА
    if(customerYearOfBirth > CONFIGURATION_CUSTOMER_YEAR) {

        do {
            generatedDigit = getFirstDigit();
        } while(isProcessable(generatedDigit))
    }

    // цифрата трябва да е НЕЧЕТНА
    if(customerYearOfBirth < CONFIGURATION_CUSTOMER_YEAR) {

        do {
            generatedDigit = getFirstDigit();
        } while(isEven(generatedDigit) || (generatedDigit >= 10))
    }

    return generatedDigit;
}
