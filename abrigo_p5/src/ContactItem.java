public class ContactItem {
    String firstName;
    String lastName;
    String phoneNum;
    String emailAddress;

    public ContactItem() {
        throw new InvalidContactItemException("Error: Too many arguments left blank.");
    }

    public ContactItem(String fName, String lName, String pNum, String email) {
        int counter = 0;
        String tempFirstName = "";
        String tempLastName = "";
        String tempPhoneNum = "";
        String tempEmail= "";

        if (isFirstNameValid(fName)) {
            tempFirstName = fName;
        } else {
            counter++;
        }

        if (isLastNameValid(lName)) {
            tempLastName = lName;
        } else {
            counter++;
        }

        if (isPhoneNumValid(pNum)) {
            tempPhoneNum = pNum;
        } else {
            counter++;
        }

        if (isEmailAddressValid(email)) {
            tempEmail= email;
        } else {
            counter++;
        }

        if (counter <= 3) {
            this.firstName = tempFirstName;
            this.lastName = tempLastName;
            this.phoneNum = tempPhoneNum;
            this.emailAddress = tempEmail;

        } else {
            throw new InvalidContactItemException("Error: Too many arguments left blank.");
        }
    }

    public void setItem() {
        throw new InvalidContactItemException("Error: Too many arguments left blank.");
    }
    public void setItem(String newFirstName, String newLastName, String newPhoneNum, String newEmail) {
        int counter = 0;
        String tempFirstName = "";
        String tempLastName = "";
        String tempPhoneNum = "";
        String tempEmail= "";

        if (isFirstNameValid(newFirstName)) {
            tempFirstName = newFirstName;
        } else {
            counter++;
        }

        if (isLastNameValid(newLastName)) {
            tempLastName = newLastName;
        } else {
            counter++;
        }

        if (isPhoneNumValid(newPhoneNum)) {
            tempPhoneNum = newPhoneNum;
        } else {
            counter++;
        }

        if (isEmailAddressValid(newEmail)) {
            tempEmail= newEmail;
        } else {
            counter++;
        }

        if (counter <= 3) {
            this.firstName = tempFirstName;
            this.lastName = tempLastName;
            this.phoneNum = tempPhoneNum;
            this.emailAddress = tempEmail;

        } else {
            throw new InvalidContactItemException("Error: Too many arguments left blank.");
        }
    }

    public String getFirstName() {
        return this.firstName;
    }
    public String getLastName() {
        return this.lastName;
    }
    public String getPhoneNum() {
        return this.phoneNum;
    }
    public String getEmailAddress() {
        return this.emailAddress;
    }

    private boolean isFirstNameValid(String name) {
        return name.length() > 0;
    }
    private boolean isLastNameValid(String name) {
        return name.length() > 0;
    }
    private boolean isPhoneNumValid(String num) {
        return num.length() > 0;
    }
    private boolean isEmailAddressValid(String email) {
        return email.length() > 0;
    }

    @Override
    public String toString() {
        return String.format("Name: %s %s\nPhone: %s\nEmail: %s", this.firstName, this.lastName, this.phoneNum, this.emailAddress);
    }
}

class InvalidContactItemException extends IllegalArgumentException {
    public InvalidContactItemException(String message) {
        super(message);
    }
}

