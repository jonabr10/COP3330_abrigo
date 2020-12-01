import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TaskItem {
    boolean completionStatus;
    String title;
    String description;
    String date;

    public TaskItem (String title, String desc, String date) {
        this.completionStatus = false;

        if (isTitleValid(title)) {
            this.title = title;
        } else {
            throw new InvalidTitleException("Title is invalid, string length must be at least  1 character long");
        }

        if (isDescriptionValid(desc)) {
            this.description = desc;
        } else {
            throw new InvalidDescriptionException("Description is invalid, string length must be at least 1 character long");
        }

        if (isDateValid(date)) {
            this.date = date;
        } else {
            throw new InvalidDateException("Date is invalid, date format must be MM/DD/YYYY");
        }
    }

    public TaskItem (boolean completionStatus, String title, String desc, String date) {
        this.completionStatus = completionStatus;

        if (isTitleValid(title)) {
            this.title = title;
        } else {
            throw new InvalidTitleException("Title is invalid, string length must be at least  1 character long");
        }

        if (isDescriptionValid(desc)) {
            this.description = desc;
        } else {
            throw new InvalidDescriptionException("Description is invalid, string length must be at least 1 character long");
        }

        if (isDateValid(date)) {
            this.date = date;
        } else {
            throw new InvalidDateException("Date is invalid, date format must be MM/DD/YYYY");
        }
    }

    public void setCompletionStatusToDone() {
        this.completionStatus = true;
    }
    public void setCompletionStatusToNotDone() {
        this.completionStatus = false;
    }
    public void setItem(String newTitle, String newDesc, String newDate) {
        try  {
            setTitle(newTitle);
            setDescription(newDesc);
            setDate(newDate);
        } catch (InvalidTitleException e) {
            throw new InvalidTitleException("Title is invalid, string length must be at least  1 character long");
        } catch (InvalidDescriptionException e) {
            throw new InvalidDescriptionException("Description is invalid, string length must be at least 1 character long");
        } catch (InvalidDateException e) {
            throw new InvalidDateException("Date is invalid, date format must be MM/DD/YYYY");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void setTitle(String newTitle) {
        if (isTitleValid(newTitle)) {
            this.title = newTitle;
        } else {
            throw new InvalidTitleException("New title is invalid, string length must be at least  1 character long");
        }
    }
    public void setDescription(String newDesc) {
        if (isDescriptionValid(newDesc)) {
            this.description = newDesc;
        } else {
            throw new InvalidDescriptionException("New description is invalid, string length must be at least  1 character long");
        }
    }
    public void setDate(String newDate) throws InvalidDateException {
        if (isDateValid(newDate)) {
            this.date = newDate;
        } else {
            throw new InvalidDateException("Date is invalid, date format must be MM/DD/YYYY");
        }
    }

    public boolean getCompletionStatus() {
        return this.completionStatus;
    }
    public String getTitle() {
        return this.title;
    }
    public String getDescription() {
        return this.description;
    }
    public String getDate() {
        return this.date;
    }


    private boolean isTitleValid(String title) {
        return title.length() > 0;
    }
    private boolean isDescriptionValid(String description) {
        return description.length() > 0;
    }
    private boolean isDateValid(String date) {
        DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
        Date dateObj = null;
        df.setLenient(false);
        // Note-to-self: setLenient(boolean leniency) method in DateFormat class is used to
        //               specify whether the interpretation of the date and time of this
        //               DateFormat object is to be lenient or not.
        //               (source: geeksforgeeks.org/dateformat-setlenient-method-in-java-with-examples/)

        try {
            dateObj = df.parse(date);
            // Note-to-self: df object will try to parse the String date to the specified date
            //               formatter. If there is a format mismatch, then an exception is
            //               thrown and false will be returned.

            return true;

        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public String toString() {
        if (this.completionStatus) {
            return String.format("[STATUS: DONE] [%s] %s: %s", this.date, this.title, this.description);
        } else {
            return String.format("[STATUS: NOT DONE] [%s] %s: %s", this.date, this.title, this.description);
        }
    }
}

class InvalidTitleException extends IllegalArgumentException {
    public InvalidTitleException(String message) {
        super(message);
    }
}
class InvalidDescriptionException extends IllegalArgumentException {
    public InvalidDescriptionException(String message) {
        super(message);
    }
}
class InvalidDateException extends IllegalArgumentException {
    public InvalidDateException(String message) {
        super(message);
    }
}