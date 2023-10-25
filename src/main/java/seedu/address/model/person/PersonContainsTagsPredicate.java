package seedu.address.model.person;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import seedu.address.commons.util.StringUtil;
import seedu.address.commons.util.ToStringBuilder;

/**
 * Tests that a {@code Person}'s {@code Tags} matches any of the keywords given.
 */
public class PersonContainsTagsPredicate implements Predicate<Person> {
    private final List<String> keywords;

    public PersonContainsTagsPredicate(List<String> keywords) {
        this.keywords = keywords;
    }

    @Override
    public boolean test(Person person) {
        return keywords.stream()
                .anyMatch(keyword -> {
                    return StringUtil.containsWordIgnoreCase(person.getTags().stream().map(Object::toString)
                            .collect(Collectors.joining(" ")), "[" + keyword + "]");
                        });
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof PersonContainsTagsPredicate)) {
            return false;
        }

        PersonContainsTagsPredicate otherPersonContainsTagsPredicate = (PersonContainsTagsPredicate) other;
        return keywords.equals(otherPersonContainsTagsPredicate.keywords);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).add("keywords", keywords).toString();
    }
}
