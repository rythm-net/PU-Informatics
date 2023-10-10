import pieces.*;
import pieces.config.ColorEnum;
import util.Console;

public class Application {

    private static final String EMPTY_TILE = "X  ";
    private static final int ROW_NUMBER = 8;
    private static final int COL_NUMBER = 8;
    private static Piece gameBoard[][] = new Piece[ROW_NUMBER][COL_NUMBER];

    public static void render() {
        for(int row = 0; row < ROW_NUMBER; row++) {
            for(int col = 0; col < COL_NUMBER; col++) {

                Piece gameBoardElement = gameBoard[row][col];
                String sign = (gameBoardElement == null) ? EMPTY_TILE : gameBoardElement.getSign() + " ";
                System.out.print(sign);
            }
            System.out.println();
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
        render();

        // избираме фигура която ще местим
        int selectRow = Console.input("Въведете ROW");
        int selectCol = Console.input("Въведете COL");
        Piece selectedPiece = gameBoard[selectRow][selectCol];

        // избираме дестинация на тази фигура
        int moveRow = Console.input("Въведете ROW за придвижване");
        int moveCol = Console.input("Въведете COL за придвижване");
        if(selectedPiece.isMovePossible(moveRow, moveCol)) {

            // изтриваме текущата фигура от дъската
            gameBoard[selectRow][selectCol] = null;

            // извършваме придвижването на фигурата
            selectedPiece.move(moveRow, moveCol);

            // добавяме селектираната фигура към новите координати на дъската
            gameBoard[moveRow][moveCol] = selectedPiece;
        }

        else {
            System.out.println("Невалидно придвижване");
        }
        render();
    }
}