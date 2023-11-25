package menu.model;

public abstract class AMeatBall {
    private final int percentBeefMeat;
    private final int percentPorkMeat;
    private final int gram;

    public AMeatBall(int percentBeefMeat, int percentPorkMeat, int gram) {
        this.percentBeefMeat = percentBeefMeat;
        this.percentPorkMeat = percentPorkMeat;
        this.gram = gram;
    }

    public abstract void printPreparationInfo();

    public int getPercentBeefMeat() {
        return percentBeefMeat;
    }

    public int getPercentPorkMeat() {
        return percentPorkMeat;
    }

    public int getGram() {
        return gram;
    }
}
