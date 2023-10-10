import java.util.Scanner;

public class Building {

    public String buildingIcon = "   ";

    public int constructionMoney     = 0;
    public int constructionTurns     = 0;
    public int moneyGeneration       = 0;
    public int moneyNeededToFunction = 0;
    public int peopleUpVote          = 0;
    public int peopleDownVote        = 0;
    public int[] buildingCoordinates = new int[]{0,0};

    public static boolean isEvilPlanAvailable   = false;
    public static boolean isTradeRouteAvailable = false;

    public boolean isKidnappingAvailable = false;
    public boolean isStealingAvailable   = false;

    public static boolean isScienceProgressAvailable = false;
    public static boolean isTakingCreditAvailable    = false;

    public static final String HARBOR_ICON       = " P ";
    public static final String LAB_ICON          = " LB ";
    public static final String BARRACKS_ICON     = " B ";
    public static final String UNIVERSITY_ICON   = " U ";
    public static final String TAX_BUILDING_ICON = " RA";
    public static final String THEATRE_ICON      = " T ";
    public static final String BROADCAST_ICON    = " M ";
    public static final String TEMPLE_ICON       = " H ";

    public static void setBuildingStats(String buildingIcon, boolean isExpandedOnce, boolean isExpandedTwice,
                                        String[][] gameBoard, int row, int col,
                                        Building building) {

        if (buildingIcon.equals("P")) {
            building.buildingIcon          = HARBOR_ICON;
            building.constructionMoney     = 1000;
            building.constructionTurns     = 1;
            building.moneyGeneration       = 0;
            building.moneyNeededToFunction = 1000;
            GameMap.nationHappiness       += 5;
            isTradeRouteAvailable          = true;
        }

        if (buildingIcon.equals("LB")) {
            building.buildingIcon          = LAB_ICON;
            building.constructionMoney     = 1000;
            building.constructionTurns     = 1;
            building.moneyGeneration       = 0;
            building.moneyNeededToFunction = 1000;
            GameMap.nationHappiness       += 5;
            isEvilPlanAvailable            = true;
        }

        if (buildingIcon.equals("B") && isExpandedOnce) {
            building.buildingIcon          = BARRACKS_ICON;
            building.constructionMoney     = 1000;
            building.constructionTurns     = 1;
            building.moneyGeneration       = 0;
            building.moneyNeededToFunction = 1000;
            GameMap.nationHappiness       -= 1;

            System.out.println("Изберете в какво да се специализира тази казарма: O - Отвличане , К - Кражба");
            Scanner scanner = new Scanner(System.in);
            String choice = scanner.nextLine();
            scanner.next();

            if (choice.equals("O")) {
                building.isKidnappingAvailable = true;
            }

            if (choice.equals("K")) {
                building.isStealingAvailable = true;
            }
        }

        if (buildingIcon.equals("U") && isExpandedOnce) {
            building.buildingIcon          = UNIVERSITY_ICON;
            building.constructionMoney     = 1000;
            building.constructionTurns     = 1;
            building.moneyGeneration       = 0;
            building.moneyNeededToFunction = 500;
            GameMap.nationHappiness       += 10;
            isScienceProgressAvailable     = true;
        }

        if (buildingIcon.equals("RA") && isExpandedOnce) {
            building.buildingIcon          = TAX_BUILDING_ICON;
            building.constructionMoney     = 1000;
            building.constructionTurns     = 1;
            building.moneyGeneration       = 500;
            building.moneyNeededToFunction = 0;
            GameMap.nationHappiness       -= 5;
            isTakingCreditAvailable        = true;
        }

        if (buildingIcon.equals("T") && isExpandedTwice) {
            building.buildingIcon          = THEATRE_ICON;
            building.constructionMoney     = 1000;
            building.constructionTurns     = 2;
            building.moneyGeneration       = 0;
            building.moneyNeededToFunction = 100;
            GameMap.nationHappiness       += 5;
        }

        if (buildingIcon.equals("M") && isExpandedTwice) {
            building.buildingIcon          = BROADCAST_ICON;
            building.constructionMoney     = 1000;
            building.constructionTurns     = 2;
            building.moneyGeneration       = 0;
            building.moneyNeededToFunction = 500;
            GameMap.nationHappiness       += 5;
        }

        if (buildingIcon.equals("H") && isExpandedTwice) {
            building.buildingIcon          = TEMPLE_ICON;
            building.constructionMoney     = 1000;
            building.constructionTurns     = 2;
            building.moneyGeneration       = 0;
            building.moneyNeededToFunction = 1001;
            building.peopleUpVote          = 5;
            building.peopleDownVote        = 0;
        }
        constructBuilding(gameBoard, row, col, building, building.buildingCoordinates);
    }

    public static void constructBuilding(String[][] gameBoard, int row, int col,Building building,int[] buildingCoordinates) {

        if (building.constructionTurns!=0) {
            gameBoard[row][col]=" ! ";
        } else {
            gameBoard[row][col]=building.buildingIcon;
        }

        int[] temp=new int[]{row,col};

        buildingCoordinates[0]=temp[0];
        buildingCoordinates[1]=temp[1];
    }
}