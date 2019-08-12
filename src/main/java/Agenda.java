import java.util.ArrayList;
import java.util.Optional;

public class Agenda {
    ArrayList<Contact> contactsList;

    public Agenda() {
        this.contactsList = new ArrayList<Contact>();
    }

    public void addContact(Contact contact) {
        this.contactsList.add(contact);
    }

    public void deleteContact(Contact contact) {
        for (int i = 0; i < contactsList.size(); i++) {
            if (contactsList.get(i).getName().equalsIgnoreCase(contact.getName()) && contactsList.get(i).getPhoneNumber().equalsIgnoreCase(contact.getPhoneNumber())) {
                contactsList.remove(i);
                break;
            }
        }
    }

    public void updateContact(Contact contact) {
        for (int i = 0; i < contactsList.size(); i++) {
            if (contactsList.get(i).getName().equalsIgnoreCase(contact.getName())) {
                contactsList.get(i).setPhoneNumber(contact.getPhoneNumber());
                break;
            }
        }
    }

    public ArrayList<Contact> getAllContacts() {
        return contactsList;
    }

    public Optional<Contact> getByNameAndNumber(String name, String number) {
        for (Contact contact : contactsList) {
            if (contact.getName().equalsIgnoreCase(name) && contact.getPhoneNumber().equalsIgnoreCase(number)) {
                return Optional.of(contact);
            }
        }
        return Optional.empty();
    }

    @Override
    public String toString() {
        return contactsList + "";
    }
}
