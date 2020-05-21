package bowling.state;

import bowling.pin.Pins;

public class Ready implements State {

    @Override
    public Pins ball(final Pins pins, final int countOfFallenPins) {
        return pins.firstRoll(countOfFallenPins);
    }

    @Override
    public State updateState(final Pins pins) {
        if(pins.isAllFallen()) {
            return new Strike();
        }

        return new SecondTrial();
    }
}
