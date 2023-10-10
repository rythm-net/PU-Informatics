package util;

import java.util.Random;

public class CustomRandom {

    public static int random(int lower, int upper) {
        Random randomGenerator = new Random();
        return randomGenerator.nextInt(upper - lower) + lower;
    }

    public static int randomInclusive(int lower, int upper) {
        return random(lower, upper + 1);
    }
}