package com.library.repository;
import java.util.ArrayList;
import java.util.List;
public class BookRepository {
    private List<String> books = new ArrayList<>();
    public void addBook(String book) {
        books.add(book);
    }
    public void printBooks() {
        System.out.println("Books in the repository:");
        for (String book : books) {
            System.out.println(book);
        }
    }
    public void displayRepositoryInfo() {
        System.out.println("This is the BookRepository.");
    }
    public void printRepository() {
        System.out.println("BookRepository print method.");
    }
}
