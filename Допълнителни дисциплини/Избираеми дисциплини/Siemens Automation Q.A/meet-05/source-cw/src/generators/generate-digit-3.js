function generateThirdDigit() {

    if(globalConfig.isCustomerAdoult) return 0;

    const fatherBirthDate = prompt("Въведи годината на раждане на баща ти ?");
    const motherBirthDate = prompt("Въведи годината на раждане на майка ти ?");

    if(motherBirthDate[3] == fatherBirthDate[3]) {
        return motherBirthDate[2];
    }

    return fatherBirthDate[3];

    // return (motherBirthDate[3] == fatherBirthDate[3]) 
    //     ? motherBirthDate[2] 
    //     : fatherBirthDate[3];
}