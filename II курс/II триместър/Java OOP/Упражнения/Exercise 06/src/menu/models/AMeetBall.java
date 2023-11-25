package menu.models;

public abstract class AMeetBall {
    private int percentPorkMeat;
    private int percentBeefMeat;
    private int weight;

    public AMeetBall(int percentPorkMeat, int percentBeefMeat, int weight) {
        this.percentPorkMeat = percentPorkMeat;
        this.percentBeefMeat = percentBeefMeat;
        this.weight = weight;
    }

    public int getPercentPorkMeat() {
        return percentPorkMeat;
    }

    public int getPercentBeefMeat() {
        return percentBeefMeat;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public abstract void printPreparationInfo();
}

