package menu.models;

public class FriedMeatBalls extends AMeetBall {

    public FriedMeatBalls(int percentPorkMeat, int percentBeefMeat) {
        super(percentPorkMeat, percentBeefMeat, 60);
    }

    @Override
    public void printPreparationInfo() {
        System.out.printf("Пържени кюфтета: 60 g, Свинско месо: %d, Телешко месо: %d\n", getPercentPorkMeat(), getPercentBeefMeat());
    }
}
