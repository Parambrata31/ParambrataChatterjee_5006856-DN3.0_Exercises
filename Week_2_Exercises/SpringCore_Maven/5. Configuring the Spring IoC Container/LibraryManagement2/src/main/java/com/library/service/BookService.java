 
package com.library.service;

import com.library.model.Book;
import com.library.repository.BookRepository;

import java.util.List;

public class BookService {
    private BookRepository bookRepository;

    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void addBook(String title, String author, String isbn) {
        Book book = new Book(title, author, isbn);
        bookRepository.addBook(book);
        System.out.println("Added book: " + book);
    }

    public void listBooks() {
        List<Book> books = bookRepository.getAllBooks();
        System.out.println("All books in the library:");
        for (Book book : books) {
            System.out.println(book);
        }
    }

    public void findBookByIsbn(String isbn) {
        Book book = bookRepository.findBookByIsbn(isbn);
        if (book != null) {
            System.out.println("Found book: " + book);
        } else {
            System.out.println("Book with ISBN " + isbn + " not found.");
        }
    }
}