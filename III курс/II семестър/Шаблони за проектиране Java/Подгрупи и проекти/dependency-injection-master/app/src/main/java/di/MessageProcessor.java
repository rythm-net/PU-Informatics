package di;

import di.contracts.MessagingService;

public class MessageProcessor {
    protected MessagingService messagingService;

    public MessageProcessor(MessagingService messagingService) throws Exception {
        if (messagingService != null) {
            this.messagingService = messagingService;
        } else {
            throw new Exception("Messaging service cannot be null!");
        }
    }

    public int processMessage(String message, String recipient) {
        // do some work...

        int result = this.messagingService.handleMessage(message, recipient);

        // do some additional work...

        return result;
    }

    public MessagingService getMessagingService() {
        return this.messagingService;
    }
}
