package bowling.state;

import java.util.Arrays;
import java.util.List;

import static bowling.pin.Pins.MAX_COUNT_OF_PINS;

public class Spare extends EndState {

    private final int firstDownPins;

    private Spare(final int firstDownPins) {
        this.firstDownPins = firstDownPins;
    }

    public static Spare of(final int firstDownPins) {
        return new Spare(firstDownPins);
    }

    @Override
    public List<Integer> getDownPins() {
        return Arrays.asList(firstDownPins, MAX_COUNT_OF_PINS - firstDownPins);
    }
}
