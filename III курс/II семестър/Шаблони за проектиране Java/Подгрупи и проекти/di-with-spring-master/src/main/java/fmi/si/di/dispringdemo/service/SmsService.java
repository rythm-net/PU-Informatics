package fmi.si.di.dispringdemo.service;

import fmi.si.di.dispringdemo.utils.MessageStatus;
import org.springframework.stereotype.Service;

import java.util.regex.Pattern;

@Service
public class SmsService implements MessagingService {
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

        System.out.println("SMS sent successfully: \"" + recipient + "\".");
        return MessageStatus.SUCCESS;
    }
}
