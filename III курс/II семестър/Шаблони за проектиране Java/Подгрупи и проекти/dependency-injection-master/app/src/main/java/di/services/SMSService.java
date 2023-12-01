package di.services;

import java.util.regex.Pattern;

import di.contracts.MessagingService;
import di.utils.MessageStatus;

public class SMSService implements MessagingService {
    private static SMSService instance;

    private SMSService() {
        // get sms service data from config...

        // setup local fields to work with sms server...
    }

    public static synchronized SMSService getInstance() {
        if (instance == null) {
            instance = new SMSService();
        }

        return instance;
    }

    @Override
    public int handleMessage(String message, String recipient) {
        // doing some work...
        
        // regex from https://stackoverflow.com/a/16702965
        // answer by Francis Gagnon on May 22, 2013 at 23:03, edited on May 22, 2013 at 23:10
        // unchanged
        String phoneRegex = "^\\s*(?:\\+?(\\d{1,3}))?[-. (]*(\\d{3})[-. )]*(\\d{3})[-. ]*(\\d{4})(?: *x(\\d+))?\\s*$";
        if (!Pattern.compile(phoneRegex).matcher(recipient).matches()) {
            System.out.println("Invalid phone number provided: \"" + recipient + "\".");
            return MessageStatus.FAILURE;
        }

        // sending message...

        System.out.println("Message sent successfully: \"" + recipient + "\".");
        return MessageStatus.SUCCESS;
    }
    
}
