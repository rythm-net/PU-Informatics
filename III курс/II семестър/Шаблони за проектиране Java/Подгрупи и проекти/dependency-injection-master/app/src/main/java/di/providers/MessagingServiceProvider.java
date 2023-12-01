package di.providers;

import di.services.EmailService;
import di.services.SMSService;

public class MessagingServiceProvider {

    private static void prepare() {
        // do some work ...
    }

    public static EmailService getEmailService() {
        prepare();
        return EmailService.getInstance();
    }

    public static SMSService getSMSService() {
        prepare();
        return SMSService.getInstance();
    }
}
