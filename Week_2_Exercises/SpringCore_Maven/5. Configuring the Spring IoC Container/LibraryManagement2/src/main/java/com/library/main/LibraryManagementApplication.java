package com.library.main;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.library.service.BookService;

public class LibraryManagementApplication {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        BookService bookService = context.getBean("bookService", BookService.class);
        
        bookService.addBook("Merchant of Venice", "William Shakespeare", "9781409181637");
        bookService.addBook("Hamlet", "William Shakespeare", "9780451524935");
        bookService.addBook("Pride and Prejudice", "Jane Austen", "9780141439518");
        bookService.addBook("Chander Pahar", "Bibhutibushan Bandhopadhay", "9780743273565");
        bookService.addBook("After", "Anna Todd", "9780008294373");

        Scanner scanner = new Scanner(System.in);
        String choice;

        do {
            System.out.println("\nLibrary Management System");
            System.out.println("1. Add a new book");
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
                    System.out.println("Exiting the application.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (!choice.equals("4"));

        scanner.close();
    }
}