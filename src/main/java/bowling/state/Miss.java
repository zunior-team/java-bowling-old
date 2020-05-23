package bowling.state;

import bowling.exception.IllegalTryException;
import bowling.frame.Frame;

public class Miss extends State implements EndState {
    private static final Miss MISS = new Miss();

    private Miss() {}

    public static Miss getInstance() {
        return MISS;
    }

    @Override
    public void downPins(Frame frame, int numOfDownPins) {
        throw new IllegalTryException();
    }
}
