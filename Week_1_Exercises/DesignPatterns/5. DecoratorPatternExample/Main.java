import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create a basic EmailNotifier
        Notifier emailNotifier = new EmailNotifier();

        // Wrap EmailNotifier with SMSNotifierDecorator
        Notifier smsNotifier = new SMSNotifierDecorator(emailNotifier);

        // Further wrap with SlackNotifierDecorator
        Notifier slackNotifier = new SlackNotifierDecorator(smsNotifier);

        System.out.println("Enter your message:");
        String message = scanner.nextLine();

        // Send message using all decorators
        slackNotifier.send(message);

        scanner.close();
    }
}
