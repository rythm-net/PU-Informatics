package pieces;

import pieces.config.ColorEnum;

public class Pawn {

    private int row;
    private int col;
    private int score;
    private ColorEnum color;
    private String sign;

    public Pawn (int row, int col, ColorEnum color) {
        this.row    = row;
        this.col    = col;
        this.color  = color;
        this.score  = 1;
        this.sign   = "P";
    }

    public String getSign() {
        return this.sign;
    }


    private boolean isPossible (int toRow, int toCol, int expectedRowCoefficient, int expectedColCoefficient) {
        int rowCoefficient = Math.abs (toRow - this.row);
        int colCoefficient = Math.abs (toCol - this.col);

        return  rowCoefficient == expectedRowCoefficient &&
                colCoefficient == expectedColCoefficient;
    }

    public boolean isMovePossible (int toRow, int toCol) {
        return isPossible (toRow, toCol, 1, 0);
    }

    public boolean isAttackPossible (int toRow, int toCol) {
        return isPossible (toRow, toCol, 1, 1);
    }
}