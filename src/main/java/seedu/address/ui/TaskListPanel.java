package seedu.address.ui;

import java.util.logging.Logger;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.Region;
import seedu.address.commons.core.LogsCenter;
import seedu.address.model.task.Task;

/**
 * Panel containing the list of tasks.
 */
public class TaskListPanel extends UiPart<Region> {
    private static final String DONE_BACKGROUND_COLOR_EVEN = "-fx-background-color: #334f3c";
    private static final String DONE_BACKGROUND_COLOR_ODD = "-fx-background-color: #82ba75";
    private static final String FXML = "TaskListPanel.fxml";
    private static final String NOT_DONE_BACKGROUND_COLOR_EVEN = "-fx-background-color: #5d3538";
    private static final String NOT_DONE_BACKGROUND_COLOR_ODD = "-fx-background-color: #ba7575";
    private final Logger logger = LogsCenter.getLogger(TaskListPanel.class);


    @FXML
    private ListView<Task> taskListView;

    /**
     * Creates a {@code TaskListPanel} with the given {@code ObservableList}.
     */
    public TaskListPanel(ObservableList<Task> taskList) {
        super(FXML);
        taskListView.setItems(taskList);
        taskListView.setCellFactory(listView -> new TaskListViewCell());
    }

    /**
     * Custom {@code ListCell} that displays the graphics of a {@code Task} using a {@code TaskCard}.
     */
    class TaskListViewCell extends ListCell<Task> {
        @Override
        protected void updateItem(Task task, boolean empty) {
            super.updateItem(task, empty);

            if (empty || task == null) {
                setGraphic(null);
                setText(null);
            } else {
                setGraphic(new TaskCard(task, getIndex() + 1).getRoot());
                String backgroundColor;
                if (task.getStatus().toString().equals("Done")) {
                    if (getIndex() % 2 == 0) {
                        backgroundColor = DONE_BACKGROUND_COLOR_EVEN;
                    } else {
                        backgroundColor = DONE_BACKGROUND_COLOR_ODD;
                    }
                } else {
                    if (getIndex() % 2 == 0) {
                        backgroundColor = NOT_DONE_BACKGROUND_COLOR_EVEN;
                    } else {
                        backgroundColor = NOT_DONE_BACKGROUND_COLOR_ODD;
                    }
                }
                setStyle(backgroundColor);
            }

        }
    }

}
