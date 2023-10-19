
package seedu.address.logic.parser;

import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.commands.CommandTestUtil.INVALID_NOTE_DESC;
import static seedu.address.logic.commands.CommandTestUtil.INVALID_TITLE_DESC;
import static seedu.address.logic.commands.CommandTestUtil.NOTE_DESC_AGENDA;
import static seedu.address.logic.commands.CommandTestUtil.TITLE_DESC_AGENDA;
import static seedu.address.logic.commands.CommandTestUtil.VALID_NOTE_AGENDA;
import static seedu.address.logic.commands.CommandTestUtil.VALID_TITLE_AGENDA;
import static seedu.address.logic.parser.CliSyntax.PREFIX_TASK_NOTE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_TASK_TITLE;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseFailure;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseSuccess;
import static seedu.address.testutil.TypicalIndexes.INDEX_FIRST;
import static seedu.address.testutil.TypicalIndexes.INDEX_SECOND;
import static seedu.address.testutil.TypicalIndexes.INDEX_THIRD;

import org.junit.jupiter.api.Test;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.Messages;
import seedu.address.logic.commands.EditTaskCommand;
import seedu.address.logic.commands.EditTaskCommand.EditTaskDescriptor;
import seedu.address.model.task.Note;
import seedu.address.model.task.Title;
import seedu.address.testutil.EditTaskDescriptorBuilder;

public class EditTaskCommandParserTest {

    private static final String MESSAGE_INVALID_FORMAT = String.format(MESSAGE_INVALID_COMMAND_FORMAT,
            EditTaskCommand.MESSAGE_USAGE);

    private EditTaskCommandParser parser = new EditTaskCommandParser();

    @Test
    public void parse_missingParts_failure() {
        // no index specified
        assertParseFailure(parser, VALID_TITLE_AGENDA, MESSAGE_INVALID_FORMAT);

        // no field specified
        assertParseFailure(parser, "1", EditTaskCommand.MESSAGE_NOT_EDITED);

        // no index and no field specified
        assertParseFailure(parser, "", MESSAGE_INVALID_FORMAT);
    }

    @Test
    public void parse_invalidPreamble_failure() {
        // negative index
        assertParseFailure(parser, "-5" + TITLE_DESC_AGENDA, MESSAGE_INVALID_FORMAT);

        // zero index
        assertParseFailure(parser, "0" + TITLE_DESC_AGENDA, MESSAGE_INVALID_FORMAT);

        // invalid arguments being parsed as preamble
        assertParseFailure(parser, "1 some random string", MESSAGE_INVALID_FORMAT);

        // invalid prefix being parsed as preamble
        assertParseFailure(parser, "1 i/ string", MESSAGE_INVALID_FORMAT);
    }

    @Test
    public void parse_invalidValue_failure() {
        assertParseFailure(parser, "1" + INVALID_TITLE_DESC, Title.MESSAGE_CONSTRAINTS); // invalid title
        assertParseFailure(parser, "1" + INVALID_NOTE_DESC, Note.MESSAGE_CONSTRAINTS); // invalid note

        // invalid title followed by valid note
        assertParseFailure(parser, "1" + INVALID_TITLE_DESC + NOTE_DESC_AGENDA, Title.MESSAGE_CONSTRAINTS);

        // multiple invalid values, but only the first invalid value is captured
        assertParseFailure(parser, "1" + INVALID_TITLE_DESC + INVALID_NOTE_DESC, Title.MESSAGE_CONSTRAINTS);
    }

    @Test
    public void parse_allFieldsSpecified_success() {
        Index targetIndex = INDEX_SECOND;
        String userInput = targetIndex.getOneBased() + TITLE_DESC_AGENDA + NOTE_DESC_AGENDA;

        EditTaskDescriptor descriptor = new EditTaskDescriptorBuilder().withTitle(VALID_TITLE_AGENDA)
                .withNote(VALID_NOTE_AGENDA).build();
        EditTaskCommand expectedCommand = new EditTaskCommand(targetIndex, descriptor);

        assertParseSuccess(parser, userInput, expectedCommand);
    }

    @Test
    public void parse_someFieldsSpecified_success() {
        Index targetIndex = INDEX_FIRST;
        String userInput = targetIndex.getOneBased() + TITLE_DESC_AGENDA;

        EditTaskDescriptor descriptor = new EditTaskDescriptorBuilder().withTitle(VALID_TITLE_AGENDA).build();
        EditTaskCommand expectedCommand = new EditTaskCommand(targetIndex, descriptor);

        assertParseSuccess(parser, userInput, expectedCommand);
    }

    @Test
    public void parse_oneFieldSpecified_success() {
        // title
        Index targetIndex = INDEX_THIRD;
        String userInput = targetIndex.getOneBased() + TITLE_DESC_AGENDA;
        EditTaskDescriptor descriptor = new EditTaskDescriptorBuilder().withTitle(VALID_TITLE_AGENDA).build();
        EditTaskCommand expectedCommand = new EditTaskCommand(targetIndex, descriptor);
        assertParseSuccess(parser, userInput, expectedCommand);

        // note
        userInput = targetIndex.getOneBased() + NOTE_DESC_AGENDA;
        descriptor = new EditTaskDescriptorBuilder().withNote(VALID_NOTE_AGENDA).build();
        expectedCommand = new EditTaskCommand(targetIndex, descriptor);
        assertParseSuccess(parser, userInput, expectedCommand);
    }

    @Test
    public void parse_multipleRepeatedFields_failure() {
        // More extensive testing of duplicate parameter detections is done in
        // AddTaskCommandParserTest#parse_repeatedNonTagValue_failure()

        // valid followed by invalid
        Index targetIndex = INDEX_FIRST;
        String userInput = targetIndex.getOneBased() + INVALID_TITLE_DESC + TITLE_DESC_AGENDA;
        assertParseFailure(parser, userInput, Messages.getErrorMessageForDuplicatePrefixes(PREFIX_TASK_TITLE));

        // invalid followed by valid
        userInput = targetIndex.getOneBased() + TITLE_DESC_AGENDA + INVALID_TITLE_DESC;
        assertParseFailure(parser, userInput, Messages.getErrorMessageForDuplicatePrefixes(PREFIX_TASK_TITLE));

        // mulltiple valid fields repeated
        userInput = targetIndex.getOneBased() + TITLE_DESC_AGENDA + NOTE_DESC_AGENDA
                + TITLE_DESC_AGENDA + NOTE_DESC_AGENDA
                + TITLE_DESC_AGENDA + NOTE_DESC_AGENDA;
        assertParseFailure(parser, userInput,
                Messages.getErrorMessageForDuplicatePrefixes(PREFIX_TASK_TITLE, PREFIX_TASK_NOTE));

        // multiple invalid values
        userInput = targetIndex.getOneBased() + INVALID_TITLE_DESC + INVALID_NOTE_DESC
                + INVALID_TITLE_DESC + INVALID_NOTE_DESC
                + INVALID_TITLE_DESC + INVALID_NOTE_DESC;

        assertParseFailure(parser, userInput,
                Messages.getErrorMessageForDuplicatePrefixes(PREFIX_TASK_TITLE, PREFIX_TASK_NOTE));
    }
}
