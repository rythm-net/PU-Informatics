function generateFourthDigit() {

    const customerHeight = prompt("Въведете височина в см");
    const customerWeight = prompt("Въведете тежина в кг");

    const customerBMI   = customerWeight / (customerHeight * customerWeight);

    if(customerBMI < 16) return 1;
    if(customerBMI >= 16    && customerBMI <= 16.99) return 2;
    if(customerBMI >= 17    && customerBMI <= 18.49) return 3;
    if(customerBMI >= 18.5  && customerBMI <= 24.99) return 4;
    if(customerBMI >= 25    && customerBMI <= 29.99) return 5;
    if(customerBMI >= 30    && customerBMI <= 34.49) return 6;
    if(customerBMI >= 35    && customerBMI <= 39.99) return 7;

    return 8;
}