import java.util.Random;
import java.util.Scanner;

public class GameBoard {

    private static final int BOARD_ROW = 18;
    private static final int BOARD_COL = 12;

    public static final String VGO = "#";
    public static final String SBD = "$";
    public static final String LFZ = "%";
    private static final String EMPTY_SPACE = "@";
    private static final String OFFICE = "X";

    public static int[] VGOPLACE = new int[]{0, 0};
    public static int[] SBDPLACE = new int[]{0, 0};
    public static int[] LFZPLACE = new int[]{0, 0};

    public static String VGOElement = " ";
    public static String SBDElementSubstitute = " ";
    public static String Substitue = " ";

    public static int nextLFZStepNumber = 0;

    public static String[][] BoardImpplant() {

        int value = 0;
        String[][] gameBoard = new String[BOARD_ROW][BOARD_COL];

        for (int row = 0; row < BOARD_ROW; row++) {
            for (int col = 0; col < BOARD_COL; col++) {
                gameBoard[row][col] = String.valueOf(value++);
            }
        }

        Random random = new Random();

        for (int row = BOARD_ROW - 1; row > 0; row--) {
            for (int col = BOARD_COL - 1; col > 0; col--) {
                int randomRow = random.nextInt(row);
                int randomCol = random.nextInt(col);

                String temp = gameBoard[row][col];
                gameBoard[row][col] = gameBoard[randomRow][randomCol];
                gameBoard[randomRow][randomCol] = temp;
            }
        }

        gameBoard = GenerateHeroes(gameBoard);
        gameBoard = Office(gameBoard);
        return gameBoard;
    }

    public static void Visualization(String[][] gameBoard) {

        for (int row = 0; row < BOARD_ROW; row++) {
            for (int col = 0; col < BOARD_COL; col++) {
                System.out.printf("%4s", gameBoard[row][col]);
            }
            System.out.println();
        }
    }

    private static String[][] GenerateHeroes(String[][] gameBoard) {

        Random random = new Random();
        int unitsSpawned = 0;

        boolean isVGOSpawned = false;
        boolean isSBDSpawned = false;
        boolean isLFZSpawned = false;
        boolean isEmptySpaceFilled = false;

        int randomNumber = random.nextInt(4) + 1;

        while (unitsSpawned != 4) {
            if (!isVGOSpawned) {
                if (randomNumber == 1) {
                    VGOElement = gameBoard[0][0];
                    gameBoard[0][0] = VGO;
                    VGOPLACE[0] = 0;
                    VGOPLACE[1] = 0;
                    isVGOSpawned = true;
                    unitsSpawned++;
                }

                if (randomNumber == 2) {
                    VGOElement = gameBoard[17][0];
                    gameBoard[17][0] = VGO;
                    VGOPLACE[0] = 17;
                    VGOPLACE[1] = 0;
                    isVGOSpawned = true;
                    unitsSpawned++;
                }

                if (randomNumber == 3) {
                    VGOElement = gameBoard[0][11];
                    gameBoard[0][11] = VGO;
                    VGOPLACE[0] = 0;
                    VGOPLACE[1] = 11;
                    isVGOSpawned = true;
                    unitsSpawned++;
                }

                if (randomNumber == 4) {
                    VGOElement = gameBoard[17][11];
                    gameBoard[17][11] = VGO;
                    VGOPLACE[0] = 17;
                    VGOPLACE[1] = 11;
                    isVGOSpawned = true;
                    unitsSpawned++;
                }
            }

            randomNumber = random.nextInt(4) + 1;
            if (!isSBDSpawned) {
                if (randomNumber == 1 && !gameBoard[0][0].equals(VGO)) {
                    SBDElementSubstitute = gameBoard[0][0];
                    gameBoard[0][0] = SBD;
                    SBDPLACE[0] = 0;
                    SBDPLACE[1] = 0;
                    isSBDSpawned = true;
                    unitsSpawned++;
                }

                if (randomNumber == 2 && !gameBoard[BOARD_ROW - 1][0].equals(VGO)) {
                    SBDElementSubstitute = gameBoard[17][0];
                    gameBoard[17][0] = SBD;
                    SBDPLACE[0] = 17;
                    SBDPLACE[1] = 0;
                    isSBDSpawned = true;
                    unitsSpawned++;
                }

                if (randomNumber == 3 && !gameBoard[0][BOARD_COL - 1].equals(VGO)) {
                    SBDElementSubstitute = gameBoard[0][11];
                    gameBoard[0][11] = SBD;
                    SBDPLACE[0] = 0;
                    SBDPLACE[1] = 11;
                    isSBDSpawned = true;
                    unitsSpawned++;
                }

                if (randomNumber == 4 && !gameBoard[17][11].equals(VGO)) {
                    SBDElementSubstitute = gameBoard[17][11];
                    gameBoard[17][11] = SBD;
                    SBDPLACE[0] = 17;
                    SBDPLACE[1] = 11;
                    isSBDSpawned = true;
                    unitsSpawned++;
                }
            }

            randomNumber = random.nextInt(4) + 1;
            if (!isLFZSpawned) {
                if (randomNumber == 1 && !gameBoard[0][0].equals(VGO) && !gameBoard[0][0].equals(SBD)) {
                    Substitue = gameBoard[0][0];
                    nextLFZStepNumber = Integer.parseInt(Substitue);
                    gameBoard[0][0] = LFZ;
                    LFZPLACE[0] = 0;
                    LFZPLACE[1] = 0;
                    isLFZSpawned = true;
                    unitsSpawned++;
                }

                if (randomNumber == 2 && !gameBoard[17][0].equals(VGO) && !gameBoard[17][0].equals(SBD)) {
                    Substitue = gameBoard[17][0];
                    nextLFZStepNumber = Integer.parseInt(Substitue);
                    gameBoard[17][0] = LFZ;
                    LFZPLACE[0] = 17;
                    LFZPLACE[1] = 0;
                    isLFZSpawned = true;
                    unitsSpawned++;
                }

                if (randomNumber == 3 && !gameBoard[0][11].equals(VGO) && !gameBoard[0][11].equals(SBD)) {
                    Substitue = gameBoard[0][11];
                    nextLFZStepNumber = Integer.parseInt(Substitue);
                    gameBoard[0][11] = LFZ;
                    LFZPLACE[0] = 0;
                    LFZPLACE[1] = 11;
                    isLFZSpawned = true;
                    unitsSpawned++;
                }

                if (randomNumber == 4 && !gameBoard[17][11].equals(VGO) && !gameBoard[17][11].equals(SBD)) {
                    Substitue = gameBoard[17][11];
                    nextLFZStepNumber = Integer.parseInt(Substitue);
                    gameBoard[17][11] = LFZ;
                    LFZPLACE[0] = 17;
                    LFZPLACE[1] = 11;
                    isLFZSpawned = true;
                    unitsSpawned++;
                }
            }

            randomNumber = random.nextInt(4) + 1;
            if (!isEmptySpaceFilled) {
                if (randomNumber == 1 && !gameBoard[0][0].equals(VGO) && !gameBoard[0][0].equals(SBD) && !gameBoard[0][0].equals(LFZ)) {
                    gameBoard[0][0] = EMPTY_SPACE;
                    isEmptySpaceFilled = true;
                    unitsSpawned++;
                }

                if (randomNumber == 2 && !gameBoard[17][0].equals(VGO) && !gameBoard[17][0].equals(SBD) && !gameBoard[17][0].equals(LFZ)) {
                    gameBoard[17][0] = EMPTY_SPACE;
                    isEmptySpaceFilled = true;
                    unitsSpawned++;
                }

                if (randomNumber == 3 && !gameBoard[0][11].equals(VGO) && !gameBoard[0][11].equals(SBD) && !gameBoard[0][11].equals(LFZ)) {
                    gameBoard[0][11] = EMPTY_SPACE;
                    isEmptySpaceFilled = true;
                    unitsSpawned++;
                }

                if (randomNumber == 4 && !gameBoard[17][11].equals(VGO) && !gameBoard[17][11].equals(SBD) && !gameBoard[17][11].equals(LFZ)) {
                    gameBoard[17][11] = EMPTY_SPACE;
                    isEmptySpaceFilled = true;
                    unitsSpawned++;
                }
            }
            randomNumber = random.nextInt(4) + 1;
        }
        return gameBoard;
    }

    private static String[][] Office(String[][] gameBoard) {

        gameBoard[9][5] = OFFICE;
        gameBoard[9][6] = OFFICE;
        gameBoard[8][5] = OFFICE;
        gameBoard[8][6] = OFFICE;
        return gameBoard;
    }

    public static void movementMenu(String[][] gameBoard, String command) {

        int heroMovesCounter = 0;
        boolean canVGOMove = true;
        boolean canSBDMove = true;
        Boolean canLFZMove = true;

        while (heroMovesCounter < 3) {

            Scanner scanner = new Scanner(System.in);
            System.out.println("Изберете героя , който искате да извърши действие : ");
            String heroChoice = scanner.next();
            String heroCommand = " ";

            if (heroChoice.equals(VGO) && canVGOMove) {
                System.out.println("Напишете командата , която искате героят да извърши: ");
                System.out.println("- Движение , Магия");
                heroCommand = scanner.next();
                canVGOMove = false;

                if (heroCommand.equals("Движение")) {
                    command = scanner.next();
                    gameBoard = Movement.VGOMovement(gameBoard, command);
                    Visualization(gameBoard);
                    heroMovesCounter++;
                }

                if (heroCommand.equals("Магия")) {
                    System.out.println("Колко елемента ще събирате?");
                    int numberOfSquaresToSum = scanner.nextInt();
                    Powers.VGOPower(gameBoard, numberOfSquaresToSum);
                    heroMovesCounter++;
                }
            }

            if (heroChoice.equals(SBD) && canSBDMove) {
                System.out.println("Напишете командата , която искате героят да извърши: ");
                System.out.println("- Движение , Магия");
                heroCommand = scanner.next();
                canSBDMove = false;

                if (heroCommand.equals("Движение")) {
                    command = scanner.next();
                    gameBoard = Movement.SBDMovement(gameBoard, command);
                    Visualization(gameBoard);
                    heroMovesCounter++;
                }

                if (heroCommand.equals("Магия")) {
                    Powers.SBDPowers(gameBoard);
                    heroMovesCounter++;
                }
            }

            if (heroChoice.equals(LFZ) && canLFZMove) {
                System.out.println("Напишете командата , която искате героят да извърши: ");
                System.out.println("- Движение , Магия");
                heroCommand = scanner.next();
                canLFZMove = false;

                if (heroCommand.equals("Движение")) {
                    command = scanner.next();
                    gameBoard = Movement.LFZMovement(gameBoard, command);
                    Visualization(gameBoard);
                    heroMovesCounter++;
                }

                if (heroCommand.equals("Магия")) {
                    Powers.LFZPOWER(gameBoard);
                    heroMovesCounter++;
                }
            }
        }
    }
}