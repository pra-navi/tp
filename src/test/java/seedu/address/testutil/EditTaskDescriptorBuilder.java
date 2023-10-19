package seedu.address.testutil;

import seedu.address.logic.commands.EditTaskCommand.EditTaskDescriptor;
import seedu.address.model.task.Note;
import seedu.address.model.task.Task;
import seedu.address.model.task.Title;

/**
 * A utility class to help with building EditTaskDescriptor objects.
 */
public class EditTaskDescriptorBuilder {

    private EditTaskDescriptor descriptor;

    public EditTaskDescriptorBuilder() {
        descriptor = new EditTaskDescriptor();
    }

    public EditTaskDescriptorBuilder(EditTaskDescriptor descriptor) {
        this.descriptor = new EditTaskDescriptor(descriptor);
    }

    /**
     * Returns an {@code EditTaskDescriptor} with fields containing {@code task}'s details
     */
    public EditTaskDescriptorBuilder(Task title) {
        descriptor = new EditTaskDescriptor();
        descriptor.setTitle(title.getTitle());
        descriptor.setNote(title.getNote());
    }

    /**
     * Sets the {@code Name} of the {@code EditTaskDescriptor} that we are building.
     */
    public EditTaskDescriptorBuilder withTitle(String title) {
        descriptor.setTitle(new Title(title));
        return this;
    }

    /**
     * Sets the {@code Phone} of the {@code EditTaskDescriptor} that we are building.
     */
    public EditTaskDescriptorBuilder withNote(String note) {
        descriptor.setNote(new Note(note));
        return this;
    }

    public EditTaskDescriptor build() {
        return descriptor;
    }
}
