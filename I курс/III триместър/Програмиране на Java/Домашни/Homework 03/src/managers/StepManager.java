package managers;

public class StepManager {

    public static int numberOfSuccessfulSteps       = 0;
    public static int numberOfFailedSteps           = 0;

    public static int successful() {
        return numberOfSuccessfulSteps;
    }

    public static int failed() {
        return numberOfFailedSteps;
    }

    public static void increaseSuccessStep() {
        numberOfSuccessfulSteps++;
    }

    public static void increaseFailedStep() {
        numberOfFailedSteps++;
    }
}