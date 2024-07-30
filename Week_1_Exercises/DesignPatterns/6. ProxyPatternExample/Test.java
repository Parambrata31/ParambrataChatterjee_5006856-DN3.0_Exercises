import java.util.Scanner;
public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the name of the first image file to display: ");
        String fileName1 = scanner.nextLine();
        Image image1 = new ProxyImage(fileName1);
        System.out.print("Enter the name of the second image file to display: ");
        String fileName2 = scanner.nextLine();
        Image image2 = new ProxyImage(fileName2);
        System.out.println("\nDisplaying the first image:");
        image1.display();
        System.out.println("\nDisplaying the first image again:");
        image1.display();
        System.out.println("\nDisplaying the second image:");
        image2.display();
        System.out.println("\nDisplaying the second image again:");
        image2.display();
        scanner.close();
    }
}
