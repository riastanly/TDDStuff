package org.test;

public class EmailService {
    private final ILogger logger;
    private final IEmailSender emailSender;

    public EmailService(ILogger logger, IEmailSender emailSender) {
        this.logger = logger;
        this.emailSender = emailSender;
    }

    public boolean sendEmail(String to, String subject, String body) {
        if (to == null || !to.contains("@")) {
            return false;
        }
        if (subject == null || subject.isEmpty()) {
            return false;
        }
        if (body == null || body.isEmpty() || body.length() > 1000) {
            return false;
        }
        logger.log("Sending email to " + to);
        emailSender.send(to, subject, body);
        return true;
    }
}
