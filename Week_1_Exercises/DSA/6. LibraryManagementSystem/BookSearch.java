import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class Book implements Comparable<Book> {
    int bookId;
    String title;
    String author;

    public Book(int bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                '}';
    }

    @Override
    public int compareTo(Book other) {
        return this.title.compareTo(other.title);
    }
}

public class BookSearch {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Book> books = new ArrayList<>();

        while (true) {
            System.out.println("1. Add a book");
            System.out.println("2. Search for a book by title using linear search");
            System.out.println("3. Search for a book by title using binary search");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = getIntInput(scanner);

            switch (choice) {
                case 1:
                    addBook(scanner, books);
                    break;
                case 2:
                    searchBookLinear(scanner, books);
                    break;
                case 3:
                    searchBookBinary(scanner, books);
                    break;
                case 4:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addBook(Scanner scanner, List<Book> books) {
        System.out.print("Enter book ID: ");
        int bookId = getIntInput(scanner);
        System.out.print("Enter book title: ");
        String title = scanner.nextLine();
        System.out.print("Enter book author: ");
        String author = scanner.nextLine();
        books.add(new Book(bookId, title, author));
    }

    private static void searchBookLinear(Scanner scanner, List<Book> books) {
        System.out.print("Enter the title of the book to search: ");
        String titleToSearch = scanner.nextLine();
        Book result = linearSearch(books, titleToSearch);
        displaySearchResult(result);
    }

    private static void searchBookBinary(Scanner scanner, List<Book> books) {
        System.out.print("Enter the title of the book to search: ");
        String titleToSearch = scanner.nextLine();
        Collections.sort(books); // Sort the list for binary search
        Book result = binarySearch(books, titleToSearch);
        displaySearchResult(result);
    }

    private static int getIntInput(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.next();
        }
        int input = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        return input;
    }

    private static Book linearSearch(List<Book> books, String title) {
        for (Book book : books) {
            if (book.title.equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

    private static Book binarySearch(List<Book> books, String title) {
        int left = 0;
        int right = books.size() - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            int comparison = books.get(mid).title.compareToIgnoreCase(title);

            if (comparison == 0) {
                return books.get(mid);
            } else if (comparison < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return null;
    }

    private static void displaySearchResult(Book result) {
        if (result != null) {
            System.out.println("Book found: " + result);
        } else {
            System.out.println("Book not found.");
        }
    }
}
