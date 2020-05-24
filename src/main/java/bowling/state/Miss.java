package bowling.state;

import bowling.pin.Pin;

import java.util.Arrays;
import java.util.List;

public class Miss extends EndState {
    private final Pin firstDownPins;
    private final Pin secondDownPins;

    private Miss(final Pin firstDownPins, final Pin secondDownPins) {
        this.firstDownPins = firstDownPins;
        this.secondDownPins = secondDownPins;
    }

    public static Miss of(final Pin firstDownPins, final Pin secondDownPins) {
        return new Miss(firstDownPins, secondDownPins);
    }

    @Override
    public List<Integer> getDownPins() {
        return Arrays.asList(firstDownPins.getPins(), secondDownPins.getPins());
    }
}
