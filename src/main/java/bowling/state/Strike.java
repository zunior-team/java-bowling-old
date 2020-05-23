package bowling.state;

import bowling.frame.Frame;

public class Strike extends State implements EndState {
    private static final Strike STRIKE = new Strike();

    private Strike() {}

    public static State getInstance() {
        return STRIKE;
    }

    @Override
    public void downPins(Frame frame, int numOfDownPins) {

    }

    @Override
    public void updateState(Frame frame) {

    }
}
