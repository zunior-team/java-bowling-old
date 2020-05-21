package bowling.state;

import bowling.pin.Pins;

public class SecondTrial implements State {
    @Override
    public Pins ball(Pins pins, int countOfFallenPins) {
        return pins.secondRoll(countOfFallenPins);
    }

    @Override
    public State updateState(Pins pins) {
        if(pins.isAllFallen()) {
            return new Spare();
        }

        return new End();
    }
}
