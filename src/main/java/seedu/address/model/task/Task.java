package seedu.address.model.task;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.util.Objects;

import seedu.address.commons.util.ToStringBuilder;

/**
 * Represents a Task in the task list.
 * Guarantees: details are present and not null, field values are validated, immutable.
 */
public class Task {

    // Identity fields
    private final Title title;
    private final Note note;
    private Status status;

    /**
     * A Task consists of a title and a note.
     * Both fields must be present and not null.
     * Tasks will be default not done when created.
     */
    public Task(Title title, Note note) {
        requireAllNonNull(title, note);
        this.title = title;
        this.note = note;
        this.status = new Status(Status.TaskStatus.NOT_DONE);
    }

    private Task(Title title, Note note, Status status) {
        requireAllNonNull(title, note);
        this.title = title;
        this.note = note;
        this.status = status;
    }

    public Title getTitle() {
        return title;
    }

    public Note getNote() {
        return note;
    }

    public Status getStatus() {
        return status;
    }

    /**
     * Updates the Status of the Task as Done.
     */
    public Task markDone() {
        return new Task(title, note, new Status(Status.TaskStatus.DONE));
    }

    /**
     * Updates the Status of the Task as not Done.
     */
    public Task markNotDone() {
        return new Task(title, note, new Status(Status.TaskStatus.NOT_DONE));
    }

    /**
     * Returns true if both tasks have the same title, note and status.
     */
    public boolean isSameTask(Task otherTask) {
        return this.equals(otherTask);
    }

    /**
     * Returns true if both tasks have the same title, note and status.
     */
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof Task)) {
            return false;
        }

        Task otherTask = (Task) other;
        return title.equals(otherTask.title)
                && note.equals(otherTask.note);
    }

    @Override
    public int hashCode() {
        // use this method for custom fields hashing instead of implementing your own
        return Objects.hash(title, note);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .add("title", title)
                .add("note", note)
                .add("status", status)
                .toString();
    }

}
