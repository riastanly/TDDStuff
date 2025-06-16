package org.test;

import java.util.ArrayList;
import java.util.List;

public class TaskList {
    List<Task> taskList = new ArrayList<>();

    public Task addTask(String name) {
        Task task = new Task(name);
        taskList.add(task);
        return task;
    }

    public List<Task> getTasks() {
        return taskList;
    }

    public void completeTask(int id) {
        Task toRemove = null;
        for (Task task : taskList) {
            if (task.getId() == id) {
                toRemove = task;
                break;
            }
        }

        if (toRemove == null) {
            throw new IllegalArgumentException("Task with id " + id + " not found");
        }

        taskList.remove(toRemove);
    }
}
