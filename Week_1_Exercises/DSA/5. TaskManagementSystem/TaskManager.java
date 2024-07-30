import java.util.Scanner;
class Task {
    int taskId;
    String taskName;
    String status;

    public Task(int taskId, String taskName, String status) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Task{" +
                "taskId=" + taskId +
                ", taskName='" + taskName + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}

class TaskNode {
    Task task;
    TaskNode next;

    public TaskNode(Task task) {
        this.task = task;
        this.next = null;
    }
}

class TaskLinkedList {
    private TaskNode head;

    public TaskLinkedList() {
        this.head = null;
    }

    // Add a new task to the linked list
    public void addTask(Task task) {
        TaskNode newNode = new TaskNode(task);
        if (head == null) {
            head = newNode;
        } else {
            TaskNode current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    // Search for a task by taskId
    public Task searchTask(int taskId) {
        TaskNode current = head;
        while (current != null) {
            if (current.task.taskId == taskId) {
                return current.task;
            }
            current = current.next;
        }
        return null;
    }

    // Traverse and display all tasks
    public void traverseTasks() {
        TaskNode current = head;
        while (current != null) {
            System.out.println(current.task);
            current = current.next;
        }
    }

    // Delete a task by taskId
    public boolean deleteTask(int taskId) {
        if (head == null) {
            return false;
        }
        if (head.task.taskId == taskId) {
            head = head.next;
            return true;
        }
        TaskNode current = head;
        while (current.next != null) {
            if (current.next.task.taskId == taskId) {
                current.next = current.next.next;
                return true;
            }
            current = current.next;
        }
        return false;
    }
}

public class TaskManager {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TaskLinkedList taskList = new TaskLinkedList();

        while (true) {
            System.out.println("1. Add a task");
            System.out.println("2. Search for a task by ID");
            System.out.println("3. Traverse and display all tasks");
            System.out.println("4. Delete a task by ID");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = getIntInput(scanner);

            switch (choice) {
                case 1:
                    addTask(scanner, taskList);
                    break;
                case 2:
                    searchTask(scanner, taskList);
                    break;
                case 3:
                    traverseTasks(taskList);
                    break;
                case 4:
                    deleteTask(scanner, taskList);
                    break;
                case 5:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addTask(Scanner scanner, TaskLinkedList taskList) {
        System.out.print("Enter task ID: ");
        int taskId = getIntInput(scanner);
        System.out.print("Enter task name: ");
        String taskName = scanner.nextLine();
        System.out.print("Enter task status: ");
        String status = scanner.nextLine();
        taskList.addTask(new Task(taskId, taskName, status));
    }

    private static void searchTask(Scanner scanner, TaskLinkedList taskList) {
        System.out.print("Enter task ID to search: ");
        int taskId = getIntInput(scanner);
        Task task = taskList.searchTask(taskId);
        if (task != null) {
            System.out.println("Task found: " + task);
        } else {
            System.out.println("Task not found.");
        }
    }

    private static void traverseTasks(TaskLinkedList taskList) {
        System.out.println("Tasks:");
        taskList.traverseTasks();
    }

    private static void deleteTask(Scanner scanner, TaskLinkedList taskList) {
        System.out.print("Enter task ID to delete: ");
        int taskId = getIntInput(scanner);
        boolean result = taskList.deleteTask(taskId);
        if (result) {
            System.out.println("Task deleted successfully.");
        } else {
            System.out.println("Task not found.");
        }
    }

    private static int getIntInput(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.next();
        }
        int input = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        return input;
    }
}