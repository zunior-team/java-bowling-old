package bowling.state;

import bowling.pin.Pins;

public class End implements EndState {
    @Override
    public Pins ball(Pins pins, int countOfFallenPins) {
        return null;
    }

    @Override
    public State updateState(Pins pins) {
        return null;
    }
}
