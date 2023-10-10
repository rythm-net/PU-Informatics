public class Application {

    private static int loseValue=0;

    public static void gameLoop(String[][] gameBoard) {
        String cmd="";
        GameBoard.movementMenu(gameBoard,cmd);
        loseValue++;

        if(loseValue>=15){
            return;
        }
        gameLoop(gameBoard);
    }

    public static void main(String[] args) {
        String[][] gameBoard = GameBoard.BoardImpplant();
        GameBoard.Visualization(gameBoard);
        gameLoop(gameBoard);
    }
}