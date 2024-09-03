function generateSixthDigit(digit1, digit2, digit3, digit4, digit5 ) {

    const cardNumberSum = digit1 + digit2 + digit3 + digit4 + digit5; 
    if(cardNumberSum < 9) return cardNumberSum;

    // ELSE
    do {
        const newStringNumber = `${cardNumberSum}`;

        for(var i = 0; i < newStringNumber.length; i++) {

            var element = newStringNumber[i];
            cardNumberSum = cardNumberSum + (+newStringNumber[i]);
        }

        // FOR EACH -- FOR OF
        // еквивалентен е на цикъла с броя - само че брояна е скрит
        // for(var element of strDigit) {
        //     console.log(+element)
        // }

    }while(cardNumberSum > 9)
    
    return cardNumberSum;
}