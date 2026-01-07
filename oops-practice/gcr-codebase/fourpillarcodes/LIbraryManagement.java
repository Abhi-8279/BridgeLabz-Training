import java.util.*;
//interface
interface Reservable {
    void reserveItem(String borrowerName);
    boolean checkAvailability();
}
//abstract class
abstract class LibraryItem {

    // Encapsulation
    private int itemId;
    private String title;
    private String author;

    // sensitive data (borrower)
    private String borrowerName;
    private boolean isAvailable = true;

    public LibraryItem(int itemId, String title, String author) {
        this.itemId = itemId;
        this.title = title;
        this.author = author;
    }

    //getter setter 
    public int getItemId() {
        return itemId;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    protected void setBorrower(String borrowerName) {
        this.setBorrowerName(borrowerName);
        this.isAvailable = false;
    }

    protected boolean isAvailable() {
        return isAvailable;
    }

    // Abstract method
    public abstract int getLoanDuration();

    // Concrete method
    public void getItemDetails() {
        System.out.println("Item ID: " + itemId);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
    }

	public String getBorrowerName() {
		return borrowerName;
	}

	public void setBorrowerName(String borrowerName) {
		this.borrowerName = borrowerName;
	}
}
class Book extends LibraryItem implements Reservable {

    public Book(int id, String title, String author) {
        super(id, title, author);
    }

    @Override
    public int getLoanDuration() {
        return 14; // 14 days
    }

    @Override
    public void reserveItem(String borrowerName) {
        if (isAvailable()) {
            setBorrower(borrowerName);
            System.out.println("Book reserved by " + borrowerName);
        } else {
            System.out.println("Book is already reserved");
        }
    }

    @Override
    public boolean checkAvailability() {
        return isAvailable();
    }
}
class Magazine extends LibraryItem implements Reservable {

    public Magazine(int id, String title, String author) {
        super(id, title, author);
    }

    @Override
    public int getLoanDuration() {
        return 7; // 7 days
    }

    @Override
    public void reserveItem(String borrowerName) {
        if (isAvailable()) {
            setBorrower(borrowerName);
            System.out.println("Magazine reserved by " + borrowerName);
        } else {
            System.out.println("Magazine is already reserved");
        }
    }

    @Override
    public boolean checkAvailability() {
        return isAvailable();
    }
}
class DVD extends LibraryItem implements Reservable {

    public DVD(int id, String title, String author) {
        super(id, title, author);
    }

    @Override
    public int getLoanDuration() {
        return 3; // 3 days
    }

    @Override
    public void reserveItem(String borrowerName) {
        if (isAvailable()) {
            setBorrower(borrowerName);
            System.out.println("DVD reserved by " + borrowerName);
        } else {
            System.out.println("DVD is already reserved");
        }
    }

    @Override
    public boolean checkAvailability() {
        return isAvailable();
    }
}


public class LIbraryManagement {
	 public static void main(String[] args) {

	        List<LibraryItem> items = new ArrayList<>();

	        items.add(new Book(101, "Java Basics", "James Gosling"));
	        items.add(new Magazine(102, "Tech Today", "Editorial Team"));
	        items.add(new DVD(103, "Inception", "Christopher Nolan"));

	        for (LibraryItem item : items) {

	            item.getItemDetails();
	            System.out.println("Loan Duration: " + item.getLoanDuration() + " days");

	            if (item instanceof Reservable) {
	                Reservable r = (Reservable) item;
	                System.out.println("Available: " + r.checkAvailability());
	                r.reserveItem("Rohit");
	                System.out.println("Available After Reserve: " + r.checkAvailability());
	            }

	            System.out.println("----------------------------");
	        }
	 }
}