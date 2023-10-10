package pieces;

import pieces.config.ColorEnum;

public class King {

    private int row;
    private int col;
    private int score;
    private ColorEnum color;
    private String sign;

    public King (int row, int col, ColorEnum color) {
        this.row    = row;
        this.col    = col;
        this.color  = color;
        this.score  = 10;
        this.sign   = "K";
    }

    public String getSign() {
        return this.sign;
    }

    public boolean isMovePossible (int toRow, int toCol) {
        int rowCoefficient = Math.abs (toRow - this.row);
        int colCoefficient = Math.abs (toCol - this.col);

        boolean isDiagonalDirectionPossible = (rowCoefficient == 1) && (colCoefficient == 1);
        boolean isLineDirectionPossible     = ( (rowCoefficient == 0 && colCoefficient == 1) ||
                                                (rowCoefficient == 1 && colCoefficient == 0));

        return  isDiagonalDirectionPossible || isLineDirectionPossible;
    }

    public boolean isAttackPossible (int toRow, int toCol) {
        return this.isMovePossible (toRow, toCol);
    }
}