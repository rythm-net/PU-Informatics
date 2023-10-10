import pieces.*;
import pieces.config.ColorEnum;

public class Application {

    private static final int ROW_NUMBER = 8;
    private static final int COL_NUMBER = 8;
    private static Object gameBoard[][] = new Object[ROW_NUMBER][COL_NUMBER];

    public static void render() {
        for(int row = 0; row < ROW_NUMBER; row++) {
            for(int col = 0; col < COL_NUMBER; col++) {

                Object gameBoardElement = gameBoard[row][col];

                if (gameBoardElement == null) { // null
                    System.out.print("X");
                }

                else {
                    ((Pawn)gameBoardElement).getSign();
                }
            }
        }
    }

    public static void main(String[] args) {
//-----------------------------------------------------------------------------------
        gameBoard[0][0] = new Rook(0, 0, ColorEnum.WHITE);
        gameBoard[0][7] = new Rook(0, 7, ColorEnum.WHITE);

        gameBoard[0][1] = new Knight(0, 1, ColorEnum.WHITE);
        gameBoard[0][6] = new Knight(0, 6, ColorEnum.WHITE);

        gameBoard[0][2] = new Bishop(0, 2, ColorEnum.WHITE);
        gameBoard[0][5] = new Bishop(0, 5, ColorEnum.WHITE);

        gameBoard[0][3] = new Queen(0, 3, ColorEnum.WHITE);
        gameBoard[0][4] = new King(0, 4, ColorEnum.WHITE);

        gameBoard[1][0] = new Pawn(1, 0, ColorEnum.WHITE);
        gameBoard[1][1] = new Pawn(1, 1, ColorEnum.WHITE);
        gameBoard[1][2] = new Pawn(1, 2, ColorEnum.WHITE);
        gameBoard[1][3] = new Pawn(1, 3, ColorEnum.WHITE);
        gameBoard[1][4] = new Pawn(1, 4, ColorEnum.WHITE);
        gameBoard[1][5] = new Pawn(1, 5, ColorEnum.WHITE);
        gameBoard[1][6] = new Pawn(1, 6, ColorEnum.WHITE);
        gameBoard[1][7] = new Pawn(1, 7, ColorEnum.WHITE);
//-----------------------------------------------------------------------------------
        gameBoard[7][0] = new Rook(7, 0, ColorEnum.BLACK);
        gameBoard[7][7] = new Rook(7, 7, ColorEnum.BLACK);

        gameBoard[7][1] = new Knight(7, 1, ColorEnum.BLACK);
        gameBoard[7][6] = new Knight(7, 6, ColorEnum.BLACK);

        gameBoard[7][2] = new Bishop(7, 2, ColorEnum.BLACK);
        gameBoard[7][5] = new Bishop(7, 5, ColorEnum.BLACK);

        gameBoard[7][3] = new Queen(7, 3, ColorEnum.BLACK);
        gameBoard[7][4] = new King(7, 4, ColorEnum.BLACK);

        gameBoard[6][0] = new Pawn(6, 0, ColorEnum.BLACK);
        gameBoard[6][1] = new Pawn(6, 1, ColorEnum.BLACK);
        gameBoard[6][2] = new Pawn(6, 2, ColorEnum.BLACK);
        gameBoard[6][3] = new Pawn(6, 3, ColorEnum.BLACK);
        gameBoard[6][4] = new Pawn(6, 4, ColorEnum.BLACK);
        gameBoard[6][5] = new Pawn(6, 5, ColorEnum.BLACK);
        gameBoard[6][6] = new Pawn(6, 6, ColorEnum.BLACK);
        gameBoard[6][7] = new Pawn(6, 7, ColorEnum.BLACK);
//-----------------------------------------------------------------------------------
    }
}