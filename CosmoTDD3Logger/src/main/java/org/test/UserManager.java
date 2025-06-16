package org.test;

import java.util.ArrayList;
import java.util.List;

public class UserManager {
    private final ILogger logger;
    private final List<String> users = new ArrayList<>();
    public UserManager(ILogger logger) {
        this.logger = logger;
    }

    public void addUser(String username) {
        users.add(username);
        logger.log("User " + username + " added");
    }

    public List<String> getUsers() {
        return users;
    }

}
