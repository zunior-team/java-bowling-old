package domain.frame.impl;

import domain.frame.Frame;

public class NormalFrame extends Frame {
    private static final int MAX_THROW_COUNT = 2;

    private NormalFrame() {
    }

    public static NormalFrame newInstance() {
        return new NormalFrame();
    }


    @Override
    public boolean isDone() {
        if (this.pins.isAllDown()) {
            return true;
        }
        return this.frameHistories.size() == MAX_THROW_COUNT;
    }

    @Override
    public void throwBowlingBall(int fallenPins) {
        if (this.frameHistories.size() + 1 > MAX_THROW_COUNT) {
            throw new IllegalArgumentException("you can only throw " + MAX_THROW_COUNT + " times in one frame");
        }

        this.pins.throwBall(fallenPins);

        this.frameHistories.add(fallenPins);
    }

}
