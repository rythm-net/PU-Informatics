package phases;

import managers.PhaseManager;
import util.Console;

public class PhaseSelfDestruct {

    public static void process() {
        Console.logln("Сбогом жесток свят");
        PhaseManager.shutdown();
    }
}