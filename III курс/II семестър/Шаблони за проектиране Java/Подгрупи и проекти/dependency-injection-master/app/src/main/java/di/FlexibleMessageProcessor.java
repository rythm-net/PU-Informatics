package di;

import di.contracts.MessagingService;
import di.providers.MessagingServiceProvider;
import di.services.EmailService;
import di.services.SMSService;

public class FlexibleMessageProcessor {
    protected MessagingService messagingService;

    public MessagingService getMessagingService() {
        return this.messagingService;
    }

    /**
     * Creates a message processor that works with the provided service.
     * @throws Exception when {@code service} is null.
     */
    public FlexibleMessageProcessor(MessagingService service) throws Exception {
        this.setMessagingService(service);
    }
    
    /**
     * Creates a message processor that works with an email service by default.
     * @throws Exception when {@code service} is null.
     */
    public FlexibleMessageProcessor() throws Exception {
        this.setMessagingService(MessagingServiceProvider.getEmailService());
    }

    public int processEmailMessage(String message, String email) throws Exception {
        // do some work...

        if (!(this.messagingService instanceof EmailService)) {
            this.setMessagingService(MessagingServiceProvider.getEmailService());
        }

        int result = this.messagingService.handleMessage(message, email);

        // do some additional work...

        return result;
    }

    public int processSMSMessage(String message, String phone) throws Exception {
        // do some work...

        if (!(this.messagingService instanceof SMSService)) {
            this.setMessagingService(MessagingServiceProvider.getSMSService());
        }

        int result = this.messagingService.handleMessage(message, phone);

        // do some additional work...

        return result;
    }

    private void setMessagingService(MessagingService messagingService) throws Exception {
        if (messagingService != null) {
            this.messagingService = messagingService;
        } else {
            throw new Exception("Messaging service cannot be null!");
        }
    }
}
