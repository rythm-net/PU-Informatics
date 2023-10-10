import java.util.Random;
import java.util.Scanner;

public class Menu {

    public static void menuMethod(String[][] gameBoard) {

        GameMap.gameColoring(gameBoard);

        System.out.println(
                " Turn: " + Turns.turn + "    " +
                " Balance: " + GameMap.gameplayCurrency + "     " +
                " Nation Happiness: " + GameMap.nationHappiness);

        System.out.println("1. Построяване на сгради");
        System.out.println("2. Експанзия");
        System.out.println("3. Икономика");
        System.out.println("4. Научен прогрес");
        System.out.println("5. Зъл План");
        System.out.println("6. Следващ ход");

        Scanner scanner = new Scanner(System.in);
        int commandNumber = scanner.nextInt();

        if (commandNumber == 1) {
            constructBuilding(gameBoard);
            menuMethod(gameBoard);
        }

        if (commandNumber == 2) {
            System.out.println("Изберете една една от следните възможности:");
            System.out.println("1- Експанзия 1");
            System.out.println("2- Експанзия 2");

            int  number=scanner.nextInt();

            if(number == 1) {
                if(GameMap.gameplayCurrency > 10_000){
                    GameMap.gameplayCurrency -= 10_000;
                    gameBoard=firstMapExpansion(gameBoard);
                } else {
                    System.out.println("Нямате достатъчно пари");
                }
                menuMethod(gameBoard);
            }

            if(number == 2) {
                if(GameMap.gameplayCurrency > 10_000) {
                    GameMap.gameplayCurrency -= 50_000;
                    gameBoard=secondMapExpansion(gameBoard);
                } else {
                    System.out.println("Нямате достатъчно пари");
                }
                menuMethod(gameBoard);
            }
        }

        if (commandNumber == 3) {
            System.out.println("1- Построяване на търговски коридор");
            System.out.println("2- Взимане на кредити от чужди банки");
            System.out.println("3- Кражба и отвличане");

            int choice = scanner.nextInt();

            if(choice==1) {
                if(Building.isTradeRouteAvailable){
                    constrictTradeRoute(gameBoard, choice);
                } else {
                    System.out.println("Трябва да имате построено пристанище(P) , за да изпълните тази команда");
                }
            }

            if(choice==2) {
                if(Building.isTakingCreditAvailable){
                    gettingInDebt();
                } else {
                    System.out.println("Трябва да имате построени данъчни(RA) , за да изпълните тази команда");
                }
            }

            if(choice==3){
                stealingAndKidnapping();
            }
            menuMethod(gameBoard);
        }

        if (commandNumber==4 ){
            if(Building.isScienceProgressAvailable){
                scienceUpgrades();
            } else {
                System.out.println("Трябва да построите университет(U) за командата Научен прогрес");
            }
            menuMethod(gameBoard);
        }

        if(commandNumber==5) {
            if(Building.isEvilPlanAvailable) {
                if(GameMap.gameplayCurrency > 10_000
                        && GameMap.tradingContractsEstablished == 2
                        && GameMap.isKidnappingStarted
                        && GameMap.isStealingStarted
                        && GameMap.nationHappiness > 40) {
                    GameMap.evilPlanTurns     = 16;
                    GameMap.gameplayCurrency -= 10_000;
                    GameMap.isEvilPlanStarted = true;
                } else {
                    System.out.println("Едно от условията за зъл план не е изпълнено:");
                    System.out.println("Търговски връзки : "+GameMap.tradingContractsEstablished);
                    System.out.println("Активирана ли е поне една акция по отвличане : "+GameMap.isKidnappingStarted);
                    System.out.println("Активирана ли е поне една акция за кражба : "+ GameMap.isStealingStarted);
                    String nationStatus=(GameMap.nationHappiness<40)?"Недоволен":"Доволен";
                    System.out.println("Статус на народа : "+nationStatus);
                }
            } else {
                System.out.println("Трябва да построите лаборатория(LB) за командата Зъл план");
            }
            menuMethod(gameBoard);
        }

        if(commandNumber==6) {
            Turns.endOfTurnCalculations(gameBoard);
        }
    }

    private static void constructBuilding(String[][] gameBoard) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Изберете сградата , която искате да постройте:");
        System.out.println("P    LB    B   U");
        System.out.println("T    RA    H   M");
        String buildingOfChoice=scanner.next();
//------------------------------------------------------------------------------------------------------------------------------------
        if (buildingOfChoice.equals("P")) {
            Building building=new Building();
            System.out.println("Въведете координатите на мястото , където искате да бъде построена сградата:");

            int row = scanner.nextInt();
            int col = scanner.nextInt();

            Building.setBuildingStats(buildingOfChoice,GameMap.isExpandedOnce,GameMap.isExpandedTwice,gameBoard,row,col,building);
            GameMap.buildingCollection.add(building);
            GameMap.gameplayCurrency-=building.constructionMoney;
        }
//------------------------------------------------------------------------------------------------------------------------------------
        if (buildingOfChoice.equals("LB")) {
            Building building=new Building();
            System.out.println("Въведете координатите на мястото , където искате да бъде построена сградата:");

            int row = scanner.nextInt();
            int col = scanner.nextInt();

            Building.setBuildingStats(buildingOfChoice,GameMap.isExpandedOnce,GameMap.isExpandedTwice,gameBoard,row,col,building);
            GameMap.buildingCollection.add(building);
            GameMap.gameplayCurrency-=building.constructionMoney;
        }
//------------------------------------------------------------------------------------------------------------------------------------
        if (buildingOfChoice.equals("B")&&GameMap.isExpandedOnce) {
            Building building=new Building();
            System.out.println("Въведете координатите на мястото , където искате да бъде построена сградата:");

            int row = scanner.nextInt();
            int col = scanner.nextInt();

            Building.setBuildingStats(buildingOfChoice,GameMap.isExpandedOnce,GameMap.isExpandedTwice,gameBoard,row,col,building);
            GameMap.buildingCollection.add(building);
            GameMap.gameplayCurrency-=building.constructionMoney;
        }
//------------------------------------------------------------------------------------------------------------------------------------
        if (buildingOfChoice.equals("U")&&GameMap.isExpandedOnce) {
            Building building=new Building();
            System.out.println("Въведете координатите на мястото , където искате да бъде построена сградата:");

            int row = scanner.nextInt();
            int col = scanner.nextInt();

            Building.setBuildingStats(buildingOfChoice,GameMap.isExpandedOnce,GameMap.isExpandedTwice,gameBoard,row,col,building);
            GameMap.buildingCollection.add(building);
            GameMap.gameplayCurrency-=building.constructionMoney;
        }
//------------------------------------------------------------------------------------------------------------------------------------
        if (buildingOfChoice.equals("RA")&&GameMap.isExpandedOnce) {
            Building building=new Building();
            System.out.println("Въведете координатите на мястото , където искате да бъде построена сградата:");

            int row = scanner.nextInt();
            int col = scanner.nextInt();

            Building.setBuildingStats(buildingOfChoice,GameMap.isExpandedOnce,GameMap.isExpandedTwice,gameBoard,row,col,building);
            GameMap.buildingCollection.add(building);
            GameMap.gameplayCurrency-=building.constructionMoney;
        }
//------------------------------------------------------------------------------------------------------------------------------------
        if (buildingOfChoice.equals("T")&&GameMap.isExpandedTwice) {
            Building building=new Building();
            System.out.println("Въведете координатите на мястото , където искате да бъде построена сградата:");

            int row = scanner.nextInt();
            int col = scanner.nextInt();

            Building.setBuildingStats(buildingOfChoice,GameMap.isExpandedOnce,GameMap.isExpandedTwice,gameBoard,row,col,building);
            GameMap.buildingCollection.add(building);
            GameMap.gameplayCurrency-=building.constructionMoney;
        }
//------------------------------------------------------------------------------------------------------------------------------------
        if (buildingOfChoice.equals("H")&&GameMap.isExpandedTwice) {
            Building building=new Building();
            System.out.println("Въведете координатите на мястото , където искате да бъде построена сградата:");

            int row = scanner.nextInt();
            int col = scanner.nextInt();

            Building.setBuildingStats(buildingOfChoice,GameMap.isExpandedOnce,GameMap.isExpandedTwice,gameBoard,row,col,building);
            GameMap.buildingCollection.add(building);
            GameMap.gameplayCurrency-=building.constructionMoney;
        }
//------------------------------------------------------------------------------------------------------------------------------------
        if (buildingOfChoice.equals("M")&&GameMap.isExpandedTwice) {
            Building building=new Building();
            System.out.println("Въведете координатите на мястото , където искате да бъде построена сградата:");

            int row = scanner.nextInt();
            int col = scanner.nextInt();

            Building.setBuildingStats(buildingOfChoice,GameMap.isExpandedOnce,GameMap.isExpandedTwice,gameBoard,row,col,building);
            GameMap.buildingCollection.add(building);
            GameMap.gameplayCurrency-=building.constructionMoney;
        }
    }

    private static void constrictTradeRoute(String[][] gameBoard, int choice) {
        Scanner scanner = new Scanner(System.in);

        if (choice == 1 && Building.isTradeRouteAvailable) {
            Ship ship = new Ship();
            System.out.println("Въведете марщрута на кораба ");
            String input=" ";

            while (!input.equals("End")) {
                int tempRow=scanner.nextInt();
                int tempCol=scanner.nextInt();
                int[] tempNumberArray= new int[2];
                tempNumberArray[0]=tempRow;
                tempNumberArray[1]=tempCol;
                ship.shipTravelingCoordinates.add(tempNumberArray);
                input=scanner.next();
            }
            ship.numberOfShipMovements=ship.shipTravelingCoordinates.size();
            GameMap.shipCollection.add(ship);
        }
    }

    private static void stealingAndKidnapping() {
        Scanner scanner=new Scanner(System.in);

        System.out.println("1- Кражба");
        System.out.println("2- Отвличане");

        int number=scanner.nextInt();

        if(number==1) {
            System.out.println("Изберете казарма , която се специализира в кражба (Въведете координатите й)");
            int row = scanner.nextInt();
            int col = scanner.nextInt();
            int[] temp=new int[]{row,col};
            for (Building building : GameMap.buildingCollection) {
                if(temp[0]==building.buildingCoordinates[0]&&temp[1]==building.buildingCoordinates[1]&&building.isStealingAvailable) {
                    building.moneyNeededToFunction=500;
                }
            }
            GameMap.isStealingStarted = true;
        }

        if(number==2) {
            System.out.println("Изберете казарма , която се специализира в отжличане (Въведете координатите й)");
            int row = scanner.nextInt();
            int col = scanner.nextInt();
            int[] temp=new int[]{row,col};
            for (Building building : GameMap.buildingCollection) {
                if(temp[0]==building.buildingCoordinates[0]&&temp[1]==building.buildingCoordinates[1]&&building.isKidnappingAvailable){
                    building.moneyNeededToFunction=0;
                    building.moneyGeneration=500;
                }
            }
            GameMap.isKidnappingStarted = true;
        }
    }

    private static void gettingInDebt() {

        System.out.println("№ Кредит                            Сума            Срок за връщане");
        System.out.println();
        System.out.println("1 Кредит зъл стартъп                10 000             12 хода");
        System.out.println("2 Кредит злодей                     50 000             24 хода");
        System.out.println("3 Кредитна програма доктор Злобил  100 000             36 хода");

        Scanner scanner=new Scanner(System.in);
        int number = scanner.nextInt();

        if (!GameMap.isDebtTaken) {
            if (number == 1) {
                GameMap.debtTurns         = 12;
                GameMap.debtAmount        = 11_000;
                GameMap.gameplayCurrency += 10_000;
            }

            if (number == 2) {
                GameMap.debtTurns         = 24;
                GameMap.debtAmount        = 55_000;
                GameMap.gameplayCurrency += 50_000;
            }

            if (number == 3) {
                GameMap.debtTurns         = 36;
                GameMap.debtAmount        = 110_000;
                GameMap.gameplayCurrency += 100_000;
            }

            GameMap.isDebtTaken = true;
        } else {
            System.out.println("Вече сте взели кредит");
            System.out.println("За връщане: "+GameMap.debtAmount);
            System.out.println("Оставащи ходове: "+GameMap.debtTurns);
        }
    }

    public static void scienceUpgrades() {
        Scanner scanner = new Scanner(System.in);

        if (!GameMap.isScienceResearchActive) {
            System.out.println("Търговски подобрения ");
            System.out.println();
            System.out.println("подобрение         сума         срок за подобрение");
            System.out.println("1-Двигател тайфун    2 000             2 хода");
            System.out.println("2-Диагонална струя   3 000              1 ход");
            System.out.println();
            System.out.println("Социални подобрения ");
            System.out.println();
            System.out.println("подобрение         сума         срок за подобрение");
            System.out.println("3-Умни тоалетни     500            1 ход");
            System.out.println("4-Ефективни данъци 3 000            2 хода");

            int number = scanner.nextInt();

            if (number == 1) {
                if (GameMap.gameplayCurrency > 2000) {
                    GameMap.gameplayCurrency -= 2000;
                    GameMap.scienceResearchName = "Двигател тайфун";
                    GameMap.scienceResearchTurns = 2;
                    GameMap.isScienceResearchActive = true;
                }
            }

            if (number == 2) {
                if (GameMap.gameplayCurrency > 3000) {
                    GameMap.gameplayCurrency -= 3000;
                    GameMap.scienceResearchName = "Диагонална струя";
                    GameMap.scienceResearchTurns = 1;
                    GameMap.isScienceResearchActive = true;
                }
            }

            if (number == 3) {
                if (GameMap.gameplayCurrency > 500) {
                    GameMap.gameplayCurrency -= 500;
                    GameMap.scienceResearchName = "Умни тоалетни";
                    GameMap.scienceResearchTurns = 1;
                    GameMap.isScienceResearchActive = true;
                }
            }

            if (number == 4) {
                if (GameMap.gameplayCurrency > 3000) {
                    GameMap.gameplayCurrency -= 3000;
                    GameMap.scienceResearchName = "Ефективни данъци";
                    GameMap.scienceResearchTurns = 2;
                    GameMap.isScienceResearchActive = true;
                }
            }
        } else {
            System.out.println("Трябва да изчакате сегашното подобрение да приключи обработка");
        }
    }

    private static String[][] firstMapExpansion(String[][] gameBoard) {
        String[][] newGameBoard=new String[GameMap.gameBoardRow+1][GameMap.gameBoardCol];

        for (int row=0;row<GameMap.gameBoardRow+1;row++) {
            for (int col=0;col<GameMap.gameBoardCol;col++) {

                if(row>=0 &&row<7) {
                    newGameBoard[row][col] = gameBoard[row][col];
                } else{
                    newGameBoard[row][col]="   ";
                }
            }
        }

        GameMap.gameBoardRow++;
        newGameBoard[5][4]=" X ";
        newGameBoard[5][5]=" X ";
        newGameBoard[5][6]=" X ";
        newGameBoard[5][7]=" @ ";

        MoneyIsland moneyIsland=new MoneyIsland();
        Random random=new Random();
        int randomNumber=random.nextInt(GameMap.gameBoardCol);
        newGameBoard[7][randomNumber]=moneyIsland.ISLAND_ICON;
        moneyIsland.islandCoordinatesRow=7;
        moneyIsland.islandCoordinatesCol=randomNumber;

        TouristIsland touristIsland=new TouristIsland();
        randomNumber=random.nextInt(GameMap.gameBoardCol);
        newGameBoard[7][randomNumber]=touristIsland.ISLAND_ICON;
        touristIsland.touristIslandRow=7;
        touristIsland.touristIslandCol=randomNumber;

        GameMap.isExpandedOnce=true;

        gameBoard=newGameBoard;
        return gameBoard;
    }

    private static String[][] secondMapExpansion(String[][] gameBoard) {
        String[][] newGameBoard=new String[GameMap.gameBoardRow][GameMap.gameBoardCol+1];

        for (int row=0;row<GameMap.gameBoardRow;row++) {
            for (int col=0;col<GameMap.gameBoardCol+1;col++) {

                if(col!=12) {
                    newGameBoard[row][col] = gameBoard[row][col];
                } else {
                    newGameBoard[row][col]="   ";
                }
            }
        }
        GameMap.gameBoardCol++;

        newGameBoard[2][8] = " X ";
        newGameBoard[3][8] = " X ";
        newGameBoard[4][8] = " @ ";
        newGameBoard[5][8] = " X ";

        MoneyIsland moneyIsland=new MoneyIsland();
        Random random=new Random();
        int randomNumber=random.nextInt(GameMap.gameBoardRow-1);
        newGameBoard[randomNumber][GameMap.gameBoardCol-1]=moneyIsland.ISLAND_ICON;
        moneyIsland.islandCoordinatesRow=7;
        moneyIsland.islandCoordinatesCol=randomNumber;

        TouristIsland touristIsland=new TouristIsland();
        randomNumber=random.nextInt(GameMap.gameBoardRow-1);
        newGameBoard[randomNumber][GameMap.gameBoardCol-1]=touristIsland.ISLAND_ICON;
        touristIsland.touristIslandRow=7;
        touristIsland.touristIslandCol=randomNumber;

        GameMap.isExpandedTwice=true;

        gameBoard=newGameBoard;
        return gameBoard;
    }
}