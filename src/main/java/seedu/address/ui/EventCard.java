package seedu.address.ui;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import seedu.address.commons.util.DateUtil;
import seedu.address.commons.util.TimeUtil;
import seedu.address.model.task.repeatable.Event;

/**
 * An UI component that displays information of an {@code Event}.
 */
public class EventCard extends UiPart<Region> {

    private static final String FXML = "EventCard.fxml";

    public final Event event;

    @FXML
    private HBox cardPane;
    @FXML
    private Label id;
    @FXML
    private Label eventDescription;
    @FXML
    private Label day;
    @FXML
    private Label date;
    @FXML
    private Label time;

    /**
     * Creates an {@code EventCard} with the given {@code Event} without an index to display.
     */
    public EventCard(Event event) {
        super(FXML);
        requireNonNull(event);

        this.event = event;
        id.setText("");
        eventDescription.setText(event.getDescription());
        date.setText(DateUtil.decodeDateWithDay(event.getDate()));
        time.setText(TimeUtil.decodeTime(event.getTime()));
    }

    /**
     * Creates an {@code EventCard} with the given {@code Event} and index to display.
     */
    public EventCard(Event event, int displayedIndex) {
        super(FXML);
        requireAllNonNull(event, displayedIndex);

        this.event = event;
        id.setText(displayedIndex + ". ");
        eventDescription.setText(event.getDescription());
        day.setText(DateUtil.decodeDateIntoDay(event.getDate()));
        date.setText(DateUtil.decodeDate(event.getDate()));
        time.setText(TimeUtil.decodeTime(event.getTime()));
    }

    @Override
    public boolean equals(Object other) {
        // short circuit if same object
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof EventCard)) {
            return false;
        }

        // state check
        EventCard card = (EventCard) other;
        return id.getText().equals(card.id.getText())
                && event.equals(card.event);
    }
}
