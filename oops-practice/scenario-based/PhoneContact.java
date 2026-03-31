import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class InvalidPhoneNumberException extends Exception {
    public InvalidPhoneNumberException(String message) {
        super(message);
    }
}

class Contact {
    private String name;
    private String phoneNumber;

    public Contact(String name, String phoneNumber) throws InvalidPhoneNumberException {
        if (!phoneNumber.matches("\\d{10}")) {
            throw new InvalidPhoneNumberException("Invalid phone number");
        }
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}

class ContactOrganizer {
    private List<Contact> contacts = new ArrayList<>();

    public void addContact(String name, String phoneNumber) throws InvalidPhoneNumberException {
        for (Contact c : contacts) {
            if (c.getPhoneNumber().equals(phoneNumber)) {
                return;
            }
        }
        contacts.add(new Contact(name, phoneNumber));
    }

    public void deleteContact(String phoneNumber) {
        Iterator<Contact> it = contacts.iterator();
        while (it.hasNext()) {
            if (it.next().getPhoneNumber().equals(phoneNumber)) {
                it.remove();
                return;
            }
        }
    }

    public Contact searchContact(String phoneNumber) {
        for (Contact c : contacts) {
            if (c.getPhoneNumber().equals(phoneNumber)) {
                return c;
            }
        }
        return null;
    }

    public List<Contact> getAllContacts() {
        return contacts;
    }
}

public class PhoneContact {
    public static void main(String[] args) {
        try {
            ContactOrganizer organizer = new ContactOrganizer();
            organizer.addContact("Abhay", "9876543210");
            organizer.addContact("Aashika", "9123456789");

            Contact c = organizer.searchContact("9876543210");
            if (c != null) {
                System.out.println(c.getName() + " " + c.getPhoneNumber());
            }

            organizer.deleteContact("9123456789");
        } catch (InvalidPhoneNumberException e) {
            System.out.println(e.getMessage());
        }
    }
}