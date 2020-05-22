package bowling.state;

import bowling.frame.Frame;

public class Spare implements EndState {
    private static final Spare SPARE = new Spare();

    private Spare() {}

    public static State getInstance() {
        return SPARE;
    }

    @Override
    public void ball(Frame frame, int countOfFallenPins) {


    }
}
