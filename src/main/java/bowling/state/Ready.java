package bowling.state;

import bowling.pin.Pins;

public class Ready implements State {
    private static final Ready READY = new Ready();

    private Ready() {}

    public static Ready getInstance() {
        return READY;
    }

    @Override
    public Pins ball(final Pins pins, final int countOfFallenPins) {
        return pins.firstRoll(countOfFallenPins);
    }

    @Override
    public State updateState(final Pins pins) {
        if(pins.isAllFallen()) {
            return Strike.getInstance();
        }

        return Playing.getInstance();
    }
}
