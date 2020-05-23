package bowling.state;

import java.util.List;

public abstract class State {

    public abstract State downPins(final int numOfDownPins);

    public abstract List<Integer> getDownPins();

    public boolean isEnd() {
        return false;
    }

    protected boolean isMiss(final State state) {
        return state instanceof Miss;
    }

    protected boolean isStrike(final State state) {
        return state instanceof Strike;
    }

    protected boolean isSpare(final State state) {
        return state instanceof Spare;
    }

}
