var path = '/home/user/element';
var collection = path.split('/');

console.log(collection);
collection.shift();
console.log(collection);
console.log(collection.join('/'))