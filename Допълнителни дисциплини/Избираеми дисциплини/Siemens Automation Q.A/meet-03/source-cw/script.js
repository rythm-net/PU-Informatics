// Робота има нужда от система за навигация, трябва да получава входни данни какъв е типът на обекта който се намира пред него, стена, стол или нищо. Ако пред него има стена, то той трябва да се обърне на ляво или на дясно. Ако пред него има стол то той трябва да го прескочи ако няма нищо трябва да продължи напред. 
// Програмата на робота трябва да приеме входните данни и да му даде команда Forward / Jump / Go Sideway

const HIT_COEFICIENT        = 5; 
const MAX_NUMBER_OF_HITS    = 4;

var isRobotTurnOn           = true;
var numberOfAvailableHits   = MAX_NUMBER_OF_HITS;

while(isRobotTurnOn) {

    const objectInFrontOfMe = prompt("Какъв обект има пред мен");
    // 1 - стена
    // 2 - стол 
    // 3 - нищо 
    // 0 - нищо

    if(objectInFrontOfMe == 1) {
        alert("Go Sideway");
    }

    if(objectInFrontOfMe == 2) {
        alert('Jump');
    }

    if(objectInFrontOfMe == 3) {
        alert('Forward');
    }

    if(objectInFrontOfMe == 0) {

        alert("Robot turn offfff");
        isRobotTurnOn = false;
    }

    // задача 2.1
    const numberOfEnvPixels = prompt("Засечени пиксели от заобикалящия ни терен");
    const isMouseDetected   = numberOfEnvPixels % 2 == 0;

    // TODO: да не забравя да извадя направения удар от numberOfAvailableHits
    // задача 2.2
    const isBatteryFull     = numberOfAvailableHits > 0;

    if(!isBatteryFull) {

        alert("Свърши ми тока - отивам да зареждам");

        do {
            const phaseCoeficient = Math.floor(Math.random() * (1000 - 1) + 1);
            const zeroCoeficient  = Math.floor(Math.random() * (1000 - 1) + 1);
    
            if(phaseCoeficient > zeroCoeficient) {
                numberOfAvailableHits = MAX_NUMBER_OF_HITS;
            }
    
            if(phaseCoeficient < zeroCoeficient) {
                isRobotTurnOn = false;
                // break;
            }
        } while(phaseCoeficient == zeroCoeficient)
    }

    // задача 2.3
    const randomgeneratedNumber = Math.ceil(Math.random() * 9 + 1);
    const isHitSuccessful       = randomgeneratedNumber != HIT_COEFICIENT;

    // проверка за успешен удар
    const isHitPosible = isMouseDetected && isBatteryFull && isHitSuccessful;

    // Задача 5
    // Робота понякога трябва да може да комуникира със стопанина си, това е сложна задача защото е робот и не му се отдават много много приказките. За сметка на това пък може да брои много чевръсто. За да покаже робота че е свършил работата си успешно, той трябва да изведе на дисплея си последователност от цифри. Тази последователност трябва да започна от 10 и да свършва до 1 ца. Всеки път когато числото е четно робота трябва да извежда съобщението I am a Robottttt и числото до което е достигнала програмата.

    if(isHitPosible) {
        alert("Успешно нанесохте удар");
        // numberOfAvailableHits = numberOfAvailableHits - 1;
        numberOfAvailableHits--;

        // var upperBoundNumber = 10;
        // while(upperBoundNumber > 0) {

        //     alert(upperBoundNumber);

        //     if(upperBoundNumber % 2 == 0) {
        //         alert(`I am a Robottttt ${upperBoundNumber}`);
        //     }

        //     // upperBoundNumber = upperBoundNumber - 1;
        //     upperBoundNumber--;
        // }

        // Цикъл с брояч
        for(var upperBound = 10; upperBound > 0; upperBound--) {

            alert(upperBoundNumber);

            if(upperBoundNumber % 2 == 0) {
                alert(`I am a Robottttt ${upperBoundNumber}`);
            }
        }
    }

}

// while(true) {

//     const objectInFrontOfMe = prompt("Какъв обект има пред мен");
//     // 1 - стена
//     // 2 - стол 
//     // 3 - нищо 
//     // 0 - нищо

//     if(objectInFrontOfMe == 1) {
//         alert("Go Sideway");
//     }

//     if(objectInFrontOfMe == 2) {
//         alert('Jump');
//     }

//     if(objectInFrontOfMe == 3) {
//         alert('Forward');
//     }

//     if(objectInFrontOfMe == 0) {

//         alert("Robot turn offfff");
//         break;
//     }
// }


// var numberOfRobotCicle = 1;

// while(numberOfRobotCicle < 10) {

//     const objectInFrontOfMe = prompt("Какъв обект има пред мен");
//     // 1 - стена
//     // 2 - стол 
//     // 3 - нищо 
//     // 0 - нищо

//     if(objectInFrontOfMe == 1) {
//         alert("Go Sideway");
//         numberOfRobotCicle = numberOfRobotCicle + 1;
//     }

//     if(objectInFrontOfMe == 2) {
//         alert('Jump');
//         numberOfRobotCicle = numberOfRobotCicle + 2;
//     }

//     if(objectInFrontOfMe == 3) {
//         alert('Forward');
//         numberOfRobotCicle = numberOfRobotCicle + 3;
//     }

//     if(objectInFrontOfMe == 0) {

//         alert("Robot turn offfff");
//         break;
//     }

//     if(numberOfRobotCicle >= 10) {
//         break;
//     }
// }
