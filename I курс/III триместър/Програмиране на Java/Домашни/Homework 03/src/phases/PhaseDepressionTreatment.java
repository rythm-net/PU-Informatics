package phases;

import managers.PhaseManager;
import util.Console;
import util.Dice;

public class PhaseDepressionTreatment {

    private static final String RESPONSE_OK        = "Добре съм";
    private static final String RESPONSE_NOT_OK    = "Не ми се живее";

    public static void process() {
        String message  = Console.scan("Задайте правилния въпрос на вашия робот:");
        String response = (Dice.troll(2) == 1) ? RESPONSE_OK : RESPONSE_NOT_OK;

        if(response.equals(RESPONSE_OK)) {
            String message2 = Console.scan("Продължете разговора");
        }

        if(response.equals(RESPONSE_NOT_OK)) {

            int robotPriceCoefficient   = Dice.troll(1000);
            int myPriceProposal         = Console.scanInt("Какво число си намисли робота");

            if(myPriceProposal <= robotPriceCoefficient) {
                PhaseManager.activatePhaseDepressionTreatment();
            }
        }
        PhaseManager.activatePhaseBootstrap();
    }
}