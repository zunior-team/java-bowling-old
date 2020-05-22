package bowling.state;

import bowling.pin.Pins;

public class Strike implements EndState {
    private static final Strike STRIKE = new Strike();

    private Strike() {}

    public static State getInstance() {
        return STRIKE;
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
