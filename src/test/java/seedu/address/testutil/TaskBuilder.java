package seedu.address.testutil;

import seedu.address.model.task.Note;
import seedu.address.model.task.Task;
import seedu.address.model.task.Title;
import seedu.address.model.task.Status;

/**
 * A utility class to help with building Task objects.
 */
public class TaskBuilder {

    public static final String DEFAULT_TITLE = "Plan the event";
    public static final String DEFAULT_NOTE = "Come up with a comprehensive plan for the event.";

    private Title title;
    private Note note;
    private Status status;

    /**
     * Creates a {@code TaskBuilder} with the default details.
     */
    public TaskBuilder() {
        title = new Title(DEFAULT_TITLE);
        note = new Note(DEFAULT_NOTE);
        status = new Status("false");
    }

    /**
     * Initializes the TaskBuilder with the data of {@code taskToCopy}.
     */
    public TaskBuilder(Task taskToCopy) {
        title = taskToCopy.getTitle();
        note = taskToCopy.getNote();
        status = taskToCopy.getStatus();
    }

    /**
     * Sets the {@code Title} of the {@code Task} that we are building.
     */
    public TaskBuilder withTitle(String title) {
        this.title = new Title(title);
        return this;
    }

    /**
     * Sets the {@code Note} of the {@code Task} that we are building.
     */
    public TaskBuilder withNote(String note) {
        this.note = new Note(note);
        return this;
    }

    /**
     * Sets the {@code Status} of the {@code Task} that we are building.
     */
    public TaskBuilder withStatus(String status) {
        this.status = new Status(status);
        return this;
    }

    public Task build() {
        Task newTask = new Task(title, note);
        if (this.status.equals(new Status("true"))) {
            newTask.markDone();
        }
        return newTask;
    }
}
