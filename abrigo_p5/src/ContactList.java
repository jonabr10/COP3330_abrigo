import java.util.*;
import java.io.*;

public class ContactList {
    ArrayList<ContactItem> contacts;

    public ContactList() {
        contacts = new ArrayList<>();
    }

    public void addContact(ContactItem data) {
        contacts.add(data);
    }

    public void editContact(int index, String newFirstName, String newLastName, String newPhoneNum, String newEmail) {
        try {
            ContactItem temp = contacts.get(index);
            temp.setItem(newFirstName, newLastName, newPhoneNum, newEmail);
            contacts.set(index, temp);

        } catch (IndexOutOfBoundsException e) {
            System.out.println("Error: task list at index " + index + " does not exist.");
            throw new IndexOutOfBoundsException();
        } catch (InvalidContactItemException e) {
            throw new InvalidContactItemException("Error: Too many arguments left blank.");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void removeContact(int index) {
        try {
            contacts.remove(index);

        } catch (IndexOutOfBoundsException e) {
            System.out.println("Error: contact list at index " + index + " does not exist.");
            throw new IndexOutOfBoundsException();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ContactItem getItem(int index) {
        if (isItemValid(index)) {
            return contacts.get(index);
        } else {
            System.out.println("Error: task list at index " + index + " does not exist.");
            throw new IndexOutOfBoundsException();
        }
    }

    public int getSize() {
        return contacts.size();
    }
    private boolean isItemValid(int index) {
        return index <= contacts.size();
    }

    public void write(String fileName) {
        ContactItem temp;

        try (Formatter output = new Formatter(fileName)) {
            for (int i = 0; i < contacts.size(); i++) {
                temp = contacts.get(i);
                output.format("%s%n%s%n%s%n%s%n", temp.getFirstName(), temp.getLastName(), temp.getPhoneNum(), temp.getEmailAddress());
            }

        } catch (FileNotFoundException e) {
            System.out.println("Error: unable to find the file.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void load(String fileName) throws FileNotFoundException {
        try {
            File fileText = new File(fileName);
            Scanner input = new Scanner(fileText);
            contacts.clear();

            while (input.hasNext()) {
                String first = input.nextLine();
                String last = input.nextLine();
                String phoneNum = input.nextLine();
                String email = input.nextLine();

                ContactItem temp = new ContactItem(first, last, phoneNum, email);
                contacts.add(temp);
            }

        } catch (FileNotFoundException e) {
            System.out.println("Error: unable to find the file.");
            throw new FileNotFoundException();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

