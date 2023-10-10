package pieces;

import pieces.config.ColorEnum;

public abstract class Piece {

    protected int row;
    protected int col;
    protected int score;
    protected ColorEnum color;
    protected String sign;

    public Piece (int row, int col, ColorEnum color) {
        this.row    = row;
        this.col    = col;
        this.color  = color;
    }

    public String getColorSign() {
        if(this.color == ColorEnum.BLACK) {
            return "b";
        }

        if(this.color == ColorEnum.WHITE) {
            return "w";
        }

        return null;
    }

    public String getSign() {
        return this.getColorSign() + this.sign;
    }

    public void move (int moveRow, int moveCol) {
        this.row = moveRow;
        this.col = moveCol;
    }

    public abstract boolean isMovePossible (int toRow, int toCol);
    public abstract boolean isAttackPossible (int toRow, int toCol);
}