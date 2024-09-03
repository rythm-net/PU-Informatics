function generateFifthDigit() {

    const preferProduct     =  +prompt("Изберете категория предпочита продукт"); // 1
    const productFrequancy  =  +prompt("Колко често пазарувате"); // 2

    return preferProduct + productFrequancy;  
}