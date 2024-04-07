import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

class ToDoList implements TaskManager {
    List<Task> tasks = new ArrayList<>();

    public void createTaskFromUserInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите задачу:");
        String name = scanner.nextLine();
        System.out.println("Введите описание:");
        String description = scanner.nextLine();
        System.out.println("Введите дату (yyyy-MM-dd):");
        String dueDateInput = scanner.nextLine();
        Date dueDate;
        try {
            dueDate = new SimpleDateFormat("yyyy-MM-dd").parse(dueDateInput);
        } catch (ParseException e) {
            System.out.println("Неверный формат даты");
            return;
        }
        System.out.println("Введите важность (1-низкая, 2-средняя, 3-высокая):");
        int priority = scanner.nextInt();
        scanner.nextLine(); // Consume newline left-over

        Task newTask = new Task(name, description, dueDate, priority);
        tasks.add(newTask);
        System.out.println("Успешный успех");
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

    public void removeTask(String taskName) {
        tasks.removeIf(task -> task.name.equals(taskName));
    }

    public void markTaskAsDone(String taskName) {
        for (Task task : tasks) {
            if (task.name.equals(taskName)) {
                task.isDone = true;
                break;
            }
        }
    }

    public void displayTasks() {
        for (Task task : tasks) {
            System.out.println("Название: " + task.name);
            System.out.println("Описание: " + task.description);
            System.out.println("Дата: " + task.dueDate);
            System.out.println("Приоритет: " + task.priority);
            System.out.println("Статус: " + (task.isDone ? "Выполнено" : "Не выполнено"));
            System.out.println("----------------------------------------------");
        }
    }

    public void sortTasksByDate() {
        tasks.sort(Comparator.comparing(task -> task.dueDate));
    }

    public void sortTasksByPriority() {
        tasks.sort(Comparator.comparing(task -> task.priority));
    }

    public void searchTasksByKeyword(String keyword) {
        for (Task task : tasks) {
            if (task.name.contains(keyword) || task.description.contains(keyword)) {
                System.out.println("Название: " + task.name);
                System.out.println("Описание: " + task.description);
                System.out.println("Дата: " + task.dueDate);
                System.out.println("Приоритет: " + task.priority);
                System.out.println("Статус: " + (task.isDone ? "Выполнено" : "Не выполнено"));
                System.out.println("----------------------------------------------");
            }
        }
    }
}