package domain;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Frames {
    private List<Frame> frames = new ArrayList<>();

    private Frames() {
    }

    public static Frames empty() {
        return new Frames();
    }

    public boolean isEnd() {
        if (this.frames.isEmpty()) {
            return false;
        }
        return frames.size() == 10 && frames.get(frames.size() - 1).isDone();
    }

    public int nextFrame() {
        if (frames.isEmpty()) {
            return 1;
        }
        if (frames.get(frames.size() - 1).isDone()) {
            return frames.size() + 1;
        }
        return frames.size();
    }


    public void throwBowlingBall(int inputFallenPins) {
        if (frames.isEmpty() || frames.get(frames.size() - 1).isDone()) {
            this.frames.add(Frame.newInstanceByFirstThrow(inputFallenPins));
            return;
        }

        this.frames.get(frames.size() - 1).throwBowlingBall(inputFallenPins);
    }

    public List<Frame> getFrames() {
        return Collections.unmodifiableList(new ArrayList<>(this.frames));
    }
}
