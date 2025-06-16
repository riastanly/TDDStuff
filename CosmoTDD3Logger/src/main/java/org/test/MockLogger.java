package org.test;

import java.util.ArrayList;
import java.util.List;

public class MockLogger implements ILogger {
    private  final List<String> logs = new ArrayList<>();

    @Override
    public void log(String message) {
        logs.add(message);
    }

    public List<String> getLogs() {
        return logs;
    }
}
