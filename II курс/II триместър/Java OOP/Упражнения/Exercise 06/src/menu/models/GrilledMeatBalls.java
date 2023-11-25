package menu.models;

public class GrilledMeatBalls extends AMeetBall {

    public GrilledMeatBalls(int percentPorkMeat, int percentBeefMeat, int weight) {
        super(percentPorkMeat, percentBeefMeat, weight);
    }

    @Override
    public void printPreparationInfo() {
        System.out.printf("Кюфтета на скара: %d, Свинско месо: %d, Телешко месо: %d\n", getWeight(), getPercentPorkMeat(), getPercentBeefMeat());
    }

    public void printType() {
        if (getPercentBeefMeat() == 100) {
            System.out.println("Телешко кюфте");
        } else if (getPercentPorkMeat() == 100) {
            System.out.println("Свинско кюфте");
        } else {
            System.out.println("Кюфте смес");
        }
    }
}
