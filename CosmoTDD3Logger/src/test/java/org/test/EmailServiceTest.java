package org.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmailServiceTest {

    private EmailService emailService;

    @BeforeEach
    public void setUp() {
        emailService = new EmailService(new DummyLogger(), new DummyEmailSender());
    }

    @Test
    public void shouldAcceptValidEmailParams() {
        boolean result = emailService.sendEmail(
                "test@example.com",
                "Hello",
                "This is a test"
        );
        assertTrue(result);
    }
}