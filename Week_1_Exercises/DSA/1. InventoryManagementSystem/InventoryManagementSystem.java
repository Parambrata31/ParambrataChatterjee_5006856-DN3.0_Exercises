import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Product {
    private String productId;
    private String productName;
    private int quantity;
    private double price;

    public Product(String productId, String productName, int quantity, double price) {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }

    public String getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId='" + productId + '\'' +
                ", productName='" + productName + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }
}


public class InventoryManagementSystem {
    private Map<String, Product> productMap;

    public InventoryManagementSystem() {
        productMap = new HashMap<>();
    }

    public void addProduct(Product product) {
        if (product != null && product.getProductId() != null) {
            productMap.put(product.getProductId(), product);
            System.out.println("Product added successfully.");
        } else {
            System.out.println("Invalid product details.");
        }
    }

    public void updateProduct(Product product) {
        if (product != null && product.getProductId() != null) {
            productMap.put(product.getProductId(), product);
            System.out.println("Product updated successfully.");
        } else {
            System.out.println("Invalid product details.");
        }
    }

    public void deleteProduct(String productId) {
        if (productId != null && productMap.containsKey(productId)) {
            productMap.remove(productId);
            System.out.println("Product deleted successfully.");
        } else {
            System.out.println("Product ID not found.");
        }
    }

    public void displayAllProducts() {
        if (productMap.isEmpty()) {
            System.out.println("No products available.");
        } else {
            for (Product product : productMap.values()) {
                System.out.println(product);
            }
        }
    }

    public static void main(String[] args) {
        InventoryManagementSystem ims = new InventoryManagementSystem();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nInventory Management System");
            System.out.println("1. Add Product");
            System.out.println("2. Update Product");
            System.out.println("3. Delete Product");
            System.out.println("4. Display All Products");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Product ID: ");
                    String addProductId = scanner.nextLine();
                    System.out.print("Enter Product Name: ");
                    String addProductName = scanner.nextLine();
                    System.out.print("Enter Quantity: ");
                    int addQuantity = scanner.nextInt();
                    System.out.print("Enter Price: ");
                    double addPrice = scanner.nextDouble();
                    ims.addProduct(new Product(addProductId, addProductName, addQuantity, addPrice));
                    break;

                case 2:
                    System.out.print("Enter Product ID to Update: ");
                    String updateProductId = scanner.nextLine();
                    System.out.print("Enter New Product Name: ");
                    String updateProductName = scanner.nextLine();
                    System.out.print("Enter New Quantity: ");
                    int updateQuantity = scanner.nextInt();
                    System.out.print("Enter New Price: ");
                    double updatePrice = scanner.nextDouble();
                    ims.updateProduct(new Product(updateProductId, updateProductName, updateQuantity, updatePrice));
                    break;

                case 3:
                    System.out.print("Enter Product ID to Delete: ");
                    String deleteProductId = scanner.nextLine();
                    ims.deleteProduct(deleteProductId);
                    break;

                case 4:
                    ims.displayAllProducts();
                    break;

                case 5:
                    System.out.println("Exiting Inventory Management System.");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);

        scanner.close();
    }
}
