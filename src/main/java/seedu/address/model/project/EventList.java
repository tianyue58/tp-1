package seedu.address.model.project;

import static java.util.Objects.requireNonNull;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import seedu.address.model.task.repeatable.Event;

/**
 * Represents a list of Events.
 */
public class EventList {

    private final List<Event> events = new ArrayList<>();

    /**
     * Constructs an empty {@code EventList}.
     */
    public EventList () {}

    /**
     * Constructs an {@code EventList}.
     *
     * @param events A list of {@code Event}.
     */
    public EventList (List<Event> events) {
        requireNonNull(events);

        this.events.addAll(events);
    }

    /**
     * Adds an event to this {@code EventList}.
     *
     * @param event {@code Event} to add.
     */
    public void addEvent(Event event) {
        requireNonNull(event);
        this.events.add(event);
    }

    /**
     * Deletes an event from this {@code EventList}.
     *
     * @param i Index of {@code Event} to be deleted.
     */
    public void deleteEvent(Integer i) {
        requireNonNull(i);
        this.events.remove(i);
    }

    public List<Event> getEvents() {
        return events;
    }

    /**
     * Returns a copy of this {@code EventList}
     * @return A copy of this {@code EventList}
     */
    public EventList getCopy() {
        return new EventList(getEvents());
    }

    /**
     * Returns a sequential stream with this {@code EventList} as its source.
     * @return a sequential Stream over the events in this {@code EventList}.
     */
    public Stream<Event> stream() {
        return events.stream();
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof EventList // instanceof handles nulls
                && events.equals(((EventList) other).events)); // state check
    }

    @Override
    public int hashCode() {
        return events.hashCode();
    }

}
