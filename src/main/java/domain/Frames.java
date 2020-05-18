package domain;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Frames {
    public static final int MAX_FRAME_COUNT = 10;
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
        return frames.size() == MAX_FRAME_COUNT && frames.get(frames.size() - 1).isDone();
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
            final Frame frame = Frame.newInstance();
            frame.throwBowlingBall(inputFallenPins);
            this.frames.add(frame);
            return;
        }

        this.frames.get(frames.size() - 1).throwBowlingBall(inputFallenPins);
    }

    public List<Frame> getFrames() {
        return Collections.unmodifiableList(new ArrayList<>(this.frames));
    }

}
