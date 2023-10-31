package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;

import seedu.address.commons.util.ToStringBuilder;
import seedu.address.logic.Messages;
import seedu.address.model.Model;
import seedu.address.model.person.PersonContainsAllTagsPredicate;
import seedu.address.model.task.TaskContainsAllTagsPredicate;

/**
 * Finds and lists all persons and tasks in address book whose tag contains any of the argument keywords.
 */
public class FindAllTagCommand extends Command {

    public static final String COMMAND_WORD = "findAllTag";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Finds all persons and tasks whose tag contain all of "
            + "the specified keywords (case-insensitive) and displays them as a list with index numbers.\n"
            + "Parameters: KEYWORD [MORE_KEYWORDS]...\n"
            + "Example: " + COMMAND_WORD + " agenda";

    private final TaskContainsAllTagsPredicate taskPredicate;
    private final PersonContainsAllTagsPredicate personPredicate;

    /**
     * Creates a FindAllTagCommand to find the specified {@code TaskContainsAllTagsPredicate} and
     * {@code PersonContainsAllTagsPredicate}
     */
    public FindAllTagCommand(TaskContainsAllTagsPredicate taskPredicate,
                             PersonContainsAllTagsPredicate personPredicate) {
        this.taskPredicate = taskPredicate;
        this.personPredicate = personPredicate;
    }

    @Override
    public CommandResult execute(Model model) {
        requireNonNull(model);
        model.updateFilteredTaskList(taskPredicate);
        model.updateFilteredPersonList(personPredicate);
        return new CommandResult(
                String.format(Messages.MESSAGE_PERSONS_TASKS_LISTED_OVERVIEW,
                        model.getFilteredPersonList().size(), model.getFilteredTaskList().size()));
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof FindTaskCommand)) {
            return false;
        }

        FindAllTagCommand otherFindAllTagCommand = (FindAllTagCommand) other;
        return taskPredicate.equals(otherFindAllTagCommand.taskPredicate)
                && personPredicate.equals(otherFindAllTagCommand.personPredicate);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .add("taskPredicate", taskPredicate)
                .add("personPredicate", personPredicate)
                .toString();
    }
}
