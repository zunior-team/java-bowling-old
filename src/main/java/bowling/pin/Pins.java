package bowling.pin;

import java.util.List;

public class Pins {
    public static final int MAX_COUNT_OF_PINS = 10;

    private int noOfDownPins;
    private int noOfSecondDownPins;

    protected Pins() {

    }

    public static Pins init() {
        return new Pins();
    }

    public Pins down(final int noOfDownPins) {
        validate(noOfDownPins);
        validate(this.noOfDownPins + noOfDownPins);
        this.noOfSecondDownPins = noOfDownPins;

        return this;
    }

    private void validate(int noOfDownPins) {
        if (noOfDownPins > MAX_COUNT_OF_PINS) {
            throw new IllegalArgumentException(
                    "Number of down pin is invalid : " + noOfDownPins + " Max[" + MAX_COUNT_OF_PINS + "]"
            );
        }
    }

    public boolean isAllDown() {
        return noOfDownPins + noOfSecondDownPins == MAX_COUNT_OF_PINS;
    }
}
