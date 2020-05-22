package bowling.state;

import bowling.exception.IllegalTryException;
import bowling.frame.Frame;

public class End extends State implements EndState {
    private static final End END = new End();

    private End() {}

    public static End getInstance() {
        return END;
    }

    @Override
    void internalProcess(Frame frame, int countOfFallenPins) {
        throw new IllegalTryException();
    }

    @Override
    void updateState(Frame frame) {}
}
