package com.library.service;
import com.library.repository.BookRepository;
public class BookService {
    private BookRepository bookRepository;
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
        System.out.println("Dependency injection verified: BookRepository has been set.");
    }
    public void addBook(String book) {
        bookRepository.addBook(book);
    }
    public void printBooks() {
        bookRepository.printBooks();
    }
    public void performService() {
        System.out.println("Performing service using BookRepository...");
        if (bookRepository != null) {
            bookRepository.displayRepositoryInfo();
        } else {
            System.out.println("BookRepository is not initialized.");
        }
    }
}
