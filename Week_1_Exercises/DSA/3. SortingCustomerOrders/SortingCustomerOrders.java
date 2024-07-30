import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Order {
    int orderId;
    String customerName;
    double totalPrice;

    public Order(int orderId, String customerName, double totalPrice) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", customerName='" + customerName + '\'' +
                ", totalPrice=" + totalPrice +
                '}';
    }
}

public class SortingCustomerOrders {
    
    public static void bubbleSort(List<Order> orders) {
        int n = orders.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (orders.get(j).totalPrice > orders.get(j + 1).totalPrice) {
                    Order temp = orders.get(j);
                    orders.set(j, orders.get(j + 1));
                    orders.set(j + 1, temp);
                }
            }
        }
    }
    
    public static void quickSort(List<Order> orders, int low, int high) {
        if (low < high) {
            int pi = partition(orders, low, high);

            quickSort(orders, low, pi - 1);
            quickSort(orders, pi + 1, high);
        }
    }

    private static int partition(List<Order> orders, int low, int high) {
        Order pivot = orders.get(high);
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (orders.get(j).totalPrice < pivot.totalPrice) {
                i++;

               
                Order temp = orders.get(i);
                orders.set(i, orders.get(j));
                orders.set(j, temp);
            }
        }

        Order temp = orders.get(i + 1);
        orders.set(i + 1, orders.get(high));
        orders.set(high, temp);

        return i + 1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Order> orders = new ArrayList<>();

        System.out.println("Enter the number of orders: ");
        int numberOfOrders = scanner.nextInt();
        scanner.nextLine(); 
        for (int i = 0; i < numberOfOrders; i++) {
            System.out.println("Enter details for order " + (i + 1) + ": ");
            System.out.print("Order ID: ");
            int orderId = scanner.nextInt();
            scanner.nextLine(); 
            System.out.print("Customer Name: ");
            String customerName = scanner.nextLine();

            System.out.print("Total Price: ");
            double totalPrice = scanner.nextDouble();
            scanner.nextLine();
            orders.add(new Order(orderId, customerName, totalPrice));
        }

        System.out.println("Choose sorting method (1 for Bubble Sort, 2 for Quick Sort): ");
        int choice = scanner.nextInt();

        if (choice == 1) {
            bubbleSort(orders);
            System.out.println("Orders sorted using Bubble Sort:");
        } else if (choice == 2) {
            quickSort(orders, 0, orders.size() - 1);
            System.out.println("Orders sorted using Quick Sort:");
        } else {
            System.out.println("Invalid choice.");
            return;
        }

        for (Order order : orders) {
            System.out.println(order);
        }

        scanner.close();
    }
}