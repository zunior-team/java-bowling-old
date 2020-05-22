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
        this.state = Ready.getInstance();
    }

    public void roll(final int countOfFallenPins) {
        state.ball(this, countOfFallenPins);
    }

    public boolean isPinLeft() {
        return pins.isPinLeft();
    }

    public void updateState(final State state) {
        validate(state);

        this.state = state;
    }

    private void validate(State state) {
        if (state == null) {
            throw new IllegalArgumentException("State can't be a null");
        }
    }

    public boolean isFrameEnd() {
        return state instanceof EndState;
    }

    public boolean isGameEnd() {
        return false;
    }

    public boolean isLastFrame() {
        return false;
    }

    public void appendNextFrame(final List<Frame> frames) {
        frames.add(nextFrame());
    }

    abstract Frame nextFrame();
}
