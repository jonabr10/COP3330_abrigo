import java.io.*;
import java.util.*;

public class ContactApp {
    private static Scanner input = new Scanner(System.in);
    private ContactList contactLists;

    public void mainMenuChoice() {
        int choice = mainMenu();

        while (choice != 3) {

            if (choice == 1) {
                contactLists = new ContactList();
                System.out.println("new contact list has been created");
                contactsMenuChoice();
            }

            else if (choice == 2) {
                contactLists = new ContactList();
                input.nextLine();
                String fileName = getFileNameForLoading();
                try {
                    contactLists.load(fileName);
                    System.out.println("contact list has been loaded");
                    contactsMenuChoice();
                } catch (FileNotFoundException e) {
                    System.out.println("File Name Inputted: " + fileName);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            choice = mainMenu();
        }
    }
    private int mainMenu() {
        System.out.println("\nMain Menu");
        System.out.println("---------");
        System.out.println("1) create a new list");
        System.out.println("2) load an existing list");
        System.out.println("3) quit");

        return isMainMenuValid();
    }
    private int isMainMenuValid() {
        int ans = input.nextInt();

        if (ans == 1 || ans == 2 || ans == 3) {
            return ans;
        } else {
            System.out.println("Please choose a valid choice.");
            return mainMenu();
        }
    }

    private void contactsMenuChoice() {
        int choice = listOpMenu();

        while (choice != 6) {
            if (choice == 1) {
                viewList();
            } else if (choice == 2) {
                addItem();
            } else if (choice == 3) {
                editItem();
            } else if (choice == 4) {
                removeItem();
            } else if (choice == 5) {
                saveList();
            }

            choice = listOpMenu();
        }
    }
    private int listOpMenu() {
        System.out.println("\n\nList Operation Menu");
        System.out.println("---------");
        System.out.println("1) view the list");
        System.out.println("2) add an item");
        System.out.println("3) edit an item");
        System.out.println("4) remove an item");
        System.out.println("5) save the current list");
        System.out.println("6) quit to the main menu");

        return isListOpMenuValid();
    }
    private int isListOpMenuValid() {

        int ans = input.nextInt();

        if (ans == 1 || ans == 2 || ans == 3
                || ans == 4 || ans == 5|| ans == 6) {
            return ans;
        } else {
            System.out.println("Please choose a valid choice.");
            return listOpMenu();
        }
    }

    private void viewList() {
        System.out.println("\nCurrent Contacts");
        System.out.println("-------------");
        for (int i = 0; i < contactLists.getSize(); i++) {
            System.out.println(i + ") " + contactLists.getItem(i));
        }
    }
    private void addItem() {
        input.nextLine();
        String first = getFirstName();
        String last = getLastName();
        String phoneNum = getPhoneNumber();
        String email = getEmail();

        try {
            ContactItem data = new ContactItem(first, last, phoneNum, email);
            contactLists.addContact(data);

        } catch (InvalidContactItemException e ) {
            System.out.println("Warning: Please double check the information you are inputting.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void editItem() {
        viewList();
        try {
            int index = getIndex();
            input.nextLine();
            String first = getFirstName();
            String last = getLastName();
            String phoneNum = getPhoneNumber();
            String email = getEmail();

            contactLists.editContact(index, first, last, phoneNum, email);

        } catch (IndexOutOfBoundsException e) {
            System.out.println("Warning: index was invalid");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void removeItem() {
        viewList();
        System.out.println("\nDeleting a task...");

        try {
            int index = getIndex();
            contactLists.removeContact(index);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Warning: index was invalid");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void saveList() {
        input.nextLine();
        String fileName = getFileNameForSaving();
        try {
            contactLists.write(fileName);
            System.out.println("task list has been saved");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int getIndex() {
        System.out.print("\nPlease input which task you would like to select: ");
        return input.nextInt();
    }
    public String getFirstName() {
        System.out.print("Contact's First Name: ");
        return input.nextLine();
    }
    public String getLastName() {
        System.out.print("Contact's Last Name: ");
        return input.nextLine();
    }
    public String getPhoneNumber() {
        System.out.print("Phone number (xxx-xxx-xxxx): ");
        return input.nextLine();
    }
    public String getEmail() {
        System.out.print("Email address (x@y.z): ");
        return input.nextLine();
    }
    private String getFileNameForLoading() {
        System.out.print("Enter the filename to load: ");
        return input.nextLine();
    }
    private String getFileNameForSaving() {
        System.out.print("Enter the filename to save: ");
        return input.nextLine();
    }
}
