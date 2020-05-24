package bowling.frame;

import bowling.state.State;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Frames {
    private final List<Frame> frames;

    private Frames() {
        this.frames = new ArrayList<>();
        this.frames.add(NormalFrame.init());
    }

    public static Frames init() {
        return new Frames();
    }

    public void rollTheBall(final int countOfFallenPins) {
        curFrame().rollTheBall(countOfFallenPins);

        if(curFrame().isFrameEnd()) {
            curFrame().appendNextFrame(frames);
        }
    }

    private Frame curFrame() {
        return frames.get(frames.size() - 1);
    }

    public boolean isAllFrameEnd() {
        return curFrame().isGameEnd();
    }

    public List<State> getStates() {
        return frames.stream()
                .map(Frame::getState)
                .collect(Collectors.toList());
    }
}
