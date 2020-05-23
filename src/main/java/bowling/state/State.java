package bowling.state;

import bowling.frame.Frame;

public abstract class State {

    public abstract void downPins(final Frame frame, final int numOfDownPins);
}
