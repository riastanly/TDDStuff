package org.test;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskListTest {

    @Test
    public void shouldAddTaskToList() {
        TaskList taskList = new TaskList();
        Task task = taskList.addTask("Test Task");

        assertNotNull(task);
        assertEquals("Test Task", task.getDesc());
        assertTrue(taskList.getTasks().contains(task));
    }

    @Test
    public void shouldThrowErrorWhenCompletingNonExistentTask() {
        TaskList taskList = new TaskList();

        Exception exception = assertThrows(IllegalArgumentException.class, () -> taskList.completeTask(999));
        assertEquals("Task with id 999 not found", exception.getMessage());
    }
}