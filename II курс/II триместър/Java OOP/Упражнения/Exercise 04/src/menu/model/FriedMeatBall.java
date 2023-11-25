package menu.model;

public class FriedMeatBall extends AMeatBall {
    public FriedMeatBall(int percentBeefMeat, int percentPorkMeat, int gram) {
        super(percentBeefMeat, percentPorkMeat, gram);
    }

    @Override
    public void printPreparationInfo() {
        System.out.printf("Пържено кюфте с грамаж: %d, Процент свинско месо: %d, Процент телешко месо: %d \n", getGram(), getPercentPorkMeat(), getPercentBeefMeat());
    }


}
