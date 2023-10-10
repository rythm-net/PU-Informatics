import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameMap {

    public static int gameBoardRow = 7;
    public static int gameBoardCol = 12;

    private static final String BASE_EMPTY_SPACE = " X ";
    private static final String BASE_HQ          = " HQ";
    private static final String BASE_COASTAL     = " @ ";

    public static boolean isExpandedOnce          = false;
    public static boolean isExpandedTwice         = false;
    public static boolean isDebtTaken             = false;
    public static boolean isScienceResearchActive = false;
    public static boolean isKidnappingStarted     = false;
    public static boolean isStealingStarted       = false;
    public static boolean isEvilPlanStarted       = false;

    public static ArrayList<Building> buildingCollection = new ArrayList<>();
    public static ArrayList<Ship> shipCollection         = new ArrayList<>();
    public static List<int[]> baseCoordinates            = new ArrayList<>();

    public static int gameplayCurrency            = 100_000;
    public static int nationHappiness             = 100;
    public static int debtTurns                   = 0;
    public static int debtAmount                  = 0;
    public static int scienceResearchTurns        = 0;
    public static int evilPlanTurns               = 0;
    public static int tradingContractsEstablished = 0;
    public static String scienceResearchName      = " ";


    public static String[][] gameBoardInitialization() {
        String[][] gameBoard = new String [gameBoardRow][gameBoardCol];

        for (int row=0;row<7;row++) {
            for (int col=0;col<12;col++){
                gameBoard[row][col]="   ";
            }
        }

        gameBoard=generateBase(gameBoard);
        gameBoard=generateSmallIslands(gameBoard);
        return gameBoard;
    }

    private static String[][] generateBase(String[][] gameBoard) {

        for (int row=2;row<5;row++) {
            for (int col=4;col<8;col++) {
                gameBoard[row][col]=BASE_EMPTY_SPACE;
            }
        }

        baseCoordinates=baseCoordinatesFiller(baseCoordinates,gameBoard);
        Random random = new Random();

        gameBoard[2][4] = BASE_COASTAL;
        gameBoard[2][7] = BASE_COASTAL;
        gameBoard[4][4] = BASE_COASTAL;

        for (int row=2;row<5;row++) {
            for (int col=4;col<8;col++) {
                int randomNumber = random.nextInt(3) + 1;

                if(randomNumber == 1&&!gameBoard[row][col].equals(BASE_COASTAL)) {
                    gameBoard[row][col] = BASE_HQ;
                    return gameBoard;
                }
            }
        }
        return gameBoard;
    }

    private static String[][] generateSmallIslands(String[][] gameBoard) {

        MoneyIsland moneyIsland1 = new MoneyIsland();
        gameBoard[0][0] = moneyIsland1.ISLAND_ICON;
        MoneyIsland moneyIsland2 = new MoneyIsland();
        moneyIsland2.islandCoordinatesRow = gameBoard.length-1;
        moneyIsland2.islandCoordinatesCol = gameBoard[0].length-1;
        gameBoard[moneyIsland2.islandCoordinatesRow][moneyIsland2.islandCoordinatesCol] = moneyIsland2.ISLAND_ICON;

        TouristIsland touristIsland1 = new TouristIsland();
        touristIsland1.touristIslandRow = gameBoard.length-1;
        gameBoard[gameBoard.length-1][0] = touristIsland1.ISLAND_ICON;
        TouristIsland touristIsland2 = new TouristIsland();
        touristIsland2.touristIslandCol = gameBoard[0].length-1;
        gameBoard[0][gameBoard[0].length-1] = touristIsland2.ISLAND_ICON;

        return gameBoard;
    }

    private static List<int[]> baseCoordinatesFiller(List<int[]> baseCoordinates,String[][] gameBoard) {
        for (int row=0;row<gameBoardRow;row++) {
            for (int col=0;col<gameBoardCol;col++) {

                if(gameBoard[row][col].equals(BASE_EMPTY_SPACE)) {
                    int[] tempArray={row,col};
                    baseCoordinates.add(tempArray);
                }
            }
        }
        return baseCoordinates;
    }

    public static void gameColoring(String[][] gameBoard) {
        for (int row = 0; row < gameBoardRow; row++) {
            for (int col = 0; col < gameBoardCol; col++) {

                if(row % 2 != 0) {
                    if (col % 2 == 0) {
                        System.out.print("\u001B[42m" + gameBoard[row][col] + "\u001B[0m");
                    } else {
                        System.out.print("\u001B[43m" + gameBoard[row][col] + "\u001B[0m");
                    }
                }

                else {
                    if(col %2 == 0) {
                        System.out.print("\u001B[43m" +gameBoard[row][col]+"\u001B[0m");
                    } else {
                        System.out.print("\u001B[42m" +gameBoard[row][col]+"\u001B[0m");
                    }
                }
            }
            System.out.println();
        }

        for (int row=0;row<gameBoardRow;row++) {
        }
    }
}