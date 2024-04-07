interface TaskManager {
    void addTask(Task task);
    void removeTask(String taskName);
    void markTaskAsDone(String taskName);
    void displayTasks();
}