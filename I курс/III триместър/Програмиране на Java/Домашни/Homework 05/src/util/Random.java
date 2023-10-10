package util;

public class Random {

    public static int generate(int bound) {

        java.util.Random generator = new java.util.Random();
        return generator.nextInt(bound);
    }
}