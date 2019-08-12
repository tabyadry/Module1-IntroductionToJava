import java.util.Optional;
import java.util.Scanner;

public class Main {

    static Agenda agenda;

    public static void main(String[] args) {

        agenda = new Agenda();

        showMenu();
        Scanner myInput = new Scanner(System.in);
        System.out.print("Choose command: ");
        int choice = myInput.nextInt();

        while (true) {
            switch (choice) {
                case 1:
                    addContact();
                    break;
                case 2:
                    removeContact();
                    break;
                case 3:
                    editContact();
                    break;
                case 4:
                    showContacts();
                    break;
                case 5:
                    searchContact();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid command");
            }
            showMenu();
            System.out.print("Choose command: ");
            choice = myInput.nextInt();

        }
    }

    private static void editContact() {
        Scanner myInput = new Scanner(System.in);
        System.out.print("name: ");
        String name = myInput.nextLine();
        System.out.print("new phoneNumber: ");
        String phoneNumber = myInput.nextLine();

        Contact contact = new Contact(name, phoneNumber);
        agenda.updateContact(contact);
    }

    private static void addContact() {
        Scanner myInput = new Scanner(System.in);
        System.out.print("name: ");
        String name = myInput.nextLine();
        System.out.print("phoneNumber: ");
        String phoneNumber = myInput.nextLine();

        Contact contact = new Contact(name, phoneNumber);
        agenda.addContact(contact);

    }

    private static void removeContact() {
        Scanner myInput = new Scanner(System.in);
        System.out.print("name: ");
        String name = myInput.nextLine();
        System.out.print("phoneNumber: ");
        String phoneNumber = myInput.nextLine();

        Contact contact = new Contact(name, phoneNumber);
        agenda.deleteContact(contact);
    }

    private static void showContacts() {
        System.out.println(agenda);
    }

    private static void searchContact() {
        Scanner myInput = new Scanner(System.in);
        System.out.print("name: ");
        String name = myInput.nextLine();
        System.out.print("phoneNumber: ");
        String phoneNumber = myInput.nextLine();

        Optional<Contact> contact = agenda.getByNameAndNumber(name, phoneNumber);
        if (contact.isPresent()) {
            System.out.println(contact.get());
        } else {
            System.out.println("There is no contact with this name and phoneNumber");
        }
    }

    public static void showMenu() {
        System.out.println("Choose option:\n" +
                "1. Add contact\n" +
                "2. Remove contact\n" +
                "3. Edit contact\n" +
                "4. Show contacts\n" +
                "5. Search a contact by name and number\n" +
                "0. Exit\n");
    }
}
