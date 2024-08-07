package com.library.main;
import com.library.repository.BookRepository;
import com.library.service.BookService;
import java.util.Scanner;
public class LibraryManagementApp {
    public static void main(String[] args) {
        BookRepository bookRepository = new BookRepository();
        BookService bookService = new BookService();
        bookService.setBookRepository(bookRepository);
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. Add book");
            System.out.println("2. Print books");
            System.out.println("3. Perform service");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 
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
