public class Turns {

    public static int turn = 1;

    public static boolean hasShipArrived            = false;
    private static boolean isSocialUpgradeOneActive = false;
    private static boolean isSocialUpgradeTwoActive = false;

    public static void endOfTurnCalculations(String[][] gameBoard){

        if(!hasShipArrived){
            shipMovementTowardsIsland(gameBoard);
        } else {
            shipMovementTowardsBase(gameBoard);
        }

        for (Building building:GameMap.buildingCollection){
            GameMap.gameplayCurrency -= building.moneyNeededToFunction;
            GameMap.gameplayCurrency += building.moneyGeneration;
            building.constructionTurns--;

            if(building.constructionTurns == 0){
                gameBoard[building.buildingCoordinates[0]][building.buildingCoordinates[1]] = building.buildingIcon;
            } else {
                building.constructionTurns--;
            }
        }

        if(GameMap.isScienceResearchActive){
            GameMap.scienceResearchTurns--;
            if(GameMap.scienceResearchTurns == 0){
                scienceResearch(GameMap.scienceResearchName);
            }
        }

        if(GameMap.debtTurns==0&&GameMap.isDebtTaken){
            System.out.println("Край на играта , Вие сте беден диктатор.");
            return;
        }

        if(isSocialUpgradeOneActive && turn % 4 == 0){
            GameMap.nationHappiness += 1;
        }

        if(GameMap.isKidnappingStarted && turn % 6 == 0){
            if(isSocialUpgradeTwoActive){
                GameMap.nationHappiness -= 2;
            }
            else {
                GameMap.nationHappiness -= 5;
            }
        }

        if(GameMap.isEvilPlanStarted) {
            GameMap.evilPlanTurns--;
            GameMap.gameplayCurrency -= 1000;

            if(GameMap.evilPlanTurns == 0) {
                System.out.println("Вие успешно завладяхте света!");
                return;
            }
        }

        if(turn % 12 == 0 && GameMap.nationHappiness <= 40) {
            System.out.println("Народът вече не Ви обича.");
        }

        if(turn == 60 && GameMap.nationHappiness > 40) {
            System.out.println("Вие сте най-обичания диктатор!");
            return;
        }

        GameMap.debtTurns--;
        turn++;
        Menu.menuMethod(gameBoard);
    }

    private static void shipMovementTowardsIsland(String[][] gameBoard) {

        for(Ship ship:GameMap.shipCollection) {
            int[] tempArray = ship.shipTravelingCoordinates.get(ship.currentShipMovement);
            ship.shipMovement(gameBoard,tempArray[0],tempArray[1],ship);
            gameBoard[tempArray[0]][tempArray[1]]=Ship.SHIP_ICON;
            ship.currentShipMovement++;

            if(ship.currentShipMovement == ship.numberOfShipMovements){
                GameMap.gameplayCurrency += 10_000;
                hasShipArrived = true;
            }
        }
    }

    private static void shipMovementTowardsBase(String[][] gameBoard){

        for(Ship ship:GameMap.shipCollection) {
            ship.currentShipMovement--;
            int[] tempArray = ship.shipTravelingCoordinates.get(ship.currentShipMovement);
            ship.shipMovement(gameBoard,tempArray[0],tempArray[1],ship);
            if(ship.currentShipMovement == 0){
                hasShipArrived = false;
            }
        }
    }

    private static void scienceResearch(String researchName) {

        if(researchName.equals("Умни тоалетни")){
            isSocialUpgradeOneActive = true;
        }

        if(researchName.equals("Ефективни данъци")){
            isSocialUpgradeTwoActive = true;
        }

        if(researchName.equals("Двигател тайфун")){

        }

        if(researchName.equals("Диагонална струя")){

        }
    }
}