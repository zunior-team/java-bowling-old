package bowling.frame;

import java.util.ArrayList;
import java.util.List;

public class Frames {
    private final List<Frame> frames;

    private Frames() {
        this.frames = new ArrayList<>();
        this.frames.add(NormalFrame.init());
    }

    public static Frames init() {
        return null;
    }

    public void rollTheBall(final int countOfFallenPins) {
        curFrame().roll(countOfFallenPins);
    }

    private Frame curFrame() {
        return frames.get(frames.size() - 1);
    }
}
