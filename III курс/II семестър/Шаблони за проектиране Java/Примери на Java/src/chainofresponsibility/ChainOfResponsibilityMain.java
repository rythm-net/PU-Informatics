package chainofresponsibility;

public class ChainOfResponsibilityMain {

    public static void main(String[] args) {

        Logger chain = new ErrorLogger();
        Logger warningLogger = new WarningLogger();
        Logger infoLogger = new InfoLogger();

        chain.setNextLogger(warningLogger);
        warningLogger.setNextLogger(infoLogger);

        chain.logMessage(4, "Exception message");
        chain.logMessage(2, "Warning message");
        chain.logMessage(1, "Trace something");
        chain.logMessage(0, "Test invalid message");

    }


}


