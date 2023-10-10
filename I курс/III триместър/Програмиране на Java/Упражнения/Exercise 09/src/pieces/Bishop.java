package pieces;

import pieces.config.ColorEnum;

public class Bishop {

    private int row;
    private int col;
    private int score;
    private ColorEnum color;
    private String sign;

    public Bishop (int row, int col, ColorEnum color) {
        this.row    = row;
        this.col    = col;
        this.color  = color;
        this.score  = 10;
        this.sign   = "B";
    }

    public String getSign() {
        return this.sign;
    }

    public boolean isMovePossible (int toRow, int toCol) {
        int rowCoefficient = Math.abs (toRow - this.row);
        int colCoefficient = Math.abs (toCol - this.col);

        return  rowCoefficient == colCoefficient;
    }

    public boolean isAttackPossible (int toRow, int toCol) {
        return this.isMovePossible (toRow, toCol);
    }
}