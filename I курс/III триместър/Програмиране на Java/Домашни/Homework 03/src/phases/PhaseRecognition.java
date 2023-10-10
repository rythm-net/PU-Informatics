package phases;

import managers.EmotionManager;
import managers.PhaseManager;
import managers.StepManager;
import util.Dice;

public class PhaseRecognition {

    public static void process() {

        if(!isPastryVisionActive()) {
            PhaseManager.activatePhaseBootstrap();
            return;
        }

        if(!isPastryRecognitionSuccessful()) {
            PhaseManager.activatePhaseRecognition();
            return;
        }

        PhaseManager.activatePhaseLift();
    }

    private static boolean isPastryVisionActive() {
        return EmotionManager.isCurrentEmotionPositive();
    }

    private static boolean isPastryRecognitionSuccessful() {
        return (Dice.troll(6) + Dice.troll(6) + Dice.troll(6)) >= StepManager.successful();
    }
}