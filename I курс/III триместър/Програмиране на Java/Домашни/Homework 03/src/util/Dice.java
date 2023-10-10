package util;

public class Dice {

    public static int troll(int upper) {
        return CustomRandom.randomInclusive(1, upper);
    }
}