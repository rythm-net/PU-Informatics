// Задача 1
// На терминала клиентът трябва да въведе серийния номер на своята карта. Това е цяло число, което има скрито значение. (Внимание: Това число си го измисляте вие и не го получавате от никъде. Просто, за да е по-интересна историята си представете, че са ви го дали преди да го въведете).

//Ако номерът съдържа повече от 2 цифри - гражданинът е от тип POOR
//Ако клиентският номер съдържа повече от 6 цифри, то гласуващият е RICH
//Ако съдържа 6 цифри, то значи е NORMAL

// Вариант на решаване на задачата с помоща на IF ELSE
// const voteCardNumber = 123;
// const isTypeNormal   = (voteCardNumber <= 999999) && (voteCardNumber >= 100000);
// const isTypeRich     = voteCardNumber > 999999;
// const isTypePoor     = voteCardNumber > 99; 

// if(isTypeNormal) {
//     console.log('Гласуващия е НОРМАЛЕН');
// }
// else if(isTypeRich) {
//     console.log("Гласуващия е БОГАТ");
// }
// else if(isTypePoor) {
//     console.log("Гласуващия е БЕДЕН");
// }


const voteCardNumber = 1234567;
const isTypeNormal   = (voteCardNumber <= 999999) && (voteCardNumber >= 100000);
const isTypeRich     = voteCardNumber > 999999;
const isTypePoor     = (voteCardNumber > 99) && (!isTypeNormal) && (!isTypeRich);

if(isTypeNormal) {
    console.log('Радваме се, че нормални хора вече гласуват');
}
if(isTypeRich) {
    console.log("Има за нас, има и за вас");
}
if(isTypePoor) {
    console.log("Хайде по-бързо и да те няма");
}


// Задача 3
// Всички гласували, чиито номера завършват на четно число, са VIP гласували, а останалите са обикновени такива.

// Пример: 105468 е четно число и клиентът е VIP
// Пример: 115485 е нечетно число и клиентът няма специални правомощия

const isVoterVIP = (voteCardNumber % 2 == 0);

// Задача 4
// Ако предпоследната цифра на номера на гласувалия е число по-голямо от 3, то веднага след успешно гласуване той трябва да бъде попитан, дали укрива данъци:

// ако отговорът е положителен - изведете съобщението “Браво моето момче”
// в противен случай изведете съобщението “Будала”

const isVoterPotentialTaxFround = (parseInt((voteCardNumber % 100) / 10)) > 3;

if(isVoterPotentialTaxFround) {

    const questionFlag              = prompt("Укриваш ли данъци - Y/N");
    const isVoterActualTaxFroud     = (questionFlag == 'Y');
    const message                   = isVoterActualTaxFroud ? `Браво моето момче` : `Будала`;
    console.log(message);

    // if(questionFlag == 'Y') {
    //     console.log(`Браво моето момче`)
    // }
    // if(questionFlag == 'N') {
    //     console.log(`Будала`);
    // }

}

// Задача 5
// Ако гласуващият е VIP и не укрива данъци, то това означава, че той е със специален SUPER VIP статус и това му дава възможност да получи баничка след като напусне тъмната стая, но само с негово изрично съгласие.

// Ако иска баничка, изведете съобщение - “Не може”
// Ако не иска баничка, изведете съобщение - “Ами, то и без това няма”
// const isVoterSuperVip = isVoterVIP == true  && (isVoterActualTaxFroud == false);
// const isVoterSuperVip   = isVoterVIP  && (isVoterActualTaxFroud == false);
const isVoterSuperVip   = isVoterVIP  && !isVoterActualTaxFroud;

if(isVoterSuperVip) {

    const flagQuestion = prompt("Искаш ли баничка Y/N");
    var doesVoterRefuseExtraBanichka = (flagQuestion != "Y")

    if(flagQuestion == 'Y') {
        console.log("Не може");
    }
    else {
        console.log("Ами , то и без това ням");
    }
}

// задача 6
console.log("Бюлетина 1");
console.log("Бюлетина 27");
console.log("Бюлетина 666");
console.log("Бюлетина 999");
const partNumber = prompt("Избери си партия");

const isVoterExtraCharged = (doesVoterRefuseExtraBanichka) 
                            && 
                            (partNumber == 27) 
                            && 
                            isTypeNormal;

if(partNumber == 1) {
    console.log("Вие си поръчахте да ви управлява Партия за прогресивен канибализъм");
}
else if(partNumber == 27) {
    console.log("Вие си поръчахте да ви управлява Замундска вегетарианска партия");
}
else if(partNumber == 666) {
    console.log("Вие си поръчахте да ви управлява Синдикат на вуду-трактористите");
}
else if(partNumber == 999) {
    console.log("Вие си поръчахте да ви управлява Партия на труда, мотиката и наковалнята");
}

if(isVoterExtraCharged) {
    console.log("Живота е гаден дай един допълнителен банан");
}