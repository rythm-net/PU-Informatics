public class Movement {

    public static final String UP = "W";
    public static final String DOWN = "S";
    public static final String FORWARD = "D";
    public static final String BACKWARDS = "A";
    private static int nextStepSBD = 0;

    public static String[][] SBDMovement(String[][] gameBoard, String command) {

        int currentStepNumber = nextStepSBD;
        int[] tempLastLocation = new int[]{GameBoard.SBDPLACE[0], GameBoard.SBDPLACE[1]};

        if (command.equals(UP)) {
            nextStepSBD = Integer.parseInt(gameBoard[--GameBoard.SBDPLACE[0]][GameBoard.SBDPLACE[1]]);
            if (nextStepSBD > currentStepNumber && nextStepSBD % 2 == 0) {
                gameBoard[tempLastLocation[0]][tempLastLocation[1]] = GameBoard.SBDElementSubstitute;
                GameBoard.SBDPLACE[0]--;
                GameBoard.SBDElementSubstitute = gameBoard[GameBoard.SBDPLACE[0]][GameBoard.SBDPLACE[1]];
                gameBoard[GameBoard.SBDPLACE[0]][GameBoard.SBDPLACE[1]] = GameBoard.SBD;
            }
        }

        if (command.equals(DOWN)) {
            nextStepSBD = Integer.parseInt(gameBoard[++GameBoard.SBDPLACE[0]][GameBoard.SBDPLACE[1]]);
            if (nextStepSBD > currentStepNumber && nextStepSBD % 2 == 0) {
                gameBoard[tempLastLocation[0]][tempLastLocation[1]] = GameBoard.SBDElementSubstitute;
                GameBoard.SBDPLACE[0]++;
                GameBoard.SBDElementSubstitute = gameBoard[GameBoard.SBDPLACE[0]][GameBoard.SBDPLACE[1]];
                gameBoard[GameBoard.SBDPLACE[0]][GameBoard.SBDPLACE[1]] = GameBoard.SBD;
            }
        }

        if (command.equals(FORWARD)) {
            nextStepSBD = Integer.parseInt(gameBoard[GameBoard.SBDPLACE[0]][++GameBoard.SBDPLACE[1]]);
            if (nextStepSBD > currentStepNumber && nextStepSBD % 2 == 0) {
                gameBoard[tempLastLocation[0]][tempLastLocation[1]] = GameBoard.SBDElementSubstitute;
                GameBoard.SBDPLACE[1]++;
                GameBoard.SBDElementSubstitute = gameBoard[GameBoard.SBDPLACE[0]][GameBoard.SBDPLACE[1]];
                gameBoard[GameBoard.SBDPLACE[0]][GameBoard.SBDPLACE[1]] = GameBoard.SBD;
            }
        }

        if (command.equals(BACKWARDS)) {
            nextStepSBD = Integer.parseInt(gameBoard[GameBoard.SBDPLACE[0]][--GameBoard.SBDPLACE[1]]);
            if (nextStepSBD > currentStepNumber && nextStepSBD % 2 == 0) {
                gameBoard[tempLastLocation[0]][tempLastLocation[1]] = GameBoard.SBDElementSubstitute;
                GameBoard.SBDPLACE[1]--;
                GameBoard.SBDElementSubstitute = gameBoard[GameBoard.SBDPLACE[0]][GameBoard.SBDPLACE[1]];
                gameBoard[GameBoard.SBDPLACE[0]][GameBoard.SBDPLACE[1]] = GameBoard.SBD;
            }
        }
        return gameBoard;
    }

    public static String[][] VGOMovement(String[][] gameBoard, String command) {

        int[] tempLastLocation = new int[]{GameBoard.VGOPLACE[0], GameBoard.VGOPLACE[1]};
        if (command.equals(UP)) {

            if ((GameBoard.VGOPLACE[1] == 0) || (GameBoard.VGOPLACE[1] == 0)) {
                int nextStepNumber = Integer.parseInt(gameBoard[--tempLastLocation[0]][tempLastLocation[1]]);
                tempLastLocation[0] = GameBoard.VGOPLACE[0];
                tempLastLocation[0] = GameBoard.VGOPLACE[1];

                int[] tempContainer = new int[]{Integer.parseInt(gameBoard[tempLastLocation[0]][++tempLastLocation[1]]),
                        Integer.parseInt(gameBoard[--tempLastLocation[0]][tempLastLocation[1]]),
                        Integer.parseInt(gameBoard[tempLastLocation[0] - 2][tempLastLocation[1]]),
                        Integer.parseInt(gameBoard[tempLastLocation[0]][tempLastLocation[1] - 2])};
                int averageNumber = Logic.AvarageArray(tempContainer);

                if (nextStepNumber > averageNumber) {
                    gameBoard[tempLastLocation[0]][tempLastLocation[1]] = GameBoard.VGOElement;
                    GameBoard.VGOPLACE[0]--;

                    GameBoard.VGOElement = gameBoard[GameBoard.VGOPLACE[0]][GameBoard.VGOPLACE[1]];
                    gameBoard[GameBoard.VGOPLACE[0]][GameBoard.VGOPLACE[1]] = GameBoard.VGO;
                }
            }

            if ((GameBoard.VGOPLACE[0] == 17 && GameBoard.VGOPLACE[1] == 11) || (GameBoard.VGOPLACE[0] != 17 && GameBoard.VGOPLACE[1] == 11)) {

                int nextStepNumber = Integer.parseInt(gameBoard[--GameBoard.VGOPLACE[0]][GameBoard.VGOPLACE[1]]);

                int[] tempContainer = new int[]{Integer.parseInt(gameBoard[GameBoard.VGOPLACE[0] - 2][GameBoard.VGOPLACE[0]]),
                        Integer.parseInt(gameBoard[GameBoard.VGOPLACE[0] - 2][--GameBoard.VGOPLACE[0]]),
                        Integer.parseInt(gameBoard[--GameBoard.VGOPLACE[0]][--GameBoard.VGOPLACE[0]]),
                        Integer.parseInt(gameBoard[GameBoard.VGOPLACE[0]][--GameBoard.VGOPLACE[0]])};

                int averageNumber = Logic.AvarageArray(tempContainer);

                if (nextStepNumber > averageNumber) {
                    gameBoard[tempLastLocation[0]][tempLastLocation[1]] = GameBoard.VGOElement;
                    GameBoard.VGOPLACE[0]--;
                    GameBoard.VGOElement = gameBoard[GameBoard.VGOPLACE[0]][GameBoard.VGOPLACE[1]];
                    gameBoard[GameBoard.VGOPLACE[0]][GameBoard.VGOPLACE[1]] = GameBoard.VGO;
                }
            }

            if ((GameBoard.VGOPLACE[1] != 11) && (GameBoard.VGOPLACE[1] != 0)) {

                int nextStepNumber = Integer.parseInt(gameBoard[--GameBoard.VGOPLACE[0]][GameBoard.VGOPLACE[1]]);

                int[] tempContainer = new int[]{Integer.parseInt(gameBoard[--GameBoard.VGOPLACE[0]][GameBoard.VGOPLACE[1]]),
                        Integer.parseInt(gameBoard[--GameBoard.VGOPLACE[0]][--GameBoard.VGOPLACE[1]]),
                        Integer.parseInt(gameBoard[--GameBoard.VGOPLACE[0]][++GameBoard.VGOPLACE[1]]),
                        Integer.parseInt(gameBoard[++GameBoard.VGOPLACE[0]][++GameBoard.VGOPLACE[1]]),
                        Integer.parseInt(gameBoard[++GameBoard.VGOPLACE[0]][--GameBoard.VGOPLACE[1]]),};

                int averageNumber = Logic.AvarageArray(tempContainer);

                if (nextStepNumber > averageNumber) {
                    gameBoard[tempLastLocation[0]][tempLastLocation[1]] = GameBoard.VGOElement;
                    GameBoard.VGOPLACE[0]--;
                    GameBoard.VGOElement = gameBoard[GameBoard.VGOPLACE[0]][GameBoard.VGOPLACE[1]];
                    gameBoard[GameBoard.VGOPLACE[0]][GameBoard.VGOPLACE[1]] = GameBoard.VGO;
                }
            }
        }

        if (command.equals(DOWN)) {

            if (((GameBoard.VGOPLACE[1] == 0))) {

                int nextStepNumber = Integer.parseInt(gameBoard[++GameBoard.VGOPLACE[0]][GameBoard.VGOPLACE[1]]);

                int[] Container = new int[]{Integer.parseInt(gameBoard[GameBoard.VGOPLACE[0] + 2][GameBoard.VGOPLACE[1]]),
                        Integer.parseInt(gameBoard[GameBoard.VGOPLACE[0]][++GameBoard.VGOPLACE[1]]),
                        Integer.parseInt(gameBoard[++GameBoard.VGOPLACE[0]][++GameBoard.VGOPLACE[1]]),
                        Integer.parseInt(gameBoard[GameBoard.VGOPLACE[0] + 2][++GameBoard.VGOPLACE[1]])};

                int averageNumber = Logic.AvarageArray(Container);

                if (nextStepNumber > averageNumber) {
                    gameBoard[tempLastLocation[0]][tempLastLocation[1]] = GameBoard.VGOElement;
                    GameBoard.VGOPLACE[0]++;
                    GameBoard.VGOElement = gameBoard[GameBoard.VGOPLACE[0]][GameBoard.VGOPLACE[1]];
                    gameBoard[GameBoard.VGOPLACE[0]][GameBoard.VGOPLACE[1]] = GameBoard.VGO;
                }
            }

            if ((GameBoard.VGOPLACE[0] == 0 && GameBoard.VGOPLACE[1] == 11) || (GameBoard.VGOPLACE[0] != 0 && GameBoard.VGOPLACE[1] == 11)) {

                int nextStepNumber = Integer.parseInt(gameBoard[++GameBoard.VGOPLACE[0]][GameBoard.VGOPLACE[1]]);
                int[] tempContainer = new int[]{Integer.parseInt(gameBoard[GameBoard.VGOPLACE[0] + 2][GameBoard.VGOPLACE[1]]),
                        Integer.parseInt(gameBoard[GameBoard.VGOPLACE[0]][--GameBoard.VGOPLACE[1]]),
                        Integer.parseInt(gameBoard[++GameBoard.VGOPLACE[0]][--GameBoard.VGOPLACE[1]]),
                        Integer.parseInt(gameBoard[GameBoard.VGOPLACE[0] + 2][--GameBoard.VGOPLACE[1]])};

                int averageNumber = Logic.AvarageArray(tempContainer);

                if (nextStepNumber > averageNumber) {
                    gameBoard[tempLastLocation[0]][tempLastLocation[1]] = GameBoard.VGOElement;
                    GameBoard.VGOPLACE[0]++;
                    GameBoard.VGOElement = gameBoard[GameBoard.VGOPLACE[0]][GameBoard.VGOPLACE[1]];
                    gameBoard[GameBoard.VGOPLACE[0]][GameBoard.VGOPLACE[1]] = GameBoard.VGO;
                }
            }

            if ((GameBoard.VGOPLACE[0] != 17 && GameBoard.VGOPLACE[1] != 11) && (GameBoard.VGOPLACE[0] != 0 && GameBoard.VGOPLACE[1] != 0)) {

                int nextStepNumber = Integer.parseInt(gameBoard[++GameBoard.VGOPLACE[0]][GameBoard.VGOPLACE[1]]);
                int[] tempContainer = new int[]{Integer.parseInt(gameBoard[GameBoard.VGOPLACE[0] + 2][GameBoard.VGOPLACE[1]]),
                        Integer.parseInt(gameBoard[GameBoard.VGOPLACE[0] + 2][--GameBoard.VGOPLACE[1]]),
                        Integer.parseInt(gameBoard[GameBoard.VGOPLACE[0] + 2][++GameBoard.VGOPLACE[1]]),
                        Integer.parseInt(gameBoard[GameBoard.VGOPLACE[0]][++GameBoard.VGOPLACE[1]]),
                        Integer.parseInt(gameBoard[GameBoard.VGOPLACE[0]][++GameBoard.VGOPLACE[1]])};

                int averageNumber = Logic.AvarageArray(tempContainer);

                if (nextStepNumber > averageNumber) {
                    gameBoard[tempLastLocation[0]][tempLastLocation[1]] = GameBoard.VGOElement;
                    GameBoard.VGOPLACE[0]++;
                    GameBoard.VGOElement = gameBoard[GameBoard.VGOPLACE[0]][GameBoard.VGOPLACE[1]];
                    gameBoard[GameBoard.VGOPLACE[0]][GameBoard.VGOPLACE[1]] = GameBoard.VGO;
                }
            }
        }

        if (command.equals(FORWARD)) {

            if ((GameBoard.VGOPLACE[0] == 0 && GameBoard.VGOPLACE[1] == 0) || (GameBoard.VGOPLACE[0] == 0 && GameBoard.VGOPLACE[1] != 0)) {

                int nextStepNumber = Integer.parseInt(gameBoard[GameBoard.VGOPLACE[0]][++GameBoard.VGOPLACE[1]]);
                int[] tempContainer = new int[]{Integer.parseInt(gameBoard[GameBoard.VGOPLACE[0]][GameBoard.VGOPLACE[1] + 2]),
                        Integer.parseInt(gameBoard[++GameBoard.VGOPLACE[0]][GameBoard.VGOPLACE[1] + 2]),
                        Integer.parseInt(gameBoard[++GameBoard.VGOPLACE[0]][GameBoard.VGOPLACE[1]])};

                int averageNumber = Logic.AvarageArray(tempContainer);

                if (nextStepNumber > averageNumber) {
                    gameBoard[tempLastLocation[0]][tempLastLocation[1]] = GameBoard.VGOElement;
                    GameBoard.VGOPLACE[1]++;
                    GameBoard.VGOElement = gameBoard[GameBoard.VGOPLACE[0]][GameBoard.VGOPLACE[1]];
                    gameBoard[GameBoard.VGOPLACE[0]][GameBoard.VGOPLACE[1]] = GameBoard.VGO;
                }
            }

            if ((GameBoard.VGOPLACE[0] == 17 && GameBoard.VGOPLACE[1] == 0) || (GameBoard.VGOPLACE[0] == 17 && GameBoard.VGOPLACE[1] != 0)) {

                int nextStepNumber = Integer.parseInt(gameBoard[GameBoard.VGOPLACE[0]][++GameBoard.VGOPLACE[1]]);

                int[] tempContainer = new int[]{Integer.parseInt(gameBoard[GameBoard.VGOPLACE[0]][GameBoard.VGOPLACE[1] + 2]),
                        Integer.parseInt(gameBoard[--GameBoard.VGOPLACE[0]][GameBoard.VGOPLACE[1] + 2]),
                        Integer.parseInt(gameBoard[--GameBoard.VGOPLACE[0]][GameBoard.VGOPLACE[1]])};

                int averageNumber = Logic.AvarageArray(tempContainer);

                if (nextStepNumber > averageNumber) {
                    gameBoard[tempLastLocation[0]][tempLastLocation[1]] = GameBoard.VGOElement;
                    GameBoard.VGOPLACE[1]++;
                    GameBoard.VGOElement = gameBoard[GameBoard.VGOPLACE[0]][GameBoard.VGOPLACE[1]];
                    gameBoard[GameBoard.VGOPLACE[0]][GameBoard.VGOPLACE[1]] = GameBoard.VGO;
                }
            }

            if ((GameBoard.VGOPLACE[0] != 17 && GameBoard.VGOPLACE[1] != 11) && (GameBoard.VGOPLACE[0] != 0 && GameBoard.VGOPLACE[1] != 0)) {

                int nextStepNumber = Integer.parseInt(gameBoard[++GameBoard.VGOPLACE[0]][GameBoard.VGOPLACE[1]]);

                int[] tempContainer = new int[]{Integer.parseInt(gameBoard[GameBoard.VGOPLACE[0]][GameBoard.VGOPLACE[1] + 2]),
                        Integer.parseInt(gameBoard[--GameBoard.VGOPLACE[0]][GameBoard.VGOPLACE[1] + 2]),
                        Integer.parseInt(gameBoard[++GameBoard.VGOPLACE[0]][GameBoard.VGOPLACE[1] + 2]),
                        Integer.parseInt(gameBoard[--GameBoard.VGOPLACE[0]][++GameBoard.VGOPLACE[1]]),
                        Integer.parseInt(gameBoard[++GameBoard.VGOPLACE[0]][GameBoard.VGOPLACE[1]])};

                int averageNumber = Logic.AvarageArray(tempContainer);

                if (nextStepNumber > averageNumber) {
                    gameBoard[tempLastLocation[0]][tempLastLocation[1]] = GameBoard.VGOElement;
                    GameBoard.VGOPLACE[0]++;
                    GameBoard.VGOElement = gameBoard[GameBoard.VGOPLACE[0]][GameBoard.VGOPLACE[1]];
                    gameBoard[GameBoard.VGOPLACE[0]][GameBoard.VGOPLACE[1]] = GameBoard.VGO;
                }
            }
        }

        if (command.equals(BACKWARDS)) {

        }
        return gameBoard;
    }

    public static String[][] LFZMovement(String[][] gameBoard, String command) {

        int currentStepNumber = 0;
        int[] tempLastLocation = new int[]{GameBoard.LFZPLACE[0], GameBoard.LFZPLACE[1]};

        if (command.equals(UP)) {
            currentStepNumber = Integer.parseInt(gameBoard[--GameBoard.LFZPLACE[0]][GameBoard.LFZPLACE[1]]);

            if (GameBoard.nextLFZStepNumber >= currentStepNumber) {
                GameBoard.nextLFZStepNumber = currentStepNumber;
                gameBoard[tempLastLocation[0]][tempLastLocation[1]] = GameBoard.Substitue;
                GameBoard.LFZPLACE[0]--;
                GameBoard.Substitue = gameBoard[GameBoard.LFZPLACE[0]][GameBoard.LFZPLACE[1]];
                gameBoard[GameBoard.LFZPLACE[0]][GameBoard.LFZPLACE[1]] = GameBoard.LFZ;
            }
        }

        if (command.equals(DOWN)) {
            currentStepNumber = Integer.parseInt(gameBoard[++GameBoard.LFZPLACE[0]][GameBoard.LFZPLACE[1]]);

            if (GameBoard.nextLFZStepNumber >= currentStepNumber) {
                GameBoard.nextLFZStepNumber = currentStepNumber;
                gameBoard[tempLastLocation[0]][tempLastLocation[1]] = GameBoard.Substitue;
                GameBoard.LFZPLACE[0]++;
                GameBoard.Substitue = gameBoard[GameBoard.LFZPLACE[0]][GameBoard.LFZPLACE[1]];
                gameBoard[GameBoard.LFZPLACE[0]][GameBoard.LFZPLACE[1]] = GameBoard.LFZ;
            }
        }

        if (command.equals(FORWARD)) {
            currentStepNumber = Integer.parseInt(gameBoard[GameBoard.LFZPLACE[0]][++GameBoard.LFZPLACE[1]]);

            if (GameBoard.nextLFZStepNumber >= currentStepNumber) {
                GameBoard.nextLFZStepNumber = currentStepNumber;
                gameBoard[tempLastLocation[0]][tempLastLocation[1]] = GameBoard.Substitue;
                GameBoard.LFZPLACE[1]++;
                GameBoard.Substitue = gameBoard[GameBoard.LFZPLACE[0]][GameBoard.LFZPLACE[1]];
                gameBoard[GameBoard.LFZPLACE[0]][GameBoard.LFZPLACE[1]] = GameBoard.LFZ;
            }
        }

        if (command.equals(BACKWARDS)) {
            currentStepNumber = Integer.parseInt(gameBoard[GameBoard.SBDPLACE[0]][--GameBoard.SBDPLACE[1]]);

            if (GameBoard.nextLFZStepNumber >= currentStepNumber) {
                GameBoard.nextLFZStepNumber = currentStepNumber;
                gameBoard[tempLastLocation[0]][tempLastLocation[1]] = GameBoard.Substitue;
                GameBoard.LFZPLACE[1]--;
                GameBoard.Substitue = gameBoard[GameBoard.LFZPLACE[0]][GameBoard.LFZPLACE[1]];
            }
        }
        return gameBoard;
    }
}