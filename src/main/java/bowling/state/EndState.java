package bowling.state;

import bowling.exception.IllegalTryException;

public abstract class EndState extends State {

    @Override
    public State downPins(int numOfDownPins) {
        throw new IllegalTryException();
    }

    @Override
    public boolean isEnd() {
        return true;
    }

}
