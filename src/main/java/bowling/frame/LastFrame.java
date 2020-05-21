package bowling.frame;

import bowling.state.Strike;

public class LastFrame extends Frame {
    protected LastFrame(int frameNo) {
        super(frameNo);
    }

    @Override
    boolean isLastFrame() {
        return !(state instanceof Strike);
    }
}
