package bowling.state;

import java.util.Collections;
import java.util.List;

import static bowling.pin.Pins.MAX_COUNT_OF_PINS;

public class Strike extends EndState {
    private static final Strike STRIKE = new Strike();

    private Strike() {}

    public static Strike getInstance() {
        return STRIKE;
    }

    @Override
    public List<Integer> getDownPins() {
        return Collections.singletonList(MAX_COUNT_OF_PINS);
    }
}
