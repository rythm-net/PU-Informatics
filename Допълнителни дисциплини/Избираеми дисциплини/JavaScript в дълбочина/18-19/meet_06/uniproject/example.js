// get canvas element 
var canvas  = document.getElementById("canvas");
var context = canvas.getContext('2d');

// x, y, width, heught
// context.fillRect(10, 10, 100, 100);

// var fillRect = function(x, y, w, h) {
//     context.rect(x, y, w, h);    
//     context.fill();
// };

// operation - draw in memory
context.fillStyle = "#00ff00";
context.rect(10, 10, 100, 100);

// operation render
context.fill();

context.fillStyle = "#0000ff";
context.rect(200, 200, 100, 100);
context.fill();

context.fillStyle = "#ff0000";
context.rect(350, 350, 50, 50);
context.fill();

context.beginPath();
context.fillStyle = "#00f0f0";
context.rect(150, 150, 65, 65);
context.fill();
context.closePath();
