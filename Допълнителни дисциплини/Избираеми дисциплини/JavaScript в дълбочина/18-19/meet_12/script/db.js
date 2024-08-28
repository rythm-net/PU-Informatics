const fs = require('fs');
const crypto = require("crypto");

// create
// read
// update
// delete



var Database = function() {

    // create initial database
    fs.writeFileSync('datastore.json');
};


Database.prototype.select = function() {

};

Database.prototype.insert = function(document, collection) {

    // check if argument is collection
    if(!Array.isArray(collection)) {
        throw new Exception("Invalid argument exception Pleace provide a collection as a valid argument");
    }

    // check if file already exists and read the whole collection 
    


    // get collection and apply an uniq id
    var databasePrepCollection = [];
    for(var i = 0; i < collection.length; i++) {

        var object  = collection[i];
        object.__id =  crypto.randomBytes(16).toString("hex");
        databasePrepCollection.push(object);
    }

    var bynaryCollection = JSON.stringify(databasePrepCollection);

    // check if document already exists
    // if not create new 
    // create new document
    fs.writeFileSync(document, bynaryCollection, {
        flag: 'a+'
    });
};

Database.prototype.delete = function() {

};

Database.prototype.update = function() {

};

module.exports = Database;