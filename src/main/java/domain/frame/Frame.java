package domain.frame;

import domain.pin.Pins;

import java.util.ArrayList;
import java.util.List;

public abstract class Frame {
    protected Pins pins;
    protected List<Integer> frameHistories = new ArrayList<>();

    public Frame() {
        this.pins = Pins.newInstance();
    }

    public abstract boolean isDone();

    public abstract void throwBowlingBall(int fallenPins);

    public List<Integer> getFrameHistories() {
        return frameHistories;
    }
}
