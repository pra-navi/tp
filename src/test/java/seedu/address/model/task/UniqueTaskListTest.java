package seedu.address.model.task;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;
import static seedu.address.testutil.TypicalTasks.AGENDA;

import org.junit.jupiter.api.Test;

import seedu.address.testutil.TaskBuilder;

public class UniqueTaskListTest {

    private final UniqueTaskList uniqueTaskList = new UniqueTaskList();

    @Test
    public void contains_nullTask_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> uniqueTaskList.contains(null));
    }

    @Test
    public void contains_taskNotInList_returnsFalse() {
        assertFalse(uniqueTaskList.contains(AGENDA));
    }

    @Test
    public void contains_taskInList_returnsTrue() {
        uniqueTaskList.add(AGENDA);
        assertTrue(uniqueTaskList.contains(AGENDA));
    }

    @Test
    public void contains_taskWithSameFieldsInList_returnsTrue() {
        uniqueTaskList.add(AGENDA);
        String agendaTaskTitleString = AGENDA.getTitle().toString();
        String agendaTaskNoteString = AGENDA.getNote().toString();
        Status agendaTaskStatus = AGENDA.getStatus();
        Task agendaCopy = new TaskBuilder()
                .withTitle(agendaTaskTitleString)
                .withNote(agendaTaskNoteString)
                .withStatus(agendaTaskStatus)
                .build();
        assertTrue(uniqueTaskList.contains(agendaCopy));
    }

    // TODO: Add more tests for different methods of UniqueTaskList

    @Test
    public void asUnmodifiableObservableList_modifyList_throwsUnsupportedOperationException() {
        assertThrows(UnsupportedOperationException.class, ()
                -> uniqueTaskList.asUnmodifiableObservableList().remove(0));
    }

    @Test
    public void toStringMethod() {
        assertEquals(uniqueTaskList.asUnmodifiableObservableList().toString(), uniqueTaskList.toString());
    }
}
