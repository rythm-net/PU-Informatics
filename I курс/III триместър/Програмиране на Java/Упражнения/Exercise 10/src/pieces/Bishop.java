package pieces;

import pieces.config.ColorEnum;

public class Bishop extends Piece {

    public Bishop(int row, int col, ColorEnum color) {
        super(row, col, color);
        this.score  = 10;
        this.sign   = "B";
    }

    public boolean isMovePossible(int toRow, int toCol) {
        int rowCoefficient = Math.abs(toRow - this.row);
        int colCoefficient = Math.abs(toCol - this.col);

        return  rowCoefficient == colCoefficient;
    }

    public boolean isAttackPossible(int toRow, int toCol) {
        return this.isMovePossible(toRow, toCol);
    }
}