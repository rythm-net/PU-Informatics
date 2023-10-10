package phases;

import managers.PhaseManager;
import managers.StepManager;
import util.Dice;

public class PhaseLift {

    public static int liftSoftwareCurrentVersionId  = 0;

    public static void process() {

        if(!isPastryLiftSoftwareUpToDate()) {
            ++liftSoftwareCurrentVersionId;
            System.out.println("“Вие успешно актуализирахте версията на софтуер Doors в момента сте с " + liftSoftwareCurrentVersionId);
        }
        PhaseManager.activatePhaseMove();
    }

    private static boolean isPastryLiftSoftwareUpToDate() {
        return Dice.troll(69) + StepManager.successful() <= 10;
    }
}