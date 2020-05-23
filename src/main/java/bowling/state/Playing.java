package bowling.state;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Playing extends State {
    private final int firstDownPins;

    private Playing(final int firstDownPins) {
        this.firstDownPins = firstDownPins;
    }

    public static Playing of(final int firstDownPins) {
        return new Playing(firstDownPins);
    }

    @Override
    public State downPins(int numOfDownPins) {
        if (firstDownPins + numOfDownPins == 10) {
            return Spare.of(firstDownPins);
        }

        return Miss.of(firstDownPins, numOfDownPins);
    }

    @Override
    public List<Integer> getDownPins() {
        return Collections.singletonList(firstDownPins);
    }
}
