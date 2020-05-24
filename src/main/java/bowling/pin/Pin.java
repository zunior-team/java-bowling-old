package bowling.pin;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Pin {
    public static final int MAX_COUNT_OF_PINS = 10;
    public static final int MIN_COUNT_OF_PINS = 0;

    public static final Map<Integer, Pin> PINS = IntStream.rangeClosed(MIN_COUNT_OF_PINS, MAX_COUNT_OF_PINS)
            .mapToObj(Pin::new)
            .collect(Collectors.toMap(Pin::getPins, Function.identity()));

    private final int noOfDownPins;

    private Pin(final int noOfDownPins) {
        validate(noOfDownPins);

        this.noOfDownPins = noOfDownPins;
    }

    private void validate(final int noOfDownPins) {
        if (noOfDownPins > MAX_COUNT_OF_PINS) {
            throw new IllegalArgumentException(
                    "Number of down pin is invalid : " + noOfDownPins + " Max[" + MAX_COUNT_OF_PINS + "]"
            );
        }
    }

    public static Pin of(final int noOfDownPins) {
        validateRange(noOfDownPins);

        return PINS.get(noOfDownPins);
    }

    private static void validateRange(final int noOfDownPins) {
        if (noOfDownPins < MIN_COUNT_OF_PINS || MAX_COUNT_OF_PINS < noOfDownPins) {
            throw new IllegalArgumentException(
                    "Number of down pin must be range in " + MIN_COUNT_OF_PINS + "~" + MAX_COUNT_OF_PINS
            );
        }
    }

    public boolean isAllDown(final Pin anotherPin) {
        validate(this.noOfDownPins + anotherPin.noOfDownPins);

        return this.noOfDownPins + anotherPin.noOfDownPins == MAX_COUNT_OF_PINS;
    }

    public boolean isAllDown() {
        return noOfDownPins == MAX_COUNT_OF_PINS;
    }

    public int getPins() {
        return noOfDownPins;
    }
}
