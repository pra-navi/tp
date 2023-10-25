package seedu.address.model.task;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import seedu.address.commons.util.StringUtil;
import seedu.address.commons.util.ToStringBuilder;

/**
 * Tests that a {@code Task}'s {@code Tags} matches any of the keywords given.
 */
public class TaskContainsTagsPredicate implements Predicate<Task> {
    private final List<String> keywords;

    public TaskContainsTagsPredicate(List<String> keywords) {
        this.keywords = keywords;
    }

    @Override
    public boolean test(Task task) {
        return keywords.stream()
                .anyMatch(keyword ->
                        StringUtil.containsWordIgnoreCase(task.getTags().stream().map(Object::toString)
                                .collect(Collectors.joining(", ")), "[" + keyword + "]"));
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof TaskContainsTagsPredicate)) {
            return false;
        }

        TaskContainsTagsPredicate otherTaskContainsTagsPredicate = (TaskContainsTagsPredicate) other;
        return keywords.equals(otherTaskContainsTagsPredicate.keywords);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).add("keywords", keywords).toString();
    }
}
