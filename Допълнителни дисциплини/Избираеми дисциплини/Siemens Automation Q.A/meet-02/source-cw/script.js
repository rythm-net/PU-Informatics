// #задача 1
// На терминала клиента трябва да въведе серийния номер на своята карта. Това е цяло число което има скрито значение. Серийния номер съдържа по 6 цифри, по принцип, но на някой клиенти са дадени различни номера. Ако номера съдържа повече от 2 цифри клиента е от тип EARLY_ADOPTER ако клиентския номер съдържа повече от 6 цифри то клиента е LAGGER ако съдържа 6 цифри значи е NORMAL.

const EARLY_ADOPTER_COEFICIENT      = 99;
const NORMAL_USER_COEFICIENT        = 100000;
const LAGGER_USER_COEFICIENT        = 999999;
const SECOND_MEAL_ALICATION_DIGIT   = 3; 

const customerNumber = 49851564414;
// най-малко  - 100000
// най-голямо - 999999 

// числото трябва да е по-голямо или равно на 100000
const isCustomerNumberGreaterThan100000   = customerNumber >= NORMAL_USER_COEFICIENT;

// числото трябва да е по-малко или равно на 100000
const isCustomerNumberLowerThan999999     = customerNumber <= LAGGER_USER_COEFICIENT;

// ЛОГИЧСКО И  .....   &&
// връща стойност ДА(истина) - когато всички отговори са ДА(истина)
// когато отговарям с ДА -- числото 1
// когато отговарям с НЕ -- числото 0
// ЛОГИЧЕСКО И -- ариметична операция -- УМНОЖЕНИЕ
const isCustomerNumber6Digit = isCustomerNumberGreaterThan100000 
                             &&
                             isCustomerNumberLowerThan999999;

// оптимизирана версия на кода 
const isCustomerNormal =  (customerNumber >= NORMAL_USER_COEFICIENT) 
                        && 
                        (customerNumber <= LAGGER_USER_COEFICIENT);


const isCustomerEarlyAdopter = (customerNumber > EARLY_ADOPTER_COEFICIENT)
                             &&
                             (customerNumber < NORMAL_USER_COEFICIENT);

const isCustomerLagger = customerNumber > LAGGER_USER_COEFICIENT;

// Работа с условни конструкции
// в5инаги между отварящата и затваряща малка скоба слагаме ИЗРА който връща TRUE / FALSE
if(isCustomerNormal) {
    console.log(`Потребителя е НОРМАЛЕН`);
}

if(isCustomerEarlyAdopter) {
    console.log(`Потребителя е НАХЪСАН да купува`);
}

if(isCustomerLagger) {
    console.log(`Потребителя е закъснял много`);
}

// Аритметични оператори 
//  + 
//  - 
//  * 
//  /

// Задача 2
// Всички клиенти чиито номера завършват на четно число са VIP клиенти а останалите са обикновени такива. Пример : 105468 четно число клиента е VIP Пример : 115485 нечетно число клиента няма специални правомощия
const isCustomerVIP = (customerNumber % 2) == 0;

// #задача 3
// Ако пред последната цифра на номера на клиента е число по голямо от 3, клиента има право да поръча допълнително второ ястие, в противен случай няма да има такава възможност.

//  123456
const getNextToLastDigit            = parseInt((123456 % 100) / 10); // 5.6
const isCustomerApplicableForSecondMeal = getNextToLastDigit > SECOND_MEAL_ALICATION_DIGIT; 

// #задача 4
// Ако клиента е VIP и има право да направи повторна поръчка то това означава че клиента е със специален SUPER VIP статус и това му дава възможност да получи отстъпка от цената на всички артикули които е поръчал.

const isCustomerSuperVIP = isCustomerVIP && isCustomerApplicableForSecondMeal;

// #задача 5

// Да се изведе меню със всички поръчки които клиента може да направи, за да се направи избор за храната е необходимо да се избере, номера на поръчката. В експерименталната програма, в която участват тези продукти е необходимо да няма възможност тяхната стойност да се променя.

console.log(`1. Пица - 2 лв`);
console.log(`2. Паста - 3 лв`);
console.log(`3. Пържола - 4 лв`);

const orderId = prompt("Номер на поръчката");

// Условни конструкции само с IF
// if(orderId == 1) {
//     console.log("Ти поръча пица");
// }

// if(orderId == 2) {
//     console.log("Ти поръча паста");
// }

// if(orderId == 3) {
//     console.log("Ти поръча пържола");
// }

// if(orderId < 1 && orderId > 3) {
//     console.log("Невалидна поръчка - самоунищожавам се");
// }

// Условни конструкции с ELSE

var priceToPay = 0;

if(orderId == 1) {
    console.log("Ти поръча пица");
    priceToPay = 2;
}
else if(orderId == 2) {
    console.log("Ти поръча паста");
    priceToPay = 3;
}
else if(orderId == 3) {
    console.log("Ти поръча пържола");
    priceToPay = 4;
}
else {
  console.log("Невалидна поръчка - самоунищожавам се");  
  priceToPay = 1;
}

// #задача 8
// Разработчиците експериментирали с нова функционалност, която да дава нечество предимство на тайни потребители, които текстват системата. След като научат цената на поръчката, потребителите с код ЧЕТНО ЧИСЛО , могат да въведат своята възраст.

// Ако потребителя е непълнолетен - той заплаща 0 лв
// АКо потребителя е точно на 18 години стойността на поръчката му се увеличава с 10 лв
// Ако потребителя е в категория до 35 години стойността на поръчката му се увеличава с 5 лв
// Ако потребителя е на 65 години получава добавка за старост от 60 лв - стойността на поръчката му е цената до момента - добавката
// При всички останали случай потребителя си плаща като пич.

if(isCustomerVIP) {

    const customerAge = prompt("На колко си години");

    if(customerAge < 18 ) {
        priceToPay = 0;
    }
    else if(customerAge == 18) {
        priceToPay = priceToPay + 10;
    }
    else if(customerAge == 21 || customerAge == 22) {
        priceToPay = 0;
    }
    else if(customerAge <= 35) {
        priceToPay = priceToPay + 5;
    }
    else if(customerAge == 65) {
        priceToPay = priceToPay - 60;
    }

    // if(customerAge < 18 ) {
    //     priceToPay = 0;
    // }
    
    // if(customerAge == 18) {
    //     priceToPay = priceToPay + 10;
    // }
    
    // if(customerAge <= 35) {
    //     priceToPay = priceToPay + 5;
    // }
    
    // if(customerAge == 65) {
    //     priceToPay = priceToPay - 60;
    // }
}