package managers;

import util.Dice;

public class EmotionManager {

    private static final int EMOTION_TRAGEDY        = 0;
    private static final int EMOTION_PRODUCTIVITY   = 1;
    private static final int EMOTION_CHAOS          = 2;
    private static final int EMOTION_FRIENDLINESS   = 3;
    private static final int EMOTION_DEPRESSION     = 4;

    private static int currentEmotion               = -1;

    public static void generateEmotion() {
        currentEmotion = produceEmotion();
    }

    public static boolean isTragedy() {
        return currentEmotion == EMOTION_TRAGEDY;
    }

    public static boolean isProductivity() {
        return currentEmotion == EMOTION_PRODUCTIVITY;
    }

    public static boolean isChaos() {
        return currentEmotion == EMOTION_CHAOS;
    }

    public static boolean isFriendliness() {
        return currentEmotion == EMOTION_FRIENDLINESS;
    }

    public static boolean isDepression() {
        return currentEmotion == EMOTION_DEPRESSION;
    }

    public static int getCurrentEmotion() {
        return currentEmotion;
    }

    public static boolean isCurrentEmotionPositive() {
        return isProductivity() || isFriendliness();
    }

    public static boolean isCurrentEmotionNegative() {
        return isTragedy() || isChaos();
    }

    private static int produceEmotion() {

        int initialBasicInputOutputCoefficient  = Dice.troll(10);
        int temporalEmotionCoefficient          = Dice.troll(100);

        boolean isInitialBasicInputOutputCoefficientEven = initialBasicInputOutputCoefficient % 2 == 0;
        boolean isInitialBasicInputOutputCoefficientOdd  = !isInitialBasicInputOutputCoefficientEven;

        boolean shouldActivateNegativeEmotion = (temporalEmotionCoefficient >= 60
                                                && temporalEmotionCoefficient <= 80)
                                                && (temporalEmotionCoefficient % 3 == 0);
        boolean shouldActivatePositiveEmotion = (temporalEmotionCoefficient >= 5
                                                && temporalEmotionCoefficient <= 55)
                                                && (temporalEmotionCoefficient % 5 == 0);

        if(isInitialBasicInputOutputCoefficientEven && shouldActivateNegativeEmotion) {
            return EMOTION_TRAGEDY;
        }

        if(isInitialBasicInputOutputCoefficientEven && shouldActivatePositiveEmotion) {
            return EMOTION_PRODUCTIVITY;
        }

        if(isInitialBasicInputOutputCoefficientOdd && shouldActivateNegativeEmotion) {
            return EMOTION_CHAOS;
        }

        if(isInitialBasicInputOutputCoefficientOdd && shouldActivatePositiveEmotion) {
            return EMOTION_FRIENDLINESS;
        }
        return EMOTION_DEPRESSION;
    }
}