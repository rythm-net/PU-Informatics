// var object = {};

// var fnc = function() {

// };


// var Human = {
//     name : 'Mihail Petrov',
//     age : 27
// };

// var Human1 = {
//     name : 'Atanas',
//     age : 19
// };

// var ObjectConstructor = function(name, age) {

//     var templateObject = {};
//     templateObject.name = name;
//     templateObject.age  = age;
//     return templateObject;
// };

// // Human misho = new Human("Mihail", 27);
// var misho = ObjectConstructor("Mihail", 27);
// var pesho = ObjectConstructor("Petar", 32);


// var FunctionHuman = function(name, age) {
//     this.age = age;
//     this.name = name;
// };

// var funMisho = new FunctionHuman("Mihail", 65)



// var demoPrototype = function(name, age) {

//     this.name   = name;
//     this.age    = age;

//     // Copy in Memory on every object instance
//     // this.sayMyName = function() {
//     //     console.log('Hi my name is : ' + this.name + ' I am ' + this.age + ' years old');
//     // };
// };

// // Copy in global memory just once
// demoPrototype.prototype.sayMyName = function() {
//     console.log('Hi my name is : ' + this.name + ' I am ' + this.age + ' years old');
// };


// console.log((new Date()).getTime());


//console.log(Math.floor(Math.random() * 100));


// var util = require('./lib/util');
// var _id        = util.generateBlockId();
// var from       = 'sdasdkjsjasvdjasgf';
// var to         = 'asdjhasvdjgasdjsad';
// var amount     = 11;
// var hash       = (util.hashBlockContent(`${_id} ${from} ${to} ${amount}`));
// var blockGenerationIterator = 0;

// // 0000x7845764
// console.log("HASH")
// console.log(hash.toString())

// var hashSubstr = hash.substring(0, 4);
// console.log(hashSubstr);


// while(hash.substring(0, 5) != '00000') {

//     hash = (util.hashBlockContent(`${_id} ${from} ${to} ${amount} ${blockGenerationIterator}`));
//     console.log(hash);
//     blockGenerationIterator++;
// }


var collection = new Array(9);
console.log(collection.join('0'));

