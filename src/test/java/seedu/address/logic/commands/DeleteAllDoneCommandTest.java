package seedu.address.logic.commands;

import static org.junit.jupiter.api.Assertions.*;
import static seedu.address.logic.commands.CommandTestUtil.*;
import static seedu.address.model.Model.*;
import static seedu.address.testutil.TypicalTasks.*;

import org.junit.jupiter.api.Test;

import seedu.address.logic.commands.exceptions.*;
import seedu.address.model.AddressBook;
import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserPrefs;
import seedu.address.model.task.*;

import java.util.*;

public class DeleteAllDoneCommandTest {
    private final Model model = new ModelManager(getTypicalAddressBook(), new UserPrefs());
    private final Model expectedModel = new ModelManager(getTypicalAddressBook(), new UserPrefs());

    @Test
    public void execute_allDoneTask_emptyAddressBook() {
        for (Task task : model.getFilteredTaskList()) {
            model.markTask(task);
        }
        expectedModel.setAddressBook(new AddressBook());
        assertCommandSuccess(new DeleteAllDoneCommand(), model,
                DeleteAllDoneCommand.MESSAGE_DELETE_ALL_DONE_SUCCESS, expectedModel);
    }

    @Test
    public void execute_someDoneTask_nonEmptyAddressBook() {
        for (Task task : model.getFilteredTaskList()) {
            expectedModel.unmarkTask(task);
            model.unmarkTask(task);
        }
        List<Task> tasksToMarkAndDelete = Arrays.asList(AGENDA, CATERING);
        for (Task task : tasksToMarkAndDelete) {
            Task taskToDelete = expectedModel.markTask(task);
            expectedModel.deleteTask(taskToDelete);
            model.markTask(task);
        }
        assertCommandSuccess(new DeleteAllDoneCommand(), model,
                DeleteAllDoneCommand.MESSAGE_DELETE_ALL_DONE_SUCCESS, expectedModel);
    }

    @Test
    public void execute_noDoneTask_throwsCommandException() {
        for (Task task : model.getFilteredTaskList()) {
            expectedModel.unmarkTask(task);
            model.unmarkTask(task);
        }
        assertCommandFailure(new DeleteAllDoneCommand(), model, DeleteAllDoneCommand.MESSAGE_NO_DONE_TASKS);
        assertEquals(expectedModel.getFilteredTaskList(), model.getFilteredTaskList());
    }

}
