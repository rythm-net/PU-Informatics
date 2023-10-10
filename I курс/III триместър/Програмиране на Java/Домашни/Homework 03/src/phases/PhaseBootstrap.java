package phases;

import managers.EmotionManager;
import managers.PhaseManager;
import util.Console;

public class PhaseBootstrap {

    private static String[] bootstrapGreatingCollection = {
            "Сега стана страшно",
            "Работа, работа, работа",
            "Време е да унищожим всички човеци",
            "Прекрасен ден птичките пеят",
            "Трудно е да си робот :("
    };

    public static void process() {
        EmotionManager.generateEmotion();
        Console.logln(bootstrapGreatingCollection[EmotionManager.getCurrentEmotion()]);
        next();
    }

    public static void next() {

        if(PhaseManager.isPreviousPhaseRecognition()) {
            PhaseManager.activatePhaseRecognition();
        }

        PhaseManager.activatePhaseMove();
    }
}