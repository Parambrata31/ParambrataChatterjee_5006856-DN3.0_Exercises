import java.util.Scanner;

public class TestComputer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create a new Builder
        Computer.Builder builder = new Computer.Builder();

        // Get user input for each attribute
        System.out.println("Enter CPU: ");
        builder.setCPU(scanner.nextLine());

        System.out.println("Enter RAM: ");
        builder.setRAM(scanner.nextLine());

        System.out.println("Enter Storage: ");
        builder.setStorage(scanner.nextLine());

        System.out.println("Enter GPU: ");
        builder.setGPU(scanner.nextLine());

        System.out.println("Enter Motherboard: ");
        builder.setMotherboard(scanner.nextLine());

        System.out.println("Enter Power Supply: ");
        builder.setPowerSupply(scanner.nextLine());

        // Build the Computer object
        Computer computer = builder.build();

        // Print the created Computer object
        System.out.println("Created Computer: " + computer);

        scanner.close();
    }
}
