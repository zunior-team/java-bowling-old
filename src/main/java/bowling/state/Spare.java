package bowling.state;

import bowling.pin.Pins;

public class Spare implements EndState {
    private static final Spare SPARE = new Spare();

    private Spare() {}

    public static State getInstance() {
        return SPARE;
    }

    @Override
    public Pins ball(Pins pins, int countOfFallenPins) {
        return null;
    }

    @Override
    public State updateState(Pins pins) {
        return null;
    }
}
