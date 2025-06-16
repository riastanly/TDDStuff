package org.test;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserManagerTest {
    @Test
    public void shouldAddUserSuccessfully() {
        MockLogger mockLogger = new MockLogger();
        UserManager userManager = new UserManager(mockLogger);

        userManager.addUser("john");

        assertTrue(userManager.getUsers().contains("john"));
    }

    @Test
    public void shouldLogMessageWhenUserIsAdded() {
        MockLogger mockLogger = new MockLogger();
        UserManager userManager = new UserManager(mockLogger);

        userManager.addUser("john");
        assertEquals(List.of("User john added"), mockLogger.getLogs());
    }
}