import java.util.ArrayList;
import java.util.Scanner;

class Task {
    String title;
    String description;
    String dueDate;
    boolean isComplete;

    Task(String title, String description, String dueDate) {
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        this.isComplete = false;
    }
}

public class ToDoListApp {
    public static void main(String[] args) {
        ArrayList<Task> taskList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== To-Do List Application =====");
            System.out.println("1. Add Task");
            System.out.println("2. Mark Task as Complete");
            System.out.println("3. View Tasks");
            System.out.println("4. Remove Task");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume the newline character

            switch (choice) {
                case 1:
                    addTask(taskList, scanner);
                    break;
                case 2:
                    markTaskAsComplete(taskList, scanner);
                    break;
                case 3:
                    viewTasks(taskList);
                    break;
                case 4:
                    removeTask(taskList, scanner);
                    break;
                case 5:
                    System.out.println("Exiting the application. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }

    private static void addTask(ArrayList<Task> taskList, Scanner scanner) {
        System.out.print("Enter task title: ");
        String title = scanner.nextLine();
        System.out.print("Enter task description: ");
        String description = scanner.nextLine();
        System.out.print("Enter due date: ");
        String dueDate = scanner.nextLine();

        Task newTask = new Task(title, description, dueDate);
        taskList.add(newTask);

        System.out.println("Task added successfully!");
    }

    private static void markTaskAsComplete(ArrayList<Task> taskList, Scanner scanner) {
        if (taskList.isEmpty()) {
            System.out.println("Task list is empty. No tasks to mark as complete.");
            return;
        }

        viewTasks(taskList);

        System.out.print("Enter the index of the task to mark as complete: ");
        int index = scanner.nextInt();
        scanner.nextLine();  // Consume the newline character

        if (index >= 0 && index < taskList.size()) {
            Task task = taskList.get(index);
            task.isComplete = true;
            System.out.println("Task marked as complete: " + task.title);
        } else {
            System.out.println("Invalid index. Please enter a valid index.");
        }
    }

    private static void viewTasks(ArrayList<Task> taskList) {
        if (taskList.isEmpty()) {
            System.out.println("Task list is empty.");
        } else {
            System.out.println("\n===== Task List =====");
            for (int i = 0; i < taskList.size(); i++) {
                Task task = taskList.get(i);
                System.out.println("Index: " + i);
                System.out.println("Title: " + task.title);
                System.out.println("Description: " + task.description);
                System.out.println("Due Date: " + task.dueDate);
                System.out.println("Status: " + (task.isComplete ? "Complete" : "Incomplete"));
                System.out.println("------------------------------");
            }
        }
    }

    private static void removeTask(ArrayList<Task> taskList, Scanner scanner) {
        if (taskList.isEmpty()) {
            System.out.println("Task list is empty. No tasks to remove.");
            return;
        }

        viewTasks(taskList);

        System.out.print("Enter the index of the task to remove: ");
        int index = scanner.nextInt();
        scanner.nextLine();  // Consume the newline character

        if (index >= 0 && index < taskList.size()) {
            Task removedTask = taskList.remove(index);
            System.out.println("Task removed successfully: " + removedTask.title);
        } else {
            System.out.println("Invalid index. Please enter a valid index.");
        }
    }
}


