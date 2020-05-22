package bowling.state;

import bowling.frame.Frame;

public abstract class State {

    public void ball(final Frame frame, final int countOfFallenPins) {
        internalProcess(frame, countOfFallenPins);
        updateState(frame);
    }

    abstract void internalProcess(final Frame frame, final int countOfFallenPins);

    abstract void updateState(final Frame frame);
}
