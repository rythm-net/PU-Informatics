import java.util.Random;
import java.util.Scanner;

public class Application {

    public static String getDirection(int obsticaleIndex) {

        if(obsticaleIndex == 1 ) {  // ?
            return "Go Sideway";
        }
        if(obsticaleIndex == 2) {
            return "Jump";
        }

        return "Forward";
    }

    public static boolean isMouseTargetDetected(int pixelCount) {
        return (pixelCount % 2 == 0);
    }

    public static boolean isMaxNumberOfHitsReached(int currentNumberOfHit) {

        final int MAX_NUMBER_OF_HIT = 4;
        return currentNumberOfHit < MAX_NUMBER_OF_HIT;
    }

    public static boolean isHitCorrect() {

        Random random = new Random();
        int randomNumberResult = random.nextInt(11);
        if(randomNumberResult == 0) {
            randomNumberResult = 1;
        }

        return (randomNumberResult != 5);
    }

    public static boolean isHitSuccessful(int pixelCount, int currentNumberOfHit) {

        boolean isMouseTargetDetected       = isMouseTargetDetected(pixelCount);
        boolean isMaxNumberOfHitsReached    = isMaxNumberOfHitsReached(currentNumberOfHit);
        boolean isHitCorrect                = isHitCorrect();
        boolean isHitSuccessful             = isMouseTargetDetected &&
                isMaxNumberOfHitsReached &&
                isHitCorrect;
        return isHitSuccessful;
    }

    public static void main(String[] args) {

        int currentNumberOfHit = 0;
        Scanner scanner = new Scanner(System.in);
        boolean isRobotUpAndRunning = true;

        while(isRobotUpAndRunning) {

            System.out.println("Привет на новия ми господар");
            System.out.println("Пред робота се намират следните обекти:");
            System.out.println("1. Стена");
            System.out.println("2. Стол");
            System.out.println("Пътя е чист");

            int obsticaleIndex  = scanner.nextInt();
            System.out.println(getDirection(obsticaleIndex));

            int numberOfPixels = scanner.nextInt();
            isRobotUpAndRunning = isHitSuccessful(numberOfPixels, currentNumberOfHit);
        }
    }
}