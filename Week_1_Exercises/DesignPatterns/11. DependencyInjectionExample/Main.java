import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        CustomerRepositoryImpl customerRepository = new CustomerRepositoryImpl();

        CustomerService customerService = new CustomerService(customerRepository);

        System.out.println("Enter the number of customers to add:");
        int numberOfCustomers = scanner.nextInt();
        scanner.nextLine();  

        for (int i = 0; i < numberOfCustomers; i++) {
            System.out.println("Enter Customer ID:");
            int id = scanner.nextInt();
            scanner.nextLine();  
            System.out.println("Enter Customer Name:");
            String name = scanner.nextLine();
            customerService.addCustomer(id, name);
            System.out.println("Customer added successfully.");
        }

        System.out.println("Enter Customer ID to find:");
        int customerId = scanner.nextInt();

        String customerName = customerService.getCustomerNameById(customerId);
        System.out.println("Customer Name: " + customerName);

        scanner.close();
    }
}
