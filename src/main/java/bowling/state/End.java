package bowling.state;

import bowling.pin.Pins;

public class End implements EndState {
    private static final End END = new End();

    private End() {}

    public static End getInstance() {
        return END;
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
