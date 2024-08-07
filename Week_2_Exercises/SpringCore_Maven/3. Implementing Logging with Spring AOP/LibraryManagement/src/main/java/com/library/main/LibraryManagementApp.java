package com.library.main;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.library.service.BookService;
import java.util.Scanner;

public class LibraryManagementApp {

    public static void main(String[] args) {
        // Load the Spring context from the XML configuration file
        try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml")) {
            // Retrieve the BookService bean
            BookService bookService = (BookService) context.getBean("bookService");

            // Scanner for user input
            Scanner scanner = new Scanner(System.in);

            while (true) {
                System.out.println("1. Add book");
                System.out.println("2. Print books");
                System.out.println("3. Perform service");
                System.out.println("4. Exit");
                System.out.print("Enter choice: ");
                int choice = scanner.nextInt();
                scanner.nextLine(); // consume newline

                if (choice == 1) {
                    System.out.print("Enter book name: ");
                    String bookName = scanner.nextLine();
                    bookService.addBook(bookName);
                } else if (choice == 2) {
                    bookService.printBooks();
                } else if (choice == 3) {
                    bookService.performService();
                } else if (choice == 4) {
                    System.out.println("Exiting...");
                    break;
                } else {
                    System.out.println("Invalid choice. Try again.");
                }
            }
            scanner.close();
        }
    }
}
