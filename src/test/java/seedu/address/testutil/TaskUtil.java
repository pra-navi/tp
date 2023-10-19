package seedu.address.testutil;

import static seedu.address.logic.parser.CliSyntax.PREFIX_TASK_NOTE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_TASK_TITLE;

import seedu.address.logic.commands.AddTaskCommand;
import seedu.address.logic.commands.EditTaskCommand.EditTaskDescriptor;
import seedu.address.model.task.Task;

/**
 * A utility class for Task.
 */
public class TaskUtil {

    /**
     * Returns an addTask command string for adding the {@code task}.
     */
    public static String getAddTaskCommand(Task task) {
        return AddTaskCommand.COMMAND_WORD + " " + getTaskDetails(task);
    }

    /**
     * Returns the part of command string for the given {@code task}'s details.
     */
    public static String getTaskDetails(Task task) {
        StringBuilder sb = new StringBuilder();
        sb.append(PREFIX_TASK_TITLE + task.getTitle().value + " ");
        sb.append(PREFIX_TASK_NOTE + task.getNote().value + " ");

        return sb.toString();
    }

    /**
     * Returns the part of command string for the given {@code EditPersonDescriptor}'s details.
     */
    public static String getEditTaskDescriptorDetails(EditTaskDescriptor descriptor) {
        StringBuilder sb = new StringBuilder();
        descriptor.getTitle().ifPresent(title -> sb.append(PREFIX_TASK_TITLE).append(title.value).append(" "));
        descriptor.getNote().ifPresent(note -> sb.append(PREFIX_TASK_NOTE).append(note.value).append(" "));
        return sb.toString();
    }
}
