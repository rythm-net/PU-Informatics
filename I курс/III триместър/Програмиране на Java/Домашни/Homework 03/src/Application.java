import managers.PhaseManager;
import phases.*;

public class Application {

    public static void main(String[] args) {

        while(PhaseManager.isRunning()) {

            if(PhaseManager.isPhaseBootstrapRunning()) {
                PhaseBootstrap.process();
            }

            if(PhaseManager.isPhaseMoveRunning()) {
                PhaseMove.process();
            }

            if(PhaseManager.isPhaseRecognitionRunning()) {
                PhaseRecognition.process();
            }

            if(PhaseManager.isPhaseLiftRunning()) {
                PhaseLift.process();
            }

            if(PhaseManager.isPhaseDepressionTreatmentRunning()) {
                PhaseDepressionTreatment.process();
            }

            if(PhaseManager.isPhaseSelfDestructRunning()) {
                PhaseSelfDestruct.process();
            }
        }
    }
}