package bowling.state;

import bowling.frame.Frame;

public class Strike extends State implements EndState {
    private static final Strike STRIKE = new Strike();

    private Strike() {}

    public static State getInstance() {
        return STRIKE;
    }

    @Override
    void internalProcess(Frame frame, int countOfFallenPins) {

    }

    @Override
    public void updateState(Frame frame) {

    }
}
