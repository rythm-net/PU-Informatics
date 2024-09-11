var canvasElement = document.getElementById("game-board");
BoardManager.init(canvasElement);


document.addEventListener('keydown', function(e) {
    BoardManager.setDirection(e.code);
});