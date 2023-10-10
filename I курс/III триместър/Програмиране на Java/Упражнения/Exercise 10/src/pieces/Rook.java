package pieces;

import pieces.config.ColorEnum;

public class Rook extends Piece {

    public Rook (int row, int col, ColorEnum color) {
        super (row, col, color);
        this.score  = 10;
        this.sign   = "R";
    }

    public boolean isMovePossible (int toRow, int toCol) {
        int rowCoefficient = Math.abs (toRow - this.row);
        int colCoefficient = Math.abs (toCol - this.col);

        return  rowCoefficient == toRow || colCoefficient == toCol;
    }

    public boolean isAttackPossible (int toRow, int toCol) {
        return this.isMovePossible (toRow, toCol);
    }
}