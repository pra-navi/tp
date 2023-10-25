package seedu.address.model.tag;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import seedu.address.commons.util.ToStringBuilder;
import seedu.address.model.person.Person;
import seedu.address.model.task.Task;

/**
 * Represents a table of tag frequencies for both persons and tasks in the address book.
 */
public class TagFrequencyTable {

    private final Map<Tag, Integer> personTagFrequency;
    private final Map<Tag, Integer> taskTagFrequency;
    private final Map<Tag, Integer> combinedTagFrequency;

    /**
     * Constructs a new {@code TagFrequencyTable} from a list of {@code Person}s and {@code Task}s.
     *
     * @param personList List of {@code Person}s.
     * @param taskList List of {@code Task}s.
     */
    public TagFrequencyTable(List<Person> personList, List<Task> taskList) {
        this.personTagFrequency = new HashMap<>();
        this.taskTagFrequency = new HashMap<>();
        this.combinedTagFrequency = new HashMap<>();

        personList.forEach(this::processPerson);
        taskList.forEach(this::processTask);
    }

    /**
     * Processes the tags of a person and increments the frequency of each tag.
     *
     * @param p The Person whose tags are to be processed.
     */
    private void processPerson(Person p) {
        p.getTags().forEach(tag -> {
            personTagFrequency.put(tag, personTagFrequency.getOrDefault(tag, 0) + 1);
            combinedTagFrequency.put(tag, combinedTagFrequency.getOrDefault(tag, 0) + 1);
        });
    }

    /**
     * Processes the tags of a task and increments the frequency of each tag.
     *
     * @param t The Task whose tags are to be processed.
     */
    private void processTask(Task t) {
        t.getTags().forEach(tag -> {
            taskTagFrequency.put(tag, taskTagFrequency.getOrDefault(tag, 0) + 1);
            combinedTagFrequency.put(tag, combinedTagFrequency.getOrDefault(tag, 0) + 1);
        });
    }

    public Map<Tag, Integer> getPersonTagFrequency() {
        return new HashMap<>(personTagFrequency);
    }

    public Map<Tag, Integer> getTaskTagFrequency() {
        return new HashMap<>(taskTagFrequency);
    }

    public Map<Tag, Integer> getCombinedTagFrequency() {
        return new HashMap<>(combinedTagFrequency);
    }

    /**
     * Returns a formatted string of the tag frequency table.
     * The output is formatted in descending order of tag frequency, and then in alphabetical order.
     *
     * @return Formatted String representation of the tag frequency table.
     */
    public String format() {
        ArrayList<String> formattedTagList = new ArrayList<>();

        // Compares two entries in the table, and sorts them in descending order of frequency.
        // If two entries have the same frequency, they are sorted in alphabetical order.
        // Solution inspired by https://stackoverflow.com/a/33552682
        Comparator<Map.Entry<Tag, Integer>> comparator = (e1, e2) ->
                e1.getValue().equals(e2.getValue())
                        ? e1.getKey().compareTo(e2.getKey())
                        : e2.getValue().compareTo(e1.getValue());

        combinedTagFrequency.entrySet()
                .stream()
                .sorted(comparator)
                .map(entry -> String.format("%s: %d items (%d Persons, %d Tasks)",
                        entry.getKey(),
                        entry.getValue(),
                        personTagFrequency.getOrDefault(entry.getKey(), 0),
                        taskTagFrequency.getOrDefault(entry.getKey(), 0)))
                .forEach(formattedTagList::add);

        return String.join("\n", formattedTagList);
    }

    /**
     * Checks if the tag frequency table is empty.
     *
     * @return True if the tag frequency table is empty.
     */
    public boolean isEmpty() {
        return combinedTagFrequency.isEmpty();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .add("personTagFrequency", personTagFrequency)
                .add("taskTagFrequency", taskTagFrequency)
                .add("combinedTagFrequency", combinedTagFrequency)
                .toString();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof TagFrequencyTable)) {
            return false;
        }

        TagFrequencyTable otherTable = (TagFrequencyTable) other;
        return personTagFrequency.equals(otherTable.personTagFrequency)
               && taskTagFrequency.equals(otherTable.taskTagFrequency)
               && combinedTagFrequency.equals(otherTable.combinedTagFrequency);
    }

    @Override
    public int hashCode() {
        return Objects.hash(personTagFrequency, taskTagFrequency, combinedTagFrequency);
    }
}
