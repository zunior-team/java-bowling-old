package bowling.frame;

import bowling.state.Strike;

import java.util.List;

public class LastFrame extends Frame {
    private ExtraFrame extraFrame;

    protected LastFrame(int frameNo) {
        super(frameNo);
    }

    @Override
    boolean isLastFrame() {
        return !(state instanceof Strike);
    }

    @Override
    void appendNextFrame(List<Frame> frames) {
        frames.add(nextFrame());
    }

    @Override
    Frame nextFrame() {
        return new ExtraFrame();
    }
}
