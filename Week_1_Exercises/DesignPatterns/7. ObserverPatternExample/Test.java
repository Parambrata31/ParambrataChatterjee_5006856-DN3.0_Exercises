import java.util.Scanner;
public class Test {
    public static void main(String[] args) {
        StockMarket stockMarket = new StockMarket();
        Observer mobileApp = new MobileApp("MobileApp");
        Observer webApp = new WebApp("WebApp");
        stockMarket.registerObserver(mobileApp);
        stockMarket.registerObserver(webApp);
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Enter new stock price (or 'exit' to quit): ");
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("exit")) {
                break;
            }
            try {
                double price = Double.parseDouble(input);
                stockMarket.setPrice(price);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }
        scanner.close();
    }
}
