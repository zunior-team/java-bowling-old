package domain;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.reducing;

public class Frame {
    public static final int MAX_THROW_COUNT_IN_FRAMES = 2;

    private Pins pins;
    private List<Integer> frameHistories = new ArrayList<>();

    private Frame() {
        this.pins = Pins.newInstance();
    }

    public static Frame newInstance() {
        return new Frame();
    }

    public boolean isDone() {
        if (this.pins.isAllDown()) {
            return true;
        }
        return this.frameHistories.size() == MAX_THROW_COUNT_IN_FRAMES;
    }

    public void throwBowlingBall(int fallenPins) {
        if (this.frameHistories.size() > MAX_THROW_COUNT_IN_FRAMES) {
            throw new IllegalArgumentException("you can only throw " + MAX_THROW_COUNT_IN_FRAMES + " times in one frame");
        }

        this.pins.throwBall(fallenPins);

        this.frameHistories.add(fallenPins);
    }

    public FrameResult getFrameResult() {
        return FrameResult.findByThrowCountAndLeftPins(this.frameHistories.size(), this.pins.leftPins());
    }

    public List<Integer> getFrameHistories() {
        return frameHistories;
    }
}
