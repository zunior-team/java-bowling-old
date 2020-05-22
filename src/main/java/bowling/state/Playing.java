package bowling.state;

import bowling.frame.Frame;

public class Playing extends State {
    private static final Playing PLAYING = new Playing();

    private Playing() {}

    public static Playing getInstance() {
        return PLAYING;
    }

    @Override
    void internalProcess(Frame frame, int countOfFallenPins) {

    }

    @Override
    void updateState(Frame frame) {
        if (frame.isPinLeft()) {
            frame.updateState(End.getInstance());
            return;
        }

        frame.updateState(Spare.getInstance());
    }
}
