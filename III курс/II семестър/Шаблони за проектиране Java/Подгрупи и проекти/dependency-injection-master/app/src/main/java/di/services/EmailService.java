package di.services;

import java.util.regex.Pattern;

import di.contracts.MessagingService;
import di.utils.MessageStatus;

public class EmailService implements MessagingService {
    private static EmailService instance;

    private EmailService() {
        // get email service data from config...

        // setup local fields to work with email server...
    }

    public static synchronized EmailService getInstance() {
        if (instance == null) {
            instance = new EmailService();
        }

        return instance;
    }

    @Override
    public int handleMessage(String message, String recipient) {
        // doing some work...
        
        // regex from https://www.javatpoint.com/java-email-validation
        String emailRegex = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+(?:\\.[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+)*@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$";
        if (!Pattern.compile(emailRegex).matcher(recipient).matches()) {
            System.out.println("Invalid email provided: \"" + recipient + "\".");
            return MessageStatus.FAILURE;
        }

        // sending message...

        System.out.println("Message sent successfully: \"" + recipient + "\".");
        return MessageStatus.SUCCESS;
    }
}
