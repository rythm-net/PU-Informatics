public class Application {

    public static void gameLoop(String[][] gameBoard){
        Menu.menuMethod(gameBoard);
    }

    public static void main(String[] args) {
        String[][] gameBoard=GameMap.gameBoardInitialization();
        gameLoop(gameBoard);
    }
}