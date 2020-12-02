import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContactListTest {
    @Test
    public void newListIsEmpty() {
        ContactList newList = new ContactList();
        assertEquals(0, newList.getSize());
    }

    @Test
    public void addingItemsIncreasesSize() {
        ContactItem newItem1 = new ContactItem("first", "last", "123-456-7890", "newItem1@email.com");
        ContactItem newItem2 = new ContactItem("first", "last", "098-765-4321", "newItem2@email.com");
        ContactList newList = new ContactList();

        newList.addContact(newItem1);
        assertEquals(1, newList.getSize());

        newList.addContact(newItem2);
        assertEquals(2, newList.getSize());

    }

    @Test
    public void removingItemsDecreasesSize() {
        ContactItem newItem1 = new ContactItem("first", "last", "123-456-7890", "newItem1@email.com");
        ContactItem newItem2 = new ContactItem("first", "last", "098-765-4321", "newItem2@email.com");
        ContactList newList = new ContactList();

        newList.addContact(newItem1);
        newList.addContact(newItem2);
        assertEquals(2, newList.getSize());

        newList.removeContact(1);
        assertEquals(1, newList.getSize());
    }

    @Test
    public void removingItemsFailsWithInvalidIndex() {
        ContactItem newItem1 = new ContactItem("first", "last", "123-456-7890", "newItem1@email.com");
        ContactItem newItem2 = new ContactItem("first", "last", "098-765-4321", "newItem2@email.com");
        ContactList newList = new ContactList();

        newList.addContact(newItem1);
        newList.addContact(newItem2);
        assertEquals(2, newList.getSize());

        assertThrows(IndexOutOfBoundsException.class, () -> newList.removeContact(4));
    }


    @Test
    public void editingItemsFailsWithAllBlankValues() {
        ContactItem newItem = new ContactItem("first", "last", "098-765-4321", "newItem2@email.com");
        ContactList newList = new ContactList();

        newList.addContact(newItem);
        assertThrows(InvalidContactItemException.class, () -> newList.editContact(0, "", "", "", ""));

    }

    @Test
    public void editingItemsFailsWithInvalidIndex() {
        ContactItem newItem = new ContactItem("first", "last", "098-765-4321", "newItem2@email.com");
        ContactList newList = new ContactList();

        newList.addContact(newItem);
        assertThrows(IndexOutOfBoundsException.class, () -> newList.editContact(3, "f", "l", "123-456-7890", "mail@email.com"));

    }

    @Test
    public void editingSucceedsWithBlankFirstName() {
        ContactItem newItem = new ContactItem("first", "last", "098-765-4321", "newItem@email.com");
        ContactList newList = new ContactList();
        newList.addContact(newItem);

        newList.editContact(0, "", "last", "098-765-4321", "newItem@email.com");

        ContactItem test = newList.getItem(0);
        assertEquals("", test.getFirstName());
        assertEquals("last", test.getLastName());
        assertEquals("098-765-4321", test.getPhoneNum());
        assertEquals("newItem@email.com", test.getEmailAddress());
    }

    @Test
    public void editingSucceedsWithBlankLastName() {
        ContactItem newItem = new ContactItem("first", "last", "098-765-4321", "newItem@email.com");
        ContactList newList = new ContactList();
        newList.addContact(newItem);

        newList.editContact(0, "first", "", "098-765-4321", "newItem@email.com");

        ContactItem test = newList.getItem(0);
        assertEquals("first", test.getFirstName());
        assertEquals("", test.getLastName());
        assertEquals("098-765-4321", test.getPhoneNum());
        assertEquals("newItem@email.com", test.getEmailAddress());
    }

    @Test
    public void editingSucceedsWithBlankPhone() {
        ContactItem newItem = new ContactItem("first", "last", "098-765-4321", "newItem@email.com");
        ContactList newList = new ContactList();
        newList.addContact(newItem);

        newList.editContact(0, "first", "last", "", "newItem@email.com");

        ContactItem test = newList.getItem(0);
        assertEquals("first", test.getFirstName());
        assertEquals("last", test.getLastName());
        assertEquals("", test.getPhoneNum());
        assertEquals("newItem@email.com", test.getEmailAddress());
    }

    @Test
    public void editingSucceedsWithNonBlankValues() {
        ContactItem newItem = new ContactItem("first", "last", "098-765-4321", "newItem@email.com");
        ContactList newList = new ContactList();
        newList.addContact(newItem);

        newList.editContact(0, "newFirst", "newLast", "100-000-0000", "newItem2@email.com");

        ContactItem test = newList.getItem(0);
        assertEquals("newFirst", test.getFirstName());
        assertEquals("newLast", test.getLastName());
        assertEquals("100-000-0000", test.getPhoneNum());
        assertEquals("newItem2@email.com", test.getEmailAddress());
    }

    @Test
    public void savedContactListCanBeLoaded() {
        ContactList newList = new ContactList();
        ContactItem newItem1 = new ContactItem("jon", "abr", "123-456-7890", "jonabr@email.com");
        ContactItem newItem2 = new ContactItem("jane", "doe", "098-765-4321", "janedoe@email.com");

        newList.addContact(newItem1);
        newList.addContact(newItem2);
        newList.write("writingContactListToTextFile.txt");

        assertDoesNotThrow(() -> newList.load("writingContactListToTextFile.txt"));
    }

}