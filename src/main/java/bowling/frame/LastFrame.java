package bowling.frame;

import bowling.exception.IllegalTryException;
import bowling.state.GameEnd;
import bowling.state.LastPlaying;

import java.util.List;

public class LastFrame extends Frame {

    protected LastFrame() {
        super(LAST_FRAME_NO);
        state = LastPlaying.init();
    }

    public static LastFrame init() {
        return new LastFrame();
    }

    @Override
    public boolean isGameEnd() {
        return state instanceof GameEnd;
    }

    @Override
    public void appendNextFrame(List<Frame> frames) {
        // do nothing
    }

    @Override
    Frame nextFrame() {
        throw new IllegalTryException();
    }
}
