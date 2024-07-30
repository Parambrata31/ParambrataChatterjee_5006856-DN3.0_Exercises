import java.util.Scanner;

public class TestLogger {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get the single instance of Logger
        Logger logger1 = Logger.getInstance();

        // Log a message
        System.out.println("Enter a log message: ");
        String message1 = scanner.nextLine();
        logger1.log(message1);

        // Get the instance of Logger again
        Logger logger2 = Logger.getInstance();

        // Log another message
        System.out.println("Enter another log message: ");
        String message2 = scanner.nextLine();
        logger2.log(message2);

        // Verify if both instances are the same
        if (logger1 == logger2) {
            System.out.println("Logger1 and Logger2 are the same instance.");
        } else {
            System.out.println("Logger1 and Logger2 are different instances.");
        }

        scanner.close();
    }
}
