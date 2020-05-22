package bowling.frame;

import bowling.pin.Pins;
import bowling.state.EndState;
import bowling.state.Ready;
import bowling.state.State;

import java.util.List;

public abstract class Frame {
    protected static final int BASE_FRAME_NO = 1;

    protected int frameNo;
    protected Pins pins;
    protected State state;

    protected Frame(final int frameNo) {
        this.frameNo = frameNo;
        this.pins = Pins.init();
        this.state = new Ready();
    }

    void roll(final int countOfFallenPins) {
        pins = state.ball(pins, countOfFallenPins);
        state = state.updateState(pins);
    }

    boolean isEnd() {
        return state instanceof EndState;
    }

    boolean isLastFrame() {
        return false;
    }

    abstract void appendNextFrame(final List<Frame> frames);
    abstract Frame nextFrame();
}
