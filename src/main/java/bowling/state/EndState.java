package bowling.state;

import bowling.exception.IllegalTryException;
import bowling.pin.Pin;

public abstract class EndState extends State {

    @Override
    public State downPins(final Pin numOfDownPins) {
        throw new IllegalTryException();
    }

    @Override
    public boolean isEnd() {
        return true;
    }

}
