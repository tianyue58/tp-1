package seedu.address.storage;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import seedu.address.commons.exceptions.DateConversionException;
import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.commons.util.DateUtil;
import seedu.address.model.task.Completable;
import seedu.address.model.task.completable.Deadline;
import seedu.address.model.task.completable.Todo;

/**
 * Jackson-friendly version of {@link Completable}.
 */
class JsonAdaptedCompletable {
    private final String description;
    private final String by;
    private final Boolean isDone;

    /**
     * Constructs a {@code JsonAdaptedEvent} with the given {@code description}, {@code interval},
     * {@code at} and {@code isDone}.
     */
    @JsonCreator
    public JsonAdaptedCompletable(@JsonProperty("description")String description,
                                  @JsonProperty("date") String by,
                                  @JsonProperty("isDone") Boolean isDone) {
        this.description = description;
        this.by = by;
        this.isDone = isDone;
    }

    /**
     * Converts a given {@code Event} into this class for Jackson use.
     */
    public JsonAdaptedCompletable(Completable source) {
        description = source.getDescription();
        by = source.getStringByDate();
        isDone = source.getIsDone();
    }

    /**
     * Converts this Jackson-friendly adapted tag object into the model's {@code Event} object.
     *
     * @throws IllegalValueException if there were any data constraints violated in the adapted event.
     */
    public Completable toModelType() throws IllegalValueException {
        if (by == null) {
            return new Todo(description, isDone);
        } else {
            LocalDate date = parseDate(by);
            return new Deadline(description, isDone, date);
        }
    }

    private LocalDate parseDate(String date) throws IllegalValueException {
        try {
            return DateUtil.encodeDate(date);
        } catch (DateConversionException e) {
            // TODO update e.getMessage with date constraints
            throw new IllegalValueException(e.getMessage());
        }
    }

}
