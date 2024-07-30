import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose a payment method:");
        System.out.println("1. PayPal");
        System.out.println("2. Stripe");
        System.out.print("Enter choice: ");
        int choice = scanner.nextInt();

        System.out.print("Enter the payment amount: ");
        double amount = scanner.nextDouble();

        PaymentProcessor paymentProcessor;

        switch (choice) {
            case 1:
                PayPal payPal = new PayPal();
                paymentProcessor = new PayPalAdapter(payPal);
                break;
            case 2:
                Stripe stripe = new Stripe();
                paymentProcessor = new StripeAdapter(stripe);
                break;
            default:
                System.out.println("Invalid choice. Defaulting to PayPal.");
                payPal = new PayPal();
                paymentProcessor = new PayPalAdapter(payPal);
                break;
        }

        paymentProcessor.processPayment(amount);

        scanner.close();
    }
}
