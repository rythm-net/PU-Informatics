package fmi.si.di.dispringdemo.processors;

import fmi.si.di.dispringdemo.service.MessagingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MessageProcessor {
    protected final MessagingService messagingService;

    public int processMessage(String message, String recipient) {
        // do some work...

        int result = this.messagingService.handleMessage(message, recipient);

        // do some additional work...

        return result;
    }
}
