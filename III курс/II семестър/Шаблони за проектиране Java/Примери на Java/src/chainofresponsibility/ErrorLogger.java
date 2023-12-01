package chainofresponsibility;

public class ErrorLogger extends Logger {

    public ErrorLogger() {
        this.level = ConstantsLevels.ERROR;
    }

    @Override
    protected void handleMessage(String message) {
        System.out.println("Error: " + message);
    }
}
