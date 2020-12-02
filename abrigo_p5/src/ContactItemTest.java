import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContactItemTest {
    @Test
    public void creationFailsWithAllBlankValues() {
        assertThrows(InvalidContactItemException.class, () -> new ContactItem());
    }

    @Test
    public void creationFailsWithAllBlankValuesV2() {
        assertThrows(InvalidContactItemException.class, () -> new ContactItem("", "", "", ""));
    }

    @Test
    public void creationSucceedsWithBlankEmail() {
        ContactItem test = new ContactItem("FirstName", "LastName", "123-456-7890", "");

        assertEquals("FirstName", test.getFirstName());
        assertEquals("LastName", test.getLastName());
        assertEquals("123-456-7890", test.getPhoneNum());
        assertEquals("", test.getEmailAddress());
    }

    @Test
    public void creationSucceedsWithBlankFirstName() {
        ContactItem test = new ContactItem("", "LastName", "123-456-7890", "Email");

        assertEquals("", test.getFirstName());
        assertEquals("LastName", test.getLastName());
        assertEquals("123-456-7890", test.getPhoneNum());
        assertEquals("Email", test.getEmailAddress());
    }

    @Test
    public void creationSucceedsWithBlankLastName() {
        ContactItem test = new ContactItem("FirstName", "", "123-456-7890", "Email");

        assertEquals("FirstName", test.getFirstName());
        assertEquals("", test.getLastName());
        assertEquals("123-456-7890", test.getPhoneNum());
        assertEquals("Email", test.getEmailAddress());
    }

    @Test
    public void creationSucceedsWithBlankPhone() {
        ContactItem test = new ContactItem("FirstName", "LastName", "", "Email");

        assertEquals("FirstName", test.getFirstName());
        assertEquals("LastName", test.getLastName());
        assertEquals("", test.getPhoneNum());
        assertEquals("Email", test.getEmailAddress());
    }

    @Test
    public void creationSucceedsWithNonBlankValues() {
        ContactItem test = new ContactItem("FirstName", "LastName", "123-456-7890", "Email");

        assertEquals("FirstName", test.getFirstName());
        assertEquals("LastName", test.getLastName());
        assertEquals("123-456-7890", test.getPhoneNum());
        assertEquals("Email", test.getEmailAddress());
    }

    @Test
    public void editingFailsWithAllBlankValues() {
        ContactItem test = new ContactItem("FirstName", "LastName", "123-456-7890", "Email");

        assertThrows(InvalidContactItemException.class, () -> test.setItem());
    }

    @Test
    public void editingFailsWithAllBlankValuesV2() {
        ContactItem test = new ContactItem("FirstName", "LastName", "123-456-7890", "Email");

        assertThrows(InvalidContactItemException.class, () -> test.setItem("", "", "", ""));
    }

    @Test
    public void editingSucceedsWithBlankEmail() {
        ContactItem test = new ContactItem("FirstName", "LastName", "123-456-7890", "Email");

        //test.setItem("FirstName", "LastName", "123-456-7890", "Email");
        test.setItem("FirstName", "LastName", "123-456-7890", "");

        assertEquals("FirstName", test.getFirstName());
        assertEquals("LastName", test.getLastName());
        assertEquals("123-456-7890", test.getPhoneNum());
        assertEquals("", test.getEmailAddress());
    }

    @Test
    public void editingSucceedsWithBlankFirstName() {
        ContactItem test = new ContactItem("FirstName", "LastName", "123-456-7890", "Email");

        //test.setItem("FirstName", "LastName", "123-456-7890", "Email");
        test.setItem("", "LastName", "123-456-7890", "Email");

        assertEquals("", test.getFirstName());
        assertEquals("LastName", test.getLastName());
        assertEquals("123-456-7890", test.getPhoneNum());
        assertEquals("Email", test.getEmailAddress());
    }

    @Test
    public void editingSucceedsWithBlankLastName() {
        ContactItem test = new ContactItem("FirstName", "LastName", "123-456-7890", "Email");

        //test.setItem("FirstName", "LastName", "123-456-7890", "Email");
        test.setItem("FirstName", "", "123-456-7890", "Email");

        assertEquals("FirstName", test.getFirstName());
        assertEquals("", test.getLastName());
        assertEquals("123-456-7890", test.getPhoneNum());
        assertEquals("Email", test.getEmailAddress());
    }

    @Test
    public void editingSucceedsWithBlankPhone() {
        ContactItem test = new ContactItem("FirstName", "LastName", "123-456-7890", "Email");

        //test.setItem("FirstName", "LastName", "123-456-7890", "Email");
        test.setItem("FirstName", "LastName", "", "Email");

        assertEquals("FirstName", test.getFirstName());
        assertEquals("LastName", test.getLastName());
        assertEquals("", test.getPhoneNum());
        assertEquals("Email", test.getEmailAddress());
    }

    @Test
    public void editingSucceedsWithNonBlankValues() {
        ContactItem test = new ContactItem("FirstName", "LastName", "123-456-7890", "Email");

        //test.setItem("FirstName", "LastName", "123-456-7890", "Email");
        test.setItem("newFirstName", "newLastName", "098-765-4321", "newEmail");

        assertEquals("newFirstName", test.getFirstName());
        assertEquals("newLastName", test.getLastName());
        assertEquals("098-765-4321", test.getPhoneNum());
        assertEquals("newEmail", test.getEmailAddress());
    }


}