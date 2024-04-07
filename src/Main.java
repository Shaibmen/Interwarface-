import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ToDoList toDoList = new ToDoList();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nЛист делания прикольных и не очень вещей");
            System.out.println("1. Добавить задачу");
            System.out.println("2. Убрать задачу");
            System.out.println("3. Пометить как выполненое");
            System.out.println("4. Вывести список всех задач");
            System.out.println("5. Сортировка по дате");
            System.out.println("6. Сортировка по приоритету");
            System.out.println("7. Поиск по ключевому слову");
            System.out.println("8. Выход");
            System.out.print("Выберите функцию: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline left-over

            switch (choice) {
                case 1:
                    toDoList.createTaskFromUserInput();
                    break;
                case 2:
                    System.out.println("Введите имя задачи для удаления:");
                    String taskNameToRemove = scanner.nextLine();
                    toDoList.removeTask(taskNameToRemove);
                    break;
                case 3:
                    System.out.println("Введите имя задачи для изменения статуса:");
                    String taskNameToMarkDone = scanner.nextLine();
                    toDoList.markTaskAsDone(taskNameToMarkDone);
                    break;
                case 4:
                    toDoList.displayTasks();
                    break;
                case 5:
                    toDoList.sortTasksByDate();
                    toDoList.displayTasks();
                    break;
                case 6:
                    toDoList.sortTasksByPriority();
                    toDoList.displayTasks();
                    break;
                case 7:
                    System.out.println("Введите слово:");
                    String keyword = scanner.nextLine();
                    toDoList.searchTasksByKeyword(keyword);
                    break;
                case 8:
                    System.out.println("Бай Бай");
                    break;
                default:
                    System.out.println("Инвалидный выбор(лол)");
            }
        } while (choice != 8);

        scanner.close();
    }
}