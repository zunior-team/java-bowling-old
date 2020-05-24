package bowling.state;

import bowling.pin.Pin;

import java.util.Arrays;
import java.util.List;

import static bowling.pin.Pin.MAX_COUNT_OF_PINS;


public class Spare extends EndState {

    private final Pin firstDownPins;

    private Spare(final Pin firstDownPins) {
        this.firstDownPins = firstDownPins;
    }

    public static Spare of(final Pin firstDownPins) {
        return new Spare(firstDownPins);
    }

    @Override
    public List<Integer> getDownPins() {
        return Arrays.asList(firstDownPins.getPins(), MAX_COUNT_OF_PINS - firstDownPins.getPins());
    }
}
