import java.util.*;
class Contact{
	String name;
	String phoneNumber;
	public Contact(String name,String phoneNumber) {
		this.name = name;
		this.phoneNumber = phoneNumber;
	}

}

class InvalidPhoneNumberException extends Exception {
    InvalidPhoneNumberException(String msg) {
        super(msg);
    }
}
class ContactOrganizer {
	ArrayList<Contact> contacts = new ArrayList<>();
	
	public void addContact (String name,String number) throws InvalidPhoneNumberException {
		if(number.length()!=10) {
			throw new InvalidPhoneNumberException("Phone number must be 10 digits");
		}
		
		for(Contact c : contacts) {
			if(c.phoneNumber.equals(number)) {
				System.out.println("Duplicate numbers not allowed");
				return;
			}
		}
		contacts.add(new Contact(name,number));
		System.out.println("Contact added");
	}
	
	public void deleteContact(String number) {
		for(Contact c : contacts) {
			if(c.phoneNumber.equals(number)) {
				contacts.remove(c);
				System.out.println("Contact Deleted");
				return;
			}
		}
		System.out.println("Contact not found");
	}
	
	public void searchContact(String number) {
		for(Contact c : contacts) {
			if(c.phoneNumber.equals(number)) {
				System.out.println(c.name + " - " + c.phoneNumber);
				return;
			}
		}
		System.out.println("Contact not found");
	}
	
}
public class MobileApp {

	public static void main(String[] args) {
		
		
		ContactOrganizer c = new ContactOrganizer();

        try {
            c.addContact("Harsh", "9876543210");
            c.addContact("Ankit", "9876543210"); // duplicate
            c.addContact("Rahul", "12345");      // invalid
        } catch (InvalidPhoneNumberException e) {
            System.out.println(e.getMessage());
        }

        c.searchContact("9876543210");
        c.deleteContact("9876543210");
        c.searchContact("9876543210");

	}

}