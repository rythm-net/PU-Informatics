var canvas  = document.getElementById("canvas");
var context = canvas.getContext('2d');

var rect = new Rectangle({
    x       : 10,
    y       : 10,
    width   : 150,
    height  : 150
});

rect.render(context);

rect = new Rectangle({
    x       : 200,
    y       : 200,
    width   : 150,
    height  : 150
});

rect.render(context);



// context.beginPath();
// context.rect(10, 10, 150, 150);
// context.fillStyle = "#ff0000";
// context.fill();
// context.endPath();

// context.beginPath();
// context.rect(100, 100, 150, 150);
// context.fillStyle = "#00ff00";
// context.fill();
// context.endPath();