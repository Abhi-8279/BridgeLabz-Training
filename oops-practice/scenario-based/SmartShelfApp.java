import java.util.*;

// ---------------- OOP: BOOK ----------------
class Book {
    private String title;
    private String author;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public String toString() {
        return title + " by " + author;
    }
}

// ---------------- SMART SHELF ----------------
class SmartShelf {
    private List<Book> readingList;

    public SmartShelf() {
        readingList = new ArrayList<>();
    }

    // Add book and keep list sorted (Insertion Sort)
    public void addBook(Book book) {
        readingList.add(book);
        insertionSort();
        System.out.println("📘 Added: " + book.getTitle());
    }

    // Insertion Sort by title (STABLE)
    private void insertionSort() {
        for (int i = 1; i < readingList.size(); i++) {
            Book key = readingList.get(i);
            int j = i - 1;

            // Stable comparison using compareToIgnoreCase
            while (j >= 0 &&
                    readingList.get(j).getTitle()
                            .compareToIgnoreCase(key.getTitle()) > 0) {
                readingList.set(j + 1, readingList.get(j));
                j--;
            }
            readingList.set(j + 1, key);
        }
    }

    // Print shelf state
    public void displayShelf() {
        if (readingList.isEmpty()) {
            System.out.println("📚 Shelf is empty.");
            return;
        }

        System.out.println("\n📚 SmartShelf (Sorted by Title):");
        for (Book book : readingList) {
            System.out.println(" - " + book);
        }
    }
}

// ---------------- MAIN CLASS ----------------
public class SmartShelfApp {
    public static void main(String[] args) {

        SmartShelf shelf = new SmartShelf();

        // Case 1: Empty shelf
        shelf.displayShelf();

        // Case 2: Add first book
        shelf.addBook(new Book("Java Programming", "James Gosling"));
        shelf.displayShelf();

        // Case 3: Add books in nearly sorted order
        shelf.addBook(new Book("Algorithms", "CLRS"));
        shelf.addBook(new Book("Data Structures", "Mark Allen Weiss"));
        shelf.displayShelf();

        // Case 4: Add book that goes in middle
        shelf.addBook(new Book("Clean Code", "Robert C. Martin"));
        shelf.displayShelf();

        // Case 5: Duplicate title (stability check)
        shelf.addBook(new Book("Java Programming", "Some Other Author"));
        shelf.displayShelf();

        // Case 6: Case-insensitive sorting
        shelf.addBook(new Book("android development", "Google"));
        shelf.displayShelf();
    }
}

