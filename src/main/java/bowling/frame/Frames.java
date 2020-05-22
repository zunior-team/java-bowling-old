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
        return new Frames();
    }

    public void rollTheBall(final int countOfFallenPins) {
        curFrame().roll(countOfFallenPins);

        if(curFrame().isFrameEnd()) {
            curFrame().appendNextFrame(frames);
        }
    }

    private Frame curFrame() {
        return frames.get(frames.size() - 1);
    }
}
