var uniDb = require('./script/db');


var instance = new uniDb({
    database : 'sample'
});

// Insert statment
instance.insert('users', [
    {
        'name'  : 'Mihail',
        age     : 25
    }, 
    {
        'name'  : 'Ivan',
        age     : 98
    }
]);

instance.insert('users', [
    {
        'name'  : 'Mihail1',
        age     : 25
    }, 
    {
        'name'  : 'Ivan1',
        age     : 98
    }
]);



// // Select statment
// instance.select('users', {
//     'name' : {
//         '>' : 'Ivan'
//     }
// })

// // delete statment 
// instance.delete('users');

// // update statment 
// instance.update('users', {
//     'name' : 'Mihail *'
// }, {
//     status : 'super'
// })