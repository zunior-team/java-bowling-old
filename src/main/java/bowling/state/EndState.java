package bowling.state;

import bowling.exception.IllegalTryException;
import bowling.frame.Frame;

// just a marker interface
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
