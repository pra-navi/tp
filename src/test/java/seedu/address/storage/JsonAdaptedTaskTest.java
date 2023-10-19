package seedu.address.storage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static seedu.address.storage.JsonAdaptedTask.MISSING_FIELD_MESSAGE_FORMAT;
import static seedu.address.testutil.Assert.assertThrows;

import org.junit.jupiter.api.Test;

import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.model.task.Note;
import seedu.address.model.task.Status;
import seedu.address.model.task.Task;
import seedu.address.model.task.Title;

public class JsonAdaptedTaskTest {

    public static final String EMPTY_TITLE = " ";
    public static final String EMPTY_NOTE = " ";
    public static final String INVALID_TITLE = " Invalid Title 123";
    public static final String INVALID_NOTE = " Invalid Note 123";


    public static final String VALID_TITLE = "Valid Title 1234 !@#$";
    public static final String VALID_NOTE = "Valid Note 1234 !@#$";
    public static final Task VALID_TASK = new Task(new Title(VALID_TITLE), new Note(VALID_NOTE));
    public static final Task VALID_DONE_TASK = new Task(new Title(VALID_TITLE), new Note(VALID_NOTE),
            Status.STATUS_DONE);

    @Test
    public void toModelType_validTaskDetails_returnsTask() throws Exception {
        JsonAdaptedTask task = new JsonAdaptedTask(VALID_TASK);
        assertEquals(VALID_TASK, task.toModelType());

        JsonAdaptedTask doneTask = new JsonAdaptedTask(VALID_DONE_TASK);
        assertEquals(VALID_DONE_TASK, doneTask.toModelType());
    }

    @Test
    public void toModelType_invalidTitle_throwsIllegalValueException() {
        JsonAdaptedTask emptyTaskTitle = new JsonAdaptedTask(EMPTY_TITLE, VALID_NOTE, false);
        JsonAdaptedTask invalidTaskTitle = new JsonAdaptedTask(INVALID_TITLE, VALID_NOTE, false);
        String expectedMessage = Title.MESSAGE_CONSTRAINTS;
        assertThrows(IllegalValueException.class, expectedMessage, emptyTaskTitle::toModelType);
        assertThrows(IllegalValueException.class, expectedMessage, invalidTaskTitle::toModelType);
    }

    @Test
    public void toModelType_nullTitle_throwsIllegalValueException() {
        JsonAdaptedTask task = new JsonAdaptedTask(null, VALID_NOTE, false);
        String expectedMessage = String.format(MISSING_FIELD_MESSAGE_FORMAT, Title.class.getSimpleName());
        assertThrows(IllegalValueException.class, expectedMessage, task::toModelType);
    }

    @Test
    public void toModelType_invalidNote_throwsIllegalValueException() {
        JsonAdaptedTask emptyTaskNote = new JsonAdaptedTask(VALID_TITLE, EMPTY_NOTE, false);
        JsonAdaptedTask invalidTaskNote = new JsonAdaptedTask(VALID_TITLE, INVALID_NOTE, false);
        String expectedMessage = Note.MESSAGE_CONSTRAINTS;
        assertThrows(IllegalValueException.class, expectedMessage, emptyTaskNote::toModelType);
        assertThrows(IllegalValueException.class, expectedMessage, invalidTaskNote::toModelType);
    }

    @Test
    public void toModelType_nullNote_throwsIllegalValueException() {
        JsonAdaptedTask task = new JsonAdaptedTask(VALID_TITLE, null, false);
        String expectedMessage = String.format(MISSING_FIELD_MESSAGE_FORMAT, Note.class.getSimpleName());
        assertThrows(IllegalValueException.class, expectedMessage, task::toModelType);
    }

    @Test
    public void toModelType_validNotDoneTask_returnsTask() throws Exception {
        JsonAdaptedTask task = new JsonAdaptedTask(VALID_TITLE, VALID_NOTE, false);
        assertEquals(VALID_TASK, task.toModelType());
    }

    @Test
    public void toModelType_validDoneTask_returnsDoneTask() throws Exception {
        JsonAdaptedTask task = new JsonAdaptedTask(VALID_TITLE, VALID_NOTE, true);
        assertEquals(VALID_DONE_TASK, task.toModelType());
    }

    @Test
    public void toModelType_reloadTask_returnsSameTask() throws Exception {
        Task task = new JsonAdaptedTask(VALID_TITLE, VALID_NOTE, false).toModelType();
        Task expectedTask = new JsonAdaptedTask(VALID_TITLE, VALID_NOTE, true).toModelType();

        Task updatedTask = task.markDone();
        Task reloadedTask = new JsonAdaptedTask(updatedTask).toModelType();
        assertEquals(expectedTask, reloadedTask);
    }
}
