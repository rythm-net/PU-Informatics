// конфигурационни константи

// годината спрямо която определяме, 
// какъв ще бъде типът на потребителя
const CONFIGURATION_CUSTOMER_YEAR = 1965;

var globalConfig = {
    isCustomerAdoult : false,
    customerAge : -1,

    // setCustomerAge : function() {
    // },

    // setCustomerAge: () => {
    // },

    setCustomerAge(age) {
        globalConfig.isCustomerAdoult   = age >= 18;
        globalConfig.customerAge        = age;    
    }
}