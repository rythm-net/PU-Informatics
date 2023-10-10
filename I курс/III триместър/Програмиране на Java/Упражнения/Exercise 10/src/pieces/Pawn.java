package pieces;

import pieces.config.ColorEnum;

public class Pawn extends Piece {

    public Pawn(int row, int col, ColorEnum color) {
        super(row, col, color);
        this.score  = 1;
        this.sign   = "P";
    }

    public boolean isMovePossible (int toRow, int toCol) {
        return isPossible(toRow, toCol, 1, 0);
    }

    public boolean isAttackPossible (int toRow, int toCol) {
        return isPossible(toRow, toCol, 1, 1);
    }

    private boolean isPossible (int toRow, int toCol,
                                int expectedRowCoefficient,
                                int expectedColCoefficient) {
        int rowCoefficient = Math.abs (toRow - this.row);
        int colCoefficient = Math.abs (toCol - this.col);

        return  rowCoefficient == expectedRowCoefficient && colCoefficient == expectedColCoefficient;
    }
}