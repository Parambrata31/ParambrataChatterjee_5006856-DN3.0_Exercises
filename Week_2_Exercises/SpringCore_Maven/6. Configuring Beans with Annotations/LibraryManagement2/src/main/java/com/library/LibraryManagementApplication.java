package com.library;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.library.repository.BookRepository;
import com.library.service.BookService;

public class LibraryManagementApplication {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        BookService bookService = context.getBean("bookService", BookService.class);
        BookRepository bookRepository = context.getBean(BookRepository.class);

        // Test if beans are correctly injected and working
        if (bookService != null && bookRepository != null) {
            System.out.println("Beans have been successfully configured and retrieved.");
        } else {
            System.out.println("Failed to configure or retrieve beans.");
        }
        
        bookService.addBook("The Silent Patient", "Alex Michalides", "9781409181637");
        bookService.addBook("Harry Potter and the Philospher's Stone", "J.K Rowling", "9780451524935");
        bookService.addBook("The Merchant of Venice", "William Shakespeare", "9780141439518");
        
        Scanner scanner = new Scanner(System.in);
        String choice;

        do {
            System.out.println("\nLibrary Management System");
            System.out.println("1. Add a book");
            System.out.println("2. List all books");
            System.out.println("3. Search for a book by ISBN");
            System.out.println("4. Exit");
            System.out.print("Enter your choice (1-4): ");

            choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.print("Enter book title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter book author: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter book ISBN: ");
                    String isbn = scanner.nextLine();
                    bookService.addBook(title, author, isbn);
                    break;
                case "2":
                    bookService.listBooks();
                    break;
                case "3":
                    System.out.print("Enter the ISBN to search: ");
                    isbn = scanner.nextLine();
                    bookService.findBookByIsbn(isbn);
                    break;
                case "4":
                    System.out.println("Exiting the application. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (!choice.equals("4"));

        scanner.close();
    }
}