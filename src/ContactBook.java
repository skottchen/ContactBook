import java.util.ArrayList;
import java.util.Scanner;

public class ContactBook{
	
	private ArrayList<Contact> list = new ArrayList<Contact>();
	Scanner s = new Scanner(System.in);
	public void view() {
		System.out.println("\nViewing all Contact Book entries");
		for (int i = 0; i < list.size(); i++) {
			System.out.println("-----------");
			System.out.println("Entry #" + (i + 1));
			System.out.println(list.get(i).toString());
		}
	}

	public void add(String name, String email, String phoneNumber) {
		Contact contact = new Contact(name, email, phoneNumber);
		for (Contact c : list) {
			if (c.equals(contact)) {
				System.out.println("\nContact with phone number, name, and " + "email already exists in contact book");
				return;
			}
		}

		list.add(contact);
		int entryNum = list.indexOf(contact) + 1;
		System.out.println("Entry # " + entryNum + " successfully added to contact book!\n");
	}

	public void edit(int entry) {
		int index = entry - 1;
		Contact contact = list.get(index);
		
		System.out.println("\nEntry #" + (entry));
		System.out.println(contact.toString());
				
		System.out.print("\nEdit name: ");
		String name = s.nextLine();
		contact.setName(name);
		
		System.out.print("Edit Email: ");
		String email = s.nextLine();
		contact.setEmail(email);
		
		System.out.print("Edit phone number: ");
		String phoneNumber = s.nextLine();
		contact.setPhoneNumber(phoneNumber);
		
		System.out.println("\nContact edited successfully!");
	}
	
	public void delete(int entry) {
		int index = entry - 1;
		list.remove(index);
		System.out.println("\nEntry #" + entry + " sucessfully deleted!");
	}
	
	public int getSize() {
		return list.size();
	}
	
}
