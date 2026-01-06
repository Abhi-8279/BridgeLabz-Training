class LibrarySystem {

    static String[] titles = {
        "Java Programming",
        "Python Basics",
        "Data Structures",
        "Web Development"
    };

    static String[] authors = {
        "James Gosling",
        "Guido van Rossum",
        "Mark Allen",
        "Tim Berners-Lee"
    };

    static boolean[] isAvailable = { true, true, true, true };

    // Display all books
    static void displayBooks() {
        System.out.println("\nLibrary Books:");
        for (int i = 0; i < titles.length; i++) {
            System.out.println((i + 1) + ". " + titles[i] + " | " +
                    authors[i] + " | " +
                    (isAvailable[i] ? "Available" : "Checked Out"));
        }
    }

    // Search book by partial title
    static void searchBook(String keyword) {
        System.out.println("\nSearch Results:");
        for (int i = 0; i < titles.length; i++) {
            if (titles[i].toLowerCase().contains(keyword.toLowerCase())) {
                System.out.println(titles[i] + " by " + authors[i]);
            }
        }
    }

    // Checkout a book
    static void checkoutBook(int index) {
        if (isAvailable[index]) {
            isAvailable[index] = false;
            System.out.println("Book checked out successfully.");
        } else {
            System.out.println("Book is already checked out.");
        }
    }

    public static void main(String[] args) {
        displayBooks();
        searchBook("java");
        checkoutBook(0);   // Checkout first book
        displayBooks();
    }
}
