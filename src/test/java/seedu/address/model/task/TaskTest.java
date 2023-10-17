package seedu.address.model.task;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class TaskTest {

    private static final Task TEST_TASK_1_1 = new Task(new Title("Test Task 1"), new Note("Test Note 1"));
    private static final Task TEST_TASK_1_1_COPY = new Task(new Title("Test Task 1"), new Note("Test Note 1"));
    private static final Task TEST_TASK_1_2 = new Task(new Title("Test Task 1"), new Note("Test Note 2"));
    private static final Task TEST_TASK_2_1 = new Task(new Title("Test Task 2"), new Note("Test Note 1"));
    private static final Task TEST_TASK_2_2 = new Task(new Title("Test Task 2"), new Note("Test Note 2"));


    @Test
    public void isSameTask() {
        // same values -> returns true
        assertTrue(TEST_TASK_1_1.isSameTask(TEST_TASK_1_1_COPY));

        // same object -> returns true
        assertTrue(TEST_TASK_1_1.isSameTask(TEST_TASK_1_1));

        // null -> returns false
        assertFalse(TEST_TASK_1_1.isSameTask(null));

        // different title, same note -> returns false
        assertFalse(TEST_TASK_1_1.isSameTask(TEST_TASK_2_1));

        // same title, different note -> returns false
        assertFalse(TEST_TASK_1_1.isSameTask(TEST_TASK_1_2));

        // different title and note -> returns false
        assertFalse(TEST_TASK_1_1.isSameTask(TEST_TASK_2_2));
    }

    @Test
    public void equals() {
        // same values -> returns true
        assertEquals(TEST_TASK_1_1, TEST_TASK_1_1_COPY);

        // same object -> returns true
        assertEquals(TEST_TASK_1_1, TEST_TASK_1_1);

        // null -> returns false
        // assertNotEquals calls the 1st argument's equals method
        assertNotEquals(TEST_TASK_1_1, null);

        // different type -> returns false
        assertNotEquals(TEST_TASK_1_1, 5.0f);

        // different title, same note -> returns false
        assertNotEquals(TEST_TASK_1_1, TEST_TASK_2_1);

        // same title, different note -> returns false
        assertNotEquals(TEST_TASK_1_1, TEST_TASK_1_2);

        // different title and note -> returns false
        assertNotEquals(TEST_TASK_1_1, TEST_TASK_2_2);
    }

    @Test
    public void toStringMethod() {
        String expected = Task.class.getCanonicalName() + "{title=" + TEST_TASK_1_1.getTitle()
                + ", note=" + TEST_TASK_1_1.getNote()  + ", status=" + TEST_TASK_1_1.getStatus()
                + "}";
        assertEquals(expected, TEST_TASK_1_1.toString());
    }

    @Test
    public void hashCodeTest() {
        // same values -> returns true
        assertEquals(TEST_TASK_1_1.hashCode(), TEST_TASK_1_1_COPY.hashCode());

        // same object -> returns true
        assertEquals(TEST_TASK_1_1.hashCode(), TEST_TASK_1_1.hashCode());

        // different title, same note -> returns false
        assertNotEquals(TEST_TASK_1_1.hashCode(), TEST_TASK_2_1.hashCode());

        // same title, different note -> returns false
        assertNotEquals(TEST_TASK_1_1.hashCode(), TEST_TASK_1_2.hashCode());

        // different title and note -> returns false
        assertNotEquals(TEST_TASK_1_1.hashCode(), TEST_TASK_2_2.hashCode());

        // different types -> returns false
        assertNotEquals(TEST_TASK_1_1.hashCode(), "Test Task 1 Test Note 1".hashCode());

    }
}
