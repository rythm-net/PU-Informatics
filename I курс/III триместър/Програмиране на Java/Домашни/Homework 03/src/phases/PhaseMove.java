package phases;

import managers.EmotionManager;
import managers.PhaseManager;
import managers.StepManager;
import util.Console;
import util.Dice;

public class PhaseMove {

    public static final int STEP_LIMIT_DEPARTMENT_PASTRY = 3;
    public static final int STEP_LIMIT_DEPARTMENT_DELIVERY = 6;

    public static String[] encouragementMessageCollection = {
            "Животът не струва.",
            "Разбий ги!",
            "Невежеството е благодат.",
            "Давай, ти си!"
    };

    public static void process() {

        if(isStepSuccessful()) {
            StepManager.increaseSuccessStep();
            Console.logln("Стъпка " + StepManager.successful());
            next();
            return;
        }

        String message = Console.scan("Робота ни има нужда от окуражави слова:");
        if(isEncouragementSuccessful(message)) {
            Console.logln("Робота ни се мотивира да продължи напред ");
            StepManager.increaseSuccessStep();
            Console.logln("Стъпка " + StepManager.successful());
            next();
            return;
        }

        PhaseManager.activatePhaseSelfDestruct();
    }

    public static void next() {

        if(isPastryDepartmentReached()) {
            PhaseManager.activatePhaseRecognition();
            return;
        }

        if(isDeliveryDepartmentReached()) {
            PhaseManager.activatePhaseSelfDestruct();
            return;
        }

        PhaseManager.activatePhaseMove();
    }

    private static boolean isEncouragementSuccessful(String message) {
        return message.equals(encouragementMessageCollection[EmotionManager.getCurrentEmotion()]);
    }


    private static boolean isStepSuccessful() {
        final int[][] emotionIntervalCollection = {
                {1, 10  },
                {2, 100 },
                {1, 15  },
                {1, 65  }
        };

        int successStepCoefficient  = Dice.troll(100);
        boolean isInLowerBound      = successStepCoefficient >= emotionIntervalCollection[EmotionManager.getCurrentEmotion()][0];
        boolean isInUpperBound      = successStepCoefficient <= emotionIntervalCollection[EmotionManager.getCurrentEmotion()][1];
        boolean isInInterval        = isInLowerBound && isInUpperBound;
        return isInInterval;
    }

    private static boolean isPastryDepartmentReached() {
        return StepManager.successful() == STEP_LIMIT_DEPARTMENT_PASTRY;
    }

    private static boolean isDeliveryDepartmentReached() {
        return StepManager.successful() == STEP_LIMIT_DEPARTMENT_DELIVERY;
    }
}