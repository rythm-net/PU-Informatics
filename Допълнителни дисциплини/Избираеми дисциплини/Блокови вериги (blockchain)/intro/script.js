var uniconsole = require('./lib/uniconsole');

var myVariable; // undefined
var myString    = "Hello World";
var myNumber    = 10;
var myBool      = true;
var myObject    = {
    name : "Mihail Petrov",
    age  : 27
};
var myArray     = ["Mihail", 27];
var myFunction  = function() {
    
};




// console.log("Hello world");
// uniconsole.log("Hello world : FROM UNICONSOLE");
// console.log(uniconsole);
// uniconsole.mathconsole.addCharge(10);

var Customer = {
    id                  : '253468746876765465465',
    dayLimit            : 1000,
    hasLoan             : true,
    salary              : 2500,
    expectedLoan        : 4000,
    montlyLoanIncome    : [100, 100, 100, 150, 100, 100, 100, 100, 100, 100, 100, 100],
    minMontlyIncome     : 100,

    //  TODO : 
    minYearIncome       : 1000
};

var isApprovedForLoan = uniconsole.financialconsole.approve(Customer);
console.log(isApprovedForLoan);