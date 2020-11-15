import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskItemTest {
    @Test
    public void creatingTaskItemWithValidTitleDescriptionDate() {
        assertDoesNotThrow(() -> new TaskItem("Title", "Description", "01/10/2020"));
    }

    @Test
    public void creatingTaskItemWithInvalidTitleAndValidDescriptionDate() {
        assertThrows(InvalidTitleException.class, () -> new TaskItem("", "Description", "01/10/2020"));
    }

    @Test
    public void creatingTaskItemWithInvalidDescriptionAndValidTitleDate() {
        assertThrows(InvalidDescriptionException.class, () -> new TaskItem("Title", "", "01/10/2020"));
    }

    @Test
    public void creatingTaskItemWithInvalidDateFormatAndValidTitleDescription() {
        assertThrows(InvalidDateException.class, () -> new TaskItem("Title", "Description", "01-10-2020"));
    }

    @Test
    public void creatingTaskItemWithInvalidDateInputAndValidTitleDescription() {
        assertThrows(InvalidDateException.class, () -> new TaskItem("Title", "Description", "Hot Sauce"));
    }

    @Test
    public void settingTaskItemTitleSucceedsWithValidTitle() {
        TaskItem test = new TaskItem("Title", "Description", "01/10/2020");
        test.setTitle("NewTitle");

        assertEquals("NewTitle", test.getTitle());
    }

    @Test
    public void settingTaskItemTitleSucceedsWithInvalidTitle() {
        TaskItem test = new TaskItem("Title", "Description", "01/10/2020");

        assertThrows(InvalidTitleException.class, () -> test.setTitle(""));
    }

    @Test
    public void settingTaskItemTitleSucceedsWithValidDescription() {
        TaskItem test = new TaskItem("Title", "Description", "01/10/2020");
        test.setDescription("NewDescription");

        assertEquals("NewDescription", test.getDescription());
    }

    @Test
    public void settingTaskItemTitleSucceedsWithInvalidDescription() {
        TaskItem test = new TaskItem("Title", "Description", "01/10/2020");

        assertThrows(InvalidDescriptionException.class, () -> test.setDescription(""));
    }

    @Test
    public void settingTaskItemDueDateSucceedsWithValidDate() {
        TaskItem test = new TaskItem("Title", "Description", "01/10/2020");
        test.setDate("12/10/2020");

        assertEquals("12/10/2020", test.getDate());
    }

    @Test
    public void settingTaskItemDueDateFailsWithInvalidDate() {
        TaskItem test = new TaskItem("Title", "Description", "01/10/2020");

        assertThrows(InvalidDateException.class, () -> test.setDate("Hot Sauce"));
    }
}