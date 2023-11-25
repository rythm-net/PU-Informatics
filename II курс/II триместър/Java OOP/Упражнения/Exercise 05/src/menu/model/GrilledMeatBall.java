package menu.model;

public class GrilledMeatBall extends AMeatBall{


    public GrilledMeatBall(int percentBeefMeat, int percentPorkMeat, int gram) {
        super(percentBeefMeat, percentPorkMeat, gram);
    }

    public void printPreparationInfo() {
        System.out.printf("Кюфте на скара с грамаж: %d, Процент свинско месо: %d, Процент телешко месо: %d \n",getGram(),getPercentPorkMeat(),getPercentBeefMeat());
    }

}
