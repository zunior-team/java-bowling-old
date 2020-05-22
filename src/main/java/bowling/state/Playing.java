package bowling.state;

import bowling.pin.Pins;

public class Playing implements State {
    private static final Playing PLAYING = new Playing();

    private Playing() {}

    public static Playing getInstance() {
        return PLAYING;
    }

    @Override
    public Pins ball(Pins pins, int countOfFallenPins) {
        return pins.secondRoll(countOfFallenPins);
    }

    @Override
    public State updateState(Pins pins) {
        if(pins.isAllFallen()) {
            return Spare.getInstance();
        }

        return End.getInstance();
    }
}
