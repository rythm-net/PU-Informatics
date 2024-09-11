var PrivateObject = function() {

    var PrivateObjectScope = {

    };

    var privateAdvisor = function() {
        console.log("Private advisor");
    }

    var privateCalculator = function() {

    }


    var privateDecorator = function() {

    }
    
    return {
        calculate : function() {
            privateCalculator();
        }
    }
}


var newPublicObject = PrivateObject();

console.log(newPublicObject.calculate())
