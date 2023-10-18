package seedu.address.logic.commands;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.logic.commands.CommandTestUtil.*;
import static seedu.address.testutil.TypicalIndexes.INDEX_FIRST_PERSON;
import static seedu.address.testutil.TypicalIndexes.INDEX_SECOND_PERSON;
import static seedu.address.testutil.TypicalTasks.getTypicalAddressBook;

import org.junit.jupiter.api.Test;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.Messages;
import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserPrefs;
import seedu.address.model.task.Task;

/**
 * Contains integration tests (interaction with the Model) and unit tests for
 * {@code UnmarkTaskCommand}.
 */
public class UnmarkTaskCommandTest {

    private Model model = new ModelManager(getTypicalAddressBook(), new UserPrefs());

    @Test
    public void execute_validIndexUnfilteredList_success() {
        Task taskToMark = model.getFilteredTaskList().get(INDEX_FIRST_PERSON.getZeroBased());
        Task taskToUnmark = model.markTask(taskToMark);
        UnmarkTaskCommand unmarkTaskCommand = new UnmarkTaskCommand(INDEX_FIRST_PERSON);

        ModelManager expectedModel = new ModelManager(model.getAddressBook(), new UserPrefs());
        Task markedTask = expectedModel.unmarkTask(taskToUnmark);
        Task unmarkedTask = expectedModel.unmarkTask(markedTask);

        String expectedMessage = String.format(UnmarkTaskCommand.MESSAGE_UNMARK_TASK_SUCCESS,
                Messages.format(unmarkedTask));

        assertCommandSuccess(unmarkTaskCommand, model, expectedMessage, expectedModel);
    }

    @Test
    public void execute_invalidIndexUnfilteredList_throwsCommandException() {
        Index outOfBoundIndex = Index.fromOneBased(model.getFilteredTaskList().size() + 1);
        UnmarkTaskCommand unmarkTaskCommand = new UnmarkTaskCommand(outOfBoundIndex);

        assertCommandFailure(unmarkTaskCommand, model, Messages.MESSAGE_INVALID_TASK_DISPLAYED_INDEX);
    }

    @Test
    public void execute_validIndexFilteredList_success() {
        showTaskAtIndex(model, INDEX_FIRST_PERSON);

        Task taskToMark = model.getFilteredTaskList().get(INDEX_FIRST_PERSON.getZeroBased());
        Task taskToUnmark = model.markTask(taskToMark);
        UnmarkTaskCommand unmarkTaskCommand = new UnmarkTaskCommand(INDEX_FIRST_PERSON);

        Model expectedModel = new ModelManager(model.getAddressBook(), new UserPrefs());
        showTaskAtIndex(expectedModel, INDEX_FIRST_PERSON);
        Task markedTask = expectedModel.unmarkTask(taskToUnmark);
        Task unmarkedTask = expectedModel.unmarkTask(markedTask);

        String expectedMessage = String.format(UnmarkTaskCommand.MESSAGE_UNMARK_TASK_SUCCESS,
                Messages.format(unmarkedTask));

        assertCommandSuccess(unmarkTaskCommand, model, expectedMessage, expectedModel);
    }

    @Test
    public void execute_invalidIndexFilteredList_throwsCommandException() {
        showTaskAtIndex(model, INDEX_FIRST_PERSON);

        Index outOfBoundIndex = INDEX_SECOND_PERSON;
        // ensures that outOfBoundIndex is still in bounds of address book list
        assertTrue(outOfBoundIndex.getZeroBased() < model.getAddressBook().getTaskList().size());

        UnmarkTaskCommand unmarkTaskCommand = new UnmarkTaskCommand(outOfBoundIndex);

        assertCommandFailure(unmarkTaskCommand, model, Messages.MESSAGE_INVALID_TASK_DISPLAYED_INDEX);
    }

    @Test
    public void equals() {
        UnmarkTaskCommand unmarkTaskFirstCommand = new UnmarkTaskCommand(INDEX_FIRST_PERSON);
        UnmarkTaskCommand unmarkTaskSecondCommand = new UnmarkTaskCommand(INDEX_SECOND_PERSON);

        // same object -> returns true
        assertTrue(unmarkTaskFirstCommand.equals(unmarkTaskFirstCommand));

        // same values -> returns true
        UnmarkTaskCommand unmarkTaskFirstCommandCopy = new UnmarkTaskCommand(INDEX_FIRST_PERSON);
        assertTrue(unmarkTaskFirstCommand.equals(unmarkTaskFirstCommandCopy));

        // different types -> returns false
        assertFalse(unmarkTaskFirstCommand.equals(1));

        // null -> returns false
        assertFalse(unmarkTaskFirstCommand.equals(null));

        // different person -> returns false
        assertFalse(unmarkTaskFirstCommand.equals(unmarkTaskSecondCommand));
    }
    @Test
    public void toStringMethod() {
        Index targetIndex = Index.fromOneBased(1);
        UnmarkTaskCommand unmarkTaskCommand = new UnmarkTaskCommand(targetIndex);
        String expected = UnmarkTaskCommand.class.getCanonicalName() + "{targetIndex=" + targetIndex + "}";
        assertEquals(expected, unmarkTaskCommand.toString());
    }
}
