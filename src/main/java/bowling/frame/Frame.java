package bowling.frame;

import bowling.state.EndState;
import bowling.state.Ready;
import bowling.state.State;

import java.util.List;

public abstract class Frame {
    public static final int BASE_FRAME_NO = 1;
    public static final int LAST_FRAME_NO = 10;

    protected int frameNo;
    protected State state;

    protected Frame(final int frameNo) {
        this.frameNo = frameNo;
        this.state = Ready.getInstance();
    }

    public void rollTheBall(final int countOfFallenPins) {
        state = state.downPins(countOfFallenPins);
    }

    public boolean isFrameEnd() {
        return state instanceof EndState;
    }

    public boolean isGameEnd() {
        return false;
    }

    public void appendNextFrame(final List<Frame> frames) {
        frames.add(nextFrame());
    }

    abstract Frame nextFrame();

    public State getState() {
        return state;
    }
}
