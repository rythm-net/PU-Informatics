package managers;

public class PhaseManager {

    private static final int PHASE_BOOTSTRAP            = 1;
    private static final int PHASE_MOVE                 = 2;
    private static final int PHASE_RECOGNITION          = 3;
    private static final int PHASE_LIFT                 = 4;
    private static final int PHASE_DEPRESSION_TREATMENT = 5;
    private static final int PHASE_SELF_DESTRUCT        = 6;
    private static final int PHASE_SHUTDOWN             = -1;

    private static int currentRunningPhase              = PHASE_BOOTSTRAP;
    private static int previousRunningPhase             = -1;

    public static boolean isPhaseBootstrapRunning() {
        return currentRunningPhase == PHASE_BOOTSTRAP;
    }

    public static boolean isPhaseMoveRunning() {
        return currentRunningPhase == PHASE_MOVE;
    }

    public static boolean isPhaseRecognitionRunning() {
        return currentRunningPhase == PHASE_RECOGNITION;
    }

    public static boolean isPhaseLiftRunning() {
        return currentRunningPhase == PHASE_LIFT;
    }

    public static boolean isPhaseDepressionTreatmentRunning() {
        return currentRunningPhase == PHASE_DEPRESSION_TREATMENT;
    }

    public static boolean isPhaseSelfDestructRunning() {
        return currentRunningPhase == PHASE_SELF_DESTRUCT;
    }

    public static boolean isPreviousPhaseBootstrap() {
        return previousRunningPhase == PHASE_BOOTSTRAP;
    }

    public static boolean isPreviousPhaseMove() {
        return previousRunningPhase == PHASE_MOVE;
    }

    public static boolean isPreviousPhaseRecognition() {
        return previousRunningPhase == PHASE_RECOGNITION;
    }

    public static boolean isPreviousPhaseLift() {
        return previousRunningPhase == PHASE_LIFT;
    }

    public static boolean isPreviousPhaseDepressionTreatment() {
        return previousRunningPhase == PHASE_DEPRESSION_TREATMENT;
    }

    public static boolean isPreviousPhaseSelfDestruct() {
        return previousRunningPhase == PHASE_SELF_DESTRUCT;
    }

    public static void shutdown() {
        currentRunningPhase = PHASE_SHUTDOWN;
    }

    public static boolean isRunning() {
        return currentRunningPhase != PHASE_SHUTDOWN;
    }

    public static void activatePhaseBootstrap() {
        activatePhase(PHASE_BOOTSTRAP);
    }

    public static void activatePhaseMove() {
        activatePhase(PHASE_MOVE);
    }

    public static void activatePhaseRecognition() {
        activatePhase(PHASE_RECOGNITION);
    }

    public static void activatePhaseLift() {
        activatePhase(PHASE_LIFT);
    }

    public static void activatePhaseSelfDestruct() {
        activatePhase(PHASE_SELF_DESTRUCT);
    }

    public static void activatePhaseDepressionTreatment() {
        activatePhase(PHASE_DEPRESSION_TREATMENT);
    }

    private static void activatePhase(int phaseIndex) {
        previousRunningPhase = currentRunningPhase;
        currentRunningPhase  = phaseIndex;
    }
}