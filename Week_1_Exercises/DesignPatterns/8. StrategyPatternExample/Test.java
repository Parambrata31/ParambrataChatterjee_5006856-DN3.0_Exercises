import java.util.Scanner;
public class Test {
    public static void main(String[] args) {
        PaymentContext context = new PaymentContext();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Select payment method: 1. Credit Card 2. PayPal 3. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine();
            if (choice == 3) {
                break;
            }
            System.out.print("Enter amount to pay: ");
            double amount = scanner.nextDouble();
            scanner.nextLine(); 
            switch (choice) {
                case 1:
                    System.out.print("Enter Credit Card Number: ");
                    String cardNumber = scanner.nextLine();
                    System.out.print("Enter Card Holder Name: ");
                    String cardHolderName = scanner.nextLine();
                    System.out.print("Enter CVV: ");
                    String cvv = scanner.nextLine();
                    System.out.print("Enter Expiration Date: ");
                    String expirationDate = scanner.nextLine();
                    context.setPaymentStrategy(new CreditCardPayment(cardNumber, cardHolderName, cvv, expirationDate));
                    break;
                case 2:
                    System.out.print("Enter PayPal Email: ");
                    String email = scanner.nextLine();
                    System.out.print("Enter PayPal Password: ");
                    String password = scanner.nextLine();
                    context.setPaymentStrategy(new PayPalPayment(email, password));
                    break;
                default:
                    System.out.println("Invalid choice.");
                    continue;
            }

            context.executePayment(amount);
        }

        scanner.close();
    }
}
