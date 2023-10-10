import java.util.Random;

public class Util {

    public static int random(int upperBound) {

        Random generate = new Random();
        return generate.nextInt(upperBound);
    }
}