package seedu.address.model.task;

import java.util.List;
import java.util.function.Predicate;

import seedu.address.commons.util.StringUtil;

/**
 * Tests that a {@code Task}'s {@code TaskTitle} matches any of the keywords given.
 */
public class TitleContainsKeywordsPredicate implements Predicate<Task> {
    private final List<String> keywords;

    public TitleContainsKeywordsPredicate(List<String> keyWords) {
        this.keywords = keyWords;
    }

    @Override
    public boolean test(Task task) {
        return keywords
                .stream()
                .anyMatch(keyword -> {
                    String titleAndNote = task.getTitle().toString() + " " + task.getNote().toString();
                    return StringUtil.containsWordIgnoreCase(titleAndNote, keyword);
                });
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof Title)) {
            return false;
        }

        TitleContainsKeywordsPredicate otherTitle = (TitleContainsKeywordsPredicate) other;
        return keywords.equals(otherTitle.keywords);
    }
}
