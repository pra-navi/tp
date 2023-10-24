package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;

import seedu.address.commons.util.ToStringBuilder;
import seedu.address.logic.Messages;
import seedu.address.model.Model;
import seedu.address.model.task.Status;
import seedu.address.model.task.TaskStatusPredicate;

/**
 * Finds and lists all task in address book whose status is {@link Status#STATUS_DONE}.
 */
public class FindDoneCommand extends Command {

    public static final String COMMAND_WORD = "findDone";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Finds all tasks whose status is marked as "
            + "done and displays them as a list with index numbers.\n"
            + "Example: " + COMMAND_WORD;

    private final TaskStatusPredicate predicate;

    public FindDoneCommand() {
        this.predicate = new TaskStatusPredicate(Status.STATUS_DONE);
    }

    @Override
    public CommandResult execute(Model model) {
        requireNonNull(model);
        model.updateFilteredTaskList(predicate);
        return new CommandResult(
                String.format(Messages.MESSAGE_TASKS_LISTED_OVERVIEW, model.getFilteredTaskList().size()));
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof FindDoneCommand)) {
            return false;
        }

        FindDoneCommand otherFindDoneCommand = (FindDoneCommand) other;
        return predicate.equals(otherFindDoneCommand.predicate);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .add("predicate", predicate)
                .toString();
    }
}
