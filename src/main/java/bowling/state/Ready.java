package bowling.state;

import bowling.pin.Pin;

import java.util.Collections;
import java.util.List;

public class Ready extends State {
    private static final Ready READY = new Ready();

    private Ready() {}

    public static Ready getInstance() {
        return READY;
    }

    @Override
    public State downPins(Pin downPins) {
        if (downPins.isAllDown()) {
            return Strike.getInstance();
        }

        return Playing.of(downPins);
    }

    @Override
    public List<Integer> getDownPins() {
        return Collections.EMPTY_LIST;
    }
}
