package chainofresponsibility;

public class InfoLogger extends Logger {

    public InfoLogger() {
        this.level = ConstantsLevels.INFO;
    }

    @Override
    protected void handleMessage(String message) {
        System.out.println("Warning: " + message);
    }
}
