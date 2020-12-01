import org.junit.jupiter.api.Test;
import java.io.FileNotFoundException;
import static org.junit.jupiter.api.Assertions.*;

class TaskListTest {
    @Test
    public void newTaskListIsEmpty() {
        TaskList newList = new TaskList();
        assertEquals(0, newList.getSize());
    }

    @Test
    public void addingTaskItemsIncreasesSize() {
        TaskItem newItem1 = new TaskItem("Title", "Description", "01/10/2020");
        TaskItem newItem2 = new TaskItem("Title", "Description", "01/10/2020");
        TaskList newList = new TaskList();

        newList.addTask(newItem1);
        assertEquals(1, newList.getSize());

        newList.addTask(newItem2);
        assertEquals(2, newList.getSize());
    }

    @Test
    public void removingTaskItemsDecreasesSize() {
        TaskItem newItem1 = new TaskItem("Title", "Description", "01/10/2020");
        TaskItem newItem2 = new TaskItem("Title", "Description", "01/10/2020");
        TaskList newList = new TaskList();

        newList.addTask(newItem1);
        newList.addTask(newItem2);
        assertEquals(2, newList.getSize());

        newList.removeTask(1);
        assertEquals(1, newList.getSize());
    }

    @Test
    public void removingTaskItemsFailsWithInvalidIndex() {
        TaskItem newItem1 = new TaskItem("Title", "Description", "01/10/2020");
        TaskList newList = new TaskList();

        newList.addTask(newItem1);
        assertThrows(IndexOutOfBoundsException.class, () -> newList.removeTask(3));
    }

    @Test
    public void editingTaskItemTitleChangesValue() {
        TaskItem newItem = new TaskItem("Title", "Description", "01/10/2020");
        TaskList newList = new TaskList();
        newList.addTask(newItem);

        TaskItem temp = newList.getItem(0);
        assertEquals("Title", temp.getTitle());

        newList.editTaskTitle(0, "New Title");

        assertEquals("New Title", newList.getItemTitle(0));
    }

    @Test
    public void editingTaskItemTitleFailsWithInvalidIndex() {
        TaskItem newItem = new TaskItem("Title", "Description", "01/10/2020");
        TaskList newList = new TaskList();
        newList.addTask(newItem);

        TaskItem temp = newList.getItem(0);
        assertEquals("Title", temp.getTitle());

        assertThrows(IndexOutOfBoundsException.class, () -> newList.editTaskTitle(2, "New Title"));
    }

    @Test
    public void editingTaskItemDescriptionChangesValue() {
        TaskItem newItem = new TaskItem("Title", "Description", "01/10/2020");
        TaskList newList = new TaskList();
        newList.addTask(newItem);

        TaskItem temp = newList.getItem(0);
        assertEquals("Description", temp.getDescription());

        newList.editTaskDescription(0, "New Description");

        assertEquals("New Description", newList.getItemDescription(0));
    }

    @Test
    public void editingTaskItemDescriptionFailsWithInvalidIndex() {
        TaskItem newItem = new TaskItem("Title", "Description", "01/10/2020");
        TaskList newList = new TaskList();
        newList.addTask(newItem);

        TaskItem temp = newList.getItem(0);
        assertEquals("Description", temp.getDescription());

        assertThrows(IndexOutOfBoundsException.class, () -> newList.editTaskDescription(2, "New Description"));
    }

    @Test
    public void editingTaskItemDueDateChangesValue() {
        TaskItem newItem = new TaskItem("Title", "Description", "01/10/2020");
        TaskList newList = new TaskList();
        newList.addTask(newItem);

        TaskItem temp = newList.getItem(0);
        assertEquals("01/10/2020", temp.getDate());

        newList.editTaskDate(0, "12/12/2020");

        assertEquals("12/12/2020", newList.getItemDate(0));
    }

    @Test
    public void editingTaskItemDueDateFailsWithInvalidIndex() {
        TaskItem newItem = new TaskItem("Title", "Description", "01/10/2020");
        TaskList newList = new TaskList();
        newList.addTask(newItem);

        TaskItem temp = newList.getItem(0);
        assertEquals("01/10/2020", temp.getDate());

        assertThrows(IndexOutOfBoundsException.class, () -> newList.editTaskDate(2, "12/12/2020"));
    }

    @Test
    public void completingTaskItemChangesStatus() {
        TaskItem newItem = new TaskItem("Title", "Description", "01/10/2020");
        TaskList newList = new TaskList();
        newList.addTask(newItem);

        newList.editTaskCompletionStatusToDone(0);

        assertTrue(newList.getItemCompletionStatus(0));
    }

    @Test
    public void completingTaskItemFailsWithInvalidIndex() {
        TaskItem newItem = new TaskItem("Title", "Description", "01/10/2020");
        TaskList newList = new TaskList();
        newList.addTask(newItem);

        assertThrows(IndexOutOfBoundsException.class, () -> newList.editTaskCompletionStatusToDone(2));
    }

    @Test
    public void uncompletingTaskItemChangesStatus() {
        TaskItem newItem = new TaskItem("Title", "Description", "01/10/2020");
        TaskList newList = new TaskList();
        newList.addTask(newItem);

        newList.editTaskCompletionStatusToNotDone(0);

        assertFalse(newList.getItemCompletionStatus(0));
    }

    @Test
    public void uncompletingTaskItemFailsWithInvalidIndex() {
        TaskItem newItem = new TaskItem("Title", "Description", "01/10/2020");
        TaskList newList = new TaskList();
        newList.addTask(newItem);

        assertThrows(IndexOutOfBoundsException.class, () -> newList.editTaskCompletionStatusToNotDone(2));
    }

    @Test
    public void gettingTaskItemTitleSucceedsWithValidIndex() {
        TaskItem newItem = new TaskItem("Title", "Description", "01/10/2020");
        TaskList newList = new TaskList();
        newList.addTask(newItem);

        assertEquals("Title",newList.getItemTitle(0));
    }

    @Test
    public void gettingTaskItemTitleFailsWithInvalidIndex() {
        TaskItem newItem = new TaskItem("Title", "Description", "01/10/2020");
        TaskList newList = new TaskList();
        newList.addTask(newItem);

        assertThrows(IndexOutOfBoundsException.class, () -> newList.getItemTitle(2));
    }

    @Test
    public void gettingTaskItemDescriptionSucceedsWithValidIndex() {
        TaskItem newItem = new TaskItem("Title", "Description", "01/10/2020");
        TaskList newList = new TaskList();
        newList.addTask(newItem);

        assertEquals("Description", newList.getItemDescription(0));
    }

    @Test
    public void gettingTaskItemDescriptionFailsWithInvalidIndex() {
        TaskItem newItem = new TaskItem("Title", "Description", "01/10/2020");
        TaskList newList = new TaskList();
        newList.addTask(newItem);

        assertThrows(IndexOutOfBoundsException.class, () -> newList.getItemDescription(2));
    }

    @Test
    public void gettingTaskItemDueDateSucceedsWithValidIndex() {
        TaskItem newItem = new TaskItem("Title", "Description", "01/10/2020");
        TaskList newList = new TaskList();
        newList.addTask(newItem);

        assertEquals("01/10/2020", newList.getItemDate(0));
    }

    @Test
    public void gettingTaskItemDueDateFailsWithInvalidIndex() {
        TaskItem newItem = new TaskItem("Title", "Description", "01/10/2020");
        TaskList newList = new TaskList();
        newList.addTask(newItem);

        assertThrows(IndexOutOfBoundsException.class, () -> newList.getItemDate(2));
    }

    @Test
    public void writingTaskListToTextFile() {
        TaskList newList = new TaskList();
        TaskItem newItem1 = new TaskItem("Title1", "Description2", "01/10/2020");
        TaskItem newItem2 = new TaskItem("Title2", "Description2", "02/20/2020");
        TaskItem newItem3 = new TaskItem(true, "Title3", "Description3", "03/30/2020");

        newList.addTask(newItem1);
        newList.addTask(newItem2);
        newList.addTask(newItem3);

        assertDoesNotThrow(() -> newList.write("writingTaskListToTextFile.txt"));
    }

    @Test
    public void savedTaskListCanBeLoaded() {
        TaskList newList = new TaskList();
        TaskItem newItem1 = new TaskItem("Title1", "Description2", "01/10/2020");
        TaskItem newItem2 = new TaskItem("Title2", "Description2", "02/20/2020");
        TaskItem newItem3 = new TaskItem(true, "Title3", "Description3", "03/30/2020");

        newList.addTask(newItem1);
        newList.addTask(newItem2);
        newList.addTask(newItem3);
        newList.write("writingTaskListToTextFile.txt");

        assertDoesNotThrow(() -> newList.load("writingTaskListToTextFile.txt"));
    }

    @Test
    public void savedTaskListCannotBeLoadedDueToIncorrectFileName() {
        TaskList newList = new TaskList();
        TaskItem newItem1 = new TaskItem("Title1", "Description2", "01/10/2020");
        TaskItem newItem2 = new TaskItem("Title2", "Description2", "02/20/2020");
        TaskItem newItem3 = new TaskItem(true, "Title3", "Description3", "03/30/2020");

        newList.addTask(newItem1);
        newList.addTask(newItem2);
        newList.addTask(newItem3);
        newList.write("writingTaskListToTextFile.txt");

        assertThrows(FileNotFoundException.class, () -> newList.load("someRandomFileName.txt"));
        newList.write("writingTaskListToTextFileFromLoadMethod.txt");
    }
}