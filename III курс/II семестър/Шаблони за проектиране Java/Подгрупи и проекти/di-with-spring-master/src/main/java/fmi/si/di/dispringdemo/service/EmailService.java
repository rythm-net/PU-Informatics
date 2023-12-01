package fmi.si.di.dispringdemo.service;

import fmi.si.di.dispringdemo.utils.MessageStatus;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.regex.Pattern;

@Service
@Primary
public class EmailService implements MessagingService {
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

        System.out.println("Emails sent successfully: \"" + recipient + "\".");
        return MessageStatus.SUCCESS;
    }

}
