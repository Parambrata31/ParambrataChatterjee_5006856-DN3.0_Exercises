import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter initial student details:");

        System.out.print("Name: ");
        String name = scanner.nextLine();

        System.out.print("ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); 

        System.out.print("Grade: ");
        String grade = scanner.nextLine();

        Student model = new Student(name, id, grade);
        StudentView view = new StudentView();
        StudentController controller = new StudentController(model, view);

        controller.updateView();

        System.out.println("\nUpdate student details:");

        System.out.print("New Name: ");
        name = scanner.nextLine();
        controller.setStudentName(name);

        System.out.print("New ID: ");
        id = scanner.nextInt();
        scanner.nextLine();  
        controller.setStudentId(id);

        System.out.print("New Grade: ");
        grade = scanner.nextLine();
        controller.setStudentGrade(grade);

        controller.updateView();

        scanner.close();
    }
}
