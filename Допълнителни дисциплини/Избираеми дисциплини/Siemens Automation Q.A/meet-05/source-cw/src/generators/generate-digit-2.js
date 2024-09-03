function generateSecondDigit(generatedFirstDigit) {

    if(generatedFirstDigit == 0) {
        return 9;
    }

    const customerSex = prompt("Какъв е твоя пол M / F");
    if(customerSex == "M") return 1;
    if(customerSex == "F") return 3;

    // var generatedNumber = 1;
    // do {
    //     generatedNumber = getRandom(1, 9);
    // } while(generatedNumber == 1 || generatedNumber == 3)

    var generatedNumber = getRandom(1, 9);
    // if(generatedNumber == 1) return generatedNumber++;
    // if(generatedNumber == 3) return generatedNumber++;
    if(generatedNumber == 1 || generatedNumber == 3) return ++generatedNumber;
    return generatedNumber;
}