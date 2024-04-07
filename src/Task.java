import java.util.Date;

class Task {
    String name;
    String description;
    Date dueDate;
    int priority;
    boolean isDone;

    public Task(String name, String description, Date dueDate, int priority) {
        this.name = name;
        this.description = description;
        this.dueDate = dueDate;
        this.priority = priority;
        this.isDone = false;
    }
}

