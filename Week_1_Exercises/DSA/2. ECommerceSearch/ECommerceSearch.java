import java.util.Arrays;
import java.util.Scanner;

class Product implements Comparable<Product> {
    int productId;
    String productName;
    String category;

    public Product(int productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }

    @Override
    public int compareTo(Product other) {
        return Integer.compare(this.productId, other.productId);
    }

    @Override
    public String toString() {
        return "Product ID: " + productId + ", Name: " + productName + ", Category: " + category;
    }
}

public class ECommerceSearch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of products:");
        int n = scanner.nextInt();
        scanner.nextLine();  

        Product[] products = new Product[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Enter details for product " + (i + 1) + ":");
            System.out.print("Product ID: ");
            int productId = scanner.nextInt();
            scanner.nextLine();  
            System.out.print("Product Name: ");
            String productName = scanner.nextLine();
            System.out.print("Category: ");
            String category = scanner.nextLine();

            products[i] = new Product(productId, productName, category);
        }

        Arrays.sort(products);

        System.out.println("Enter product ID to search:");
        int searchId = scanner.nextInt();

        System.out.println("Linear Search Result:");
        Product resultLinear = linearSearch(products, searchId);
        if (resultLinear != null) {
            System.out.println(resultLinear);
        } else {
            System.out.println("Product not found.");
        }

        System.out.println("Binary Search Result:");
        Product resultBinary = binarySearch(products, searchId);
        if (resultBinary != null) {
            System.out.println(resultBinary);
        } else {
            System.out.println("Product not found.");
        }

        scanner.close();
    }

    public static Product linearSearch(Product[] products, int productId) {
        for (Product product : products) {
            if (product.productId == productId) {
                return product;
            }
        }
        return null;
    }

    public static Product binarySearch(Product[] products, int productId) {
        int left = 0;
        int right = products.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (products[mid].productId == productId) {
                return products[mid];
            }

            if (products[mid].productId < productId) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return null;
    }
}
