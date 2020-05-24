package bowling.state;

import bowling.pin.Pin;

import java.util.Collections;
import java.util.List;

public class Playing extends State {
    private final Pin firstDownPins;

    private Playing(final Pin downPins) {
        this.firstDownPins = downPins;
    }

    public static Playing of(final Pin downPins) {
        return new Playing(downPins);
    }

    @Override
    public State downPins(Pin secondDownPins) {
        if (firstDownPins.isAllDown(secondDownPins)) {
            return Spare.of(firstDownPins);
        }

        return Miss.of(firstDownPins, secondDownPins);
    }

    @Override
    public List<Integer> getDownPins() {
        return Collections.singletonList(firstDownPins.getPins());
    }
}
