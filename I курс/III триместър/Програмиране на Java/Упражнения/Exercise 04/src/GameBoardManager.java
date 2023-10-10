import java.util.Random;

public class GameBoardManager {

    private static final int GAME_BOARD_ROW_COUNT = 10;
    private static final int GAME_BOARD_COL_COUNT = 10;

    private static final String UNIT_TERRAIN    = ".";
    private static final String UNIT_PLAYER     = "%";
    private static final String UNIT_OBSTACLE   = "#";

    private static final String DIRECTION_FORWARD   = "w";
    private static final String DIRECTION_BACKWARD  = "s";
    private static final String DIRECTION_LEFT      = "a";
    private static final String DIRECTION_RIGHT     = "d";

    private static int playerRow;
    private static int playerCol;

        // 0. Създаване на игрова дъска
    public static String[][] bootstrapGameBoard() {

        // 0. Къде ще седи терена ? - в подходяща структура от данни
        // 1 - ви подход - директна инициализация
        // String[] row = {
        // "X", "X", "X", "X", "X", "X", "X", "X", "X", "X"
        // };

        // 2 - ри подход - създаване на празен масив
        // new - задели памет за ново нещо  (нов тип от данни)
        // - новото нещо е известно като обект.
        // String[] row = new String[10];
        // row[0] = "X";

        String[][] gameBoard = new String[GAME_BOARD_ROW_COUNT][GAME_BOARD_COL_COUNT];
        gameBoard  = generatePassableTerrain(gameBoard);
        gameBoard  = generatePlayerTank(gameBoard);
        gameBoard  = generateObstacles(gameBoard);

        return gameBoard;
    }

    public static String[][] movePlayer(String direction, String[][] gameBoard) {

        int playerCurrentRow = playerRow;
        int playerCurrentCol = playerCol;

        if(direction.equals(DIRECTION_FORWARD)) {
            playerCurrentRow = playerCurrentRow - 1;
            // playerRow -= 1;
            // playerRow--;
        }

        if(direction.equals(DIRECTION_BACKWARD)) {
            playerCurrentRow = playerCurrentRow + 1;
            // playerRow++;
        }

        if(direction.equals(DIRECTION_LEFT)) {
            playerCurrentCol = playerCurrentCol - 1;
            // playerCol--;
        }

        if(direction.equals(DIRECTION_RIGHT)) {
            playerCurrentCol = playerCurrentCol + 1;
            // playerCol++;
        }

        // текущите координати преди да се извърши преместването
        gameBoard[playerRow][playerCol] = UNIT_TERRAIN;

        // да присвоя новите стойности
        playerRow = playerCurrentRow;
        playerCol = playerCurrentCol;

        // местим играча една позиция в определена посока
        gameBoard[playerRow][playerCol] = UNIT_PLAYER;

        return gameBoard;
    }

    // 1. Визуализация на бойния терен
    public static void renderGameBoard(String[][] gameBoard) {

        for(int row = 0; row < GAME_BOARD_ROW_COUNT; row++) {
            for(int col = 0; col < GAME_BOARD_COL_COUNT; col++) {
                System.out.print(" " + gameBoard[row][col]);
            }
            System.out.println();
        }
    }

    // модификатори за достъп
    // * public  - видим е за всеки
    // * private - видим е само и единствено без изключения в рамките на ТОЗИ клас
    private static String[][] generatePassableTerrain(String[][] gameBoard) {

        // 0. Как ще го напълним с обекти ?
        // Създаваме си цикъл FOR
        // * декларираме брояч : int i = 0
        // * докога да се изпълнява цикъла
        // * инкрементиране придвижване на брояча напред
        for(int row = 0; row < GAME_BOARD_ROW_COUNT; row++) {
            for(int col = 0; col < GAME_BOARD_COL_COUNT; col++) {
                gameBoard[row][col] = UNIT_TERRAIN;
            }
        }
        return gameBoard;
    }

    private static String[][] generatePlayerTank(String[][] gameBoard) {

        playerRow = (GAME_BOARD_ROW_COUNT - 1);
        playerCol = Util.random(GAME_BOARD_ROW_COUNT);

        gameBoard[playerRow][playerCol] = UNIT_PLAYER;
        return gameBoard;
    }

    private static String[][] generateObstacles(String[][] gameBoard) {

        final int OBSTACLE_START_INDEX  = 3;
        final int OBSTACLE_END_INDEX    = 6;

        for(int row = OBSTACLE_START_INDEX; row < OBSTACLE_END_INDEX; row++) {
            for(int col = 0; col < GAME_BOARD_COL_COUNT; col++) {
                if(isPlacementOfObstaclePossible()) {
                    gameBoard[row][col] = UNIT_OBSTACLE;
                }
            }
        }
        return gameBoard;
    }

    private static boolean isPlacementOfObstaclePossible() {

        int chanseCoeficient = Util.random(6);
        return chanseCoeficient == 1;
    }
}