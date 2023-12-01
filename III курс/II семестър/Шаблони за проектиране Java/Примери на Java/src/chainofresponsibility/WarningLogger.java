package chainofresponsibility;

public class WarningLogger extends Logger {

    public WarningLogger() {
        this.level = ConstantsLevels.WARNING;
    }

    @Override
    protected void handleMessage(String message) {
        System.out.println("Warning: " + message);
    }
}
