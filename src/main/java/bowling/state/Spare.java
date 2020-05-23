package bowling.state;

import bowling.frame.Frame;

public class Spare extends State implements EndState {
    private static final Spare SPARE = new Spare();

    private Spare() {}

    public static State getInstance() {
        return SPARE;
    }

    public static boolean isSpare(final State state) {
        return SPARE == state;
    }

    @Override
    public void downPins(Frame frame, int numOfDownPins) {

    }

    @Override
    void updateState(Frame frame) {

    }
}
