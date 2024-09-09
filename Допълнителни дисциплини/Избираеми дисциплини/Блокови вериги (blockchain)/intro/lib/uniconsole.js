var uniconsole = {
    log : function(message) {
        console.log(message);
    },

    // doublelog function
};

var mathconsole = {
    add : function(a, b) {
        console.log(a + b);
    },

    addCharge : function(operationNumber) {
        var operationCharge = operationconsole.operate();
        console.log(operationNumber + operationCharge);
    }

    // calcDayLimit : 
    // argument -> operationNumber , (charge) * (dayLimit)
}


var operationconsole = {
    
    dayRate : 1.5,
    operate : function() {
        var dataOperation = this.dayRate + 10;
        return dataOperation;
    }

    // dayLimit -> function  
}


var financialconsole = {

    isCustomerLoyal : function(customer) {

        var minMontlyIncome         = customer.minMontlyIncome;
        var montlyIncomeCollection  = customer.montlyLoanIncome; 

        for(var i = 0; i < montlyIncomeCollection.length; i++) {

            var monthElement = montlyIncomeCollection[i];
            if(monthElement < minMontlyIncome) {
                return false;
            }
        }

        return true;
    },
    
    approve : function(customer) {

        var totalScoreCount = 0;

        if(customer.hasLoan) {

            var isCurrentCustomerLoayalToThisLoan =  this.isCustomerLoyal(customer);
            if(!isCurrentCustomerLoayalToThisLoan) {
                totalScoreCount = totalScoreCount + 2;
            }
        }

        if(customer.salary < 1000) {
            totalScoreCount++; // 1
        }

        if(customer.expectedLoan > 5000) {
            totalScoreCount++; // 2
        }

        if(totalScoreCount == 0 || 
           totalScoreCount == 1) {
            return true;
        }
        
        return false;
    }
};

// decoratorconsole
// * decorate(message, decorator)
// Hello world,  '%%%'
// %%%Hello world%%%

// module.exports = uniconsole


module.exports = {
    uniconsole : uniconsole,
    mathconsole : mathconsole,
    financialconsole : financialconsole
}