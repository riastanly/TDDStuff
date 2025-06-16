package org.test;

public class Task {
    private static int nextId = 0;
    private final int id;
    private final String desc;

    public Task(String desc) {
        this.id = nextId++;
        this.desc = desc;
    }

    public int getId() {
        return id;
    }

    public String getDesc() {
        return desc;
    }
}
