import java.util.InputMismatchException;
import java.util.Scanner;

public class ContactBookClient {

    private static Scanner s = new Scanner(System.in);

    public static void main(String[] args) {
        ContactBook contactBook = new ContactBook();
        int userInput;

        do {
            displayMenu();
            userInput = getValidMenuOption();

            switch (userInput) {
                case 1:
                    if (contactBook.getSize() != 0) {
                        contactBook.view();  // Assuming `view()` prints the contacts
                    } else {
                        System.out.println("There are no contacts to view.");
                    }
                    break;
                case 2:
                    addContact(contactBook);  // Assuming `add()` takes name, email, and phone number
                    break;
                case 3:
                    if (contactBook.getSize() != 0) {
                        editContact(contactBook);  // Assuming `edit()` modifies a contact
                    } else {
                        System.out.println("There are no contacts to edit.");
                    }
                    break;
                case 4:
                    if (contactBook.getSize() != 0) {
                        deleteContact(contactBook);  // Assuming `delete()` removes a contact
                    } else {
                        System.out.println("There are no contacts to delete.");
                    }
                    break;
                case 5:
                    System.out.println("Exiting program...");
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        } while (userInput != 5);

        s.close();
    }

    // Displays the menu options
    private static void displayMenu() {
        System.out.println("Contact Book Menu:");
        System.out.println("1 - View contacts");
        System.out.println("2 - Add a new contact");
        System.out.println("3 - Edit a contact");
        System.out.println("4 - Delete a contact");
        System.out.println("5 - Quit");
        System.out.print("Choose an option: ");
    }

    // Gets a valid menu option between 1 and 5
    private static int getValidMenuOption() {
        int userInput = -1;
        boolean inputValid = false;

        do {
            try {
                userInput = s.nextInt();
                if (userInput >= 1 && userInput <= 5) {
                    inputValid = true;
                } else {
                    System.out.println("Invalid input. Please enter a number between 1 and 5.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                s.next(); // Clear invalid input
            }
        } while (!inputValid);

        s.nextLine(); // Consume leftover newline
        return userInput;
    }

    // Adds a new contact to the contact book
    private static void addContact(ContactBook contactBook) {
        System.out.print("Enter contact name: ");
        String name = s.nextLine();

        System.out.print("Enter contact email: ");
        String email = s.nextLine();

        System.out.print("Enter contact phone number: ");
        String phoneNumber = s.nextLine();

        contactBook.add(name, email, phoneNumber);  // Assuming `add(String, String, String)` method exists
        System.out.println("Contact added successfully.");
    }

    // Edits a contact from the contact book
    private static void editContact(ContactBook contactBook) {
        int entry = processUserInput(contactBook);
        contactBook.edit(entry);  // Assuming `edit(int)` method exists
        System.out.println("Contact edited successfully.");
    }

    // Deletes a contact from the contact book
    private static void deleteContact(ContactBook contactBook) {
        int entry = processUserInput(contactBook);
        contactBook.delete(entry);  // Assuming `delete(int)` method exists
        System.out.println("Contact deleted successfully.");
    }

    // Processes user input to choose a valid entry from the contact book
    public static int processUserInput(ContactBook contactBook) {
        int userInput = -1;
        boolean inputInvalid;

        do {
            System.out.print("Choose an entry (1 to " + contactBook.getSize() + "): ");
            try {
                userInput = s.nextInt();
                inputInvalid = userInput <= 0 || userInput > contactBook.getSize();

                if (inputInvalid) {
                    System.out.println("The contact book only has " + contactBook.getSize() + " entries. Please try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                s.next(); // Clear invalid input
                inputInvalid = true;
            }
        } while (inputInvalid);

        s.nextLine(); // Consume leftover newline
        return userInput;
    }
}
