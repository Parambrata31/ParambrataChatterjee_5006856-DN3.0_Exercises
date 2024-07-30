import java.util.Scanner;

class Employee {
    int employeeId;
    String name;
    String position;
    double salary;

    public Employee(int employeeId, String name, String position, double salary) {
        this.employeeId = employeeId;
        this.name = name;
        this.position = position;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee ID: " + employeeId + ", Name: " + name + ", Position: " + position + ", Salary: " + salary;
    }
}

public class EmployeeManagementSystem {
    private static Employee[] employees = new Employee[100];  
    private static int employeeCount = 0;  
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("Employee Management System");
            System.out.println("1. Add Employee");
            System.out.println("2. Search Employee");
            System.out.println("3. Traverse Employees");
            System.out.println("4. Delete Employee");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    addEmployee(scanner);
                    break;
                case 2:
                    searchEmployee(scanner);
                    break;
                case 3:
                    traverseEmployees();
                    break;
                case 4:
                    deleteEmployee(scanner);
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);

        scanner.close();
    }

    public static void addEmployee(Scanner scanner) {
        if (employeeCount >= employees.length) {
            System.out.println("Employee array is full.");
            return;
        }

        System.out.println("Enter Employee ID:");
        int id = scanner.nextInt();
        scanner.nextLine();  // Consume newline
        System.out.println("Enter Name:");
        String name = scanner.nextLine();
        System.out.println("Enter Position:");
        String position = scanner.nextLine();
        System.out.println("Enter Salary:");
        double salary = scanner.nextDouble();

        employees[employeeCount++] = new Employee(id, name, position, salary);
        System.out.println("Employee added successfully.");
    }

    public static void searchEmployee(Scanner scanner) {
        System.out.println("Enter Employee ID to search:");
        int id = scanner.nextInt();
        boolean found = false;

        for (int i = 0; i < employeeCount; i++) {
            if (employees[i].employeeId == id) {
                System.out.println("Employee found: " + employees[i]);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Employee not found.");
        }
    }

    public static void traverseEmployees() {
        if (employeeCount == 0) {
            System.out.println("No employees to display.");
            return;
        }

        System.out.println("Employee Records:");
        for (int i = 0; i < employeeCount; i++) {
            System.out.println(employees[i]);
        }
    }

    public static void deleteEmployee(Scanner scanner) {
        System.out.println("Enter Employee ID to delete:");
        int id = scanner.nextInt();
        boolean found = false;

        for (int i = 0; i < employeeCount; i++) {
            if (employees[i].employeeId == id) {
                // Shift elements to fill the gap
                for (int j = i; j < employeeCount - 1; j++) {
                    employees[j] = employees[j + 1];
                }
                employees[--employeeCount] = null;  
                System.out.println("Employee deleted successfully.");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Employee not found.");
        }
    }
}
