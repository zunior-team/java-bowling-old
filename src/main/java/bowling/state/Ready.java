package bowling.state;

import java.util.Collections;
import java.util.List;

public class Ready extends State {
    private static final Ready READY = new Ready();

    private Ready() {}

    public static Ready getInstance() {
        return READY;
    }

    @Override
    public State downPins(final int numOfDownPins) {
        if (numOfDownPins == 10) {
            return Strike.getInstance();
        }

        return Playing.of(numOfDownPins);
    }

    @Override
    public List<Integer> getDownPins() {
        return Collections.EMPTY_LIST;
    }
}
