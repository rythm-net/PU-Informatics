var crypto = require('crypto-js');

var util = {

    generateBlockId : function() {

        var getTime = 'a' + (new Date()).getTime();   // string in miliseconds
        return crypto.SHA256(getTime).toString();          // hash 
    },

    hashBlockContent : function(message) {
        return crypto.SHA256(message).toString();
    },

    generateAmmount : function() {
        return Math.floor(Math.random() * 100);
    } 
};


module.exports = util;