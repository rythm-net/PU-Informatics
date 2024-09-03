/**
 * Тази функция изчислява потребителдката цифра на базата на 
 * - дата на раждане
 * - случаен фактор разработен от нашите лични учени
 * @returns 
 */
function generatefunctionalCoeficient() {

    // Първа цифра
    const customerYearOfBirth   = 1992;
    const currentYear           = (new Date()).getFullYear(); // ?? какво забога е това
    const customerAge = currentYear - customerYearOfBirth;

    // присвои стойност на глобална променлива
    globalConfig.setCustomerAge(customerAge);
    // globalConfig.customerAge      = customerAge;
    // globalConfig.isCustomerAdoult = customerAge >= 18;

    const customerRandomCoeficient = getRandom(1, 7);
    return parseInt(customerAge / customerRandomCoeficient);
}

function calculateCoeficient(callback) {

    var generatedDigit = 0;

    do {
        generatedDigit = generatefunctionalCoeficient();
    } while(callback(generatedDigit))

    return generatedDigit;
}


function generateFirstDigit() {

    var generatedDigit   = 0; 

    // цифрата трябва да е ЧЕТНА
    if(customerYearOfBirth > CONFIGURATION_CUSTOMER_YEAR) {
        
        // вариант 1 - анонимна функция - класически запис
        // calculateCoeficient(function() {
        //     return isOdd(generatedDigit) || (generatedDigit >= 10);
        // });
        
        // вариант 2 - анонимна функция - ЛАМБДА
        // calculateCoeficient(() => {
        //     return isOdd(generatedDigit) || (generatedDigit >= 10);
        // });        

        // вариант 2.1 - ЛАМБДА, която само връща една сотйност и не прави други неща
        generatedDigit = calculateCoeficient(() => isOdd(generatedDigit) || (generatedDigit >= 10) );
    }

    // цифрата трябва да е НЕЧЕТНА
    if(customerYearOfBirth < CONFIGURATION_CUSTOMER_YEAR) {
        generatedDigit = calculateCoeficient(() => isEven(generatedDigit) || (generatedDigit >= 10));
    }

    return generatedDigit;
}
