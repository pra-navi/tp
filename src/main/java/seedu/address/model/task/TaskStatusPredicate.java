package seedu.address.model.task;

import java.util.function.Predicate;

/**
 * Tests that a {@code Task}'s {@code status} matches the given status.
 */
public class TaskStatusPredicate implements Predicate<Task> {
    private final Status status;

    public TaskStatusPredicate(Status status) {
        this.status = status;
    }

    @Override
    public boolean test(Task task) {
        return task.getStatus().equals(status);
    }
}
