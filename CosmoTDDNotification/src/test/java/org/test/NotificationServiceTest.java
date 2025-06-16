package org.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class NotificationServiceTest {
    private RelationNotificationSender senderSpy;
    private NotificationService notificationService;

    @BeforeEach
    public void setUp() {
        RelationNotificationSender realSender = new RelationNotificationSender();
        senderSpy = Mockito.spy(realSender);

        notificationService = new NotificationService(senderSpy);
    }

    @Test
    public void testNotifyUserSendsNotificationWithLowPriorityForShortMessages() throws Exception {
        notificationService.notifyUser("user1", "Hi!");

        verify(senderSpy, times(1)).send(any(Notification.class));

        verify(senderSpy, times(1)).send(argThat(notification ->
                notification.getUserId().equals("user1") &&
                notification.getMessage().equals("Hi!") &&
                notification.getPriority() == Priority.LOW
        ));
    }
}