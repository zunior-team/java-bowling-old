package bowling.state;

import java.util.Arrays;
import java.util.List;

public class Miss extends EndState {
    private final int firstDownPins;
    private final int secondDownPins;

    private Miss(final int firstDownPins, final int secondDownPins) {
        this.firstDownPins = firstDownPins;
        this.secondDownPins = secondDownPins;
    }

    public static Miss of(final int firstDownPins, final int secondDownPins) {
        return new Miss(firstDownPins, secondDownPins);
    }

    @Override
    public List<Integer> getDownPins() {
        return Arrays.asList(firstDownPins, secondDownPins);
    }
}
