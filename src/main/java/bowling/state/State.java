package bowling.state;

import bowling.pin.Pins;

public interface State {
    Pins ball(final Pins pins, final int countOfFallenPins);
    State updateState(final Pins pins);
}
