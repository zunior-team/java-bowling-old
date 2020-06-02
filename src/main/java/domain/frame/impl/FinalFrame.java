package domain.frame.impl;

import domain.frame.Frame;
import domain.frame.Frames;
import domain.pin.Pins;

public class FinalFrame extends Frame {

    private static final int MAX_THROW_COUNT = 3;

    private FinalFrame() {
        this.frameNumber = Frames.MAX_FRAME_COUNT;
    }

    public static FinalFrame newInstance() {
        return new FinalFrame();
    }


    @Override
    public boolean isDone() {
        if (this.frameHistories.size() <= 1) {
            return false;
        }
        if (MAX_THROW_COUNT == this.frameHistories.size()) {
            return true;
        }

        final boolean hasStrike = this.frameHistories.contains(Pins.MAX_NUMBER_OF_PINS);

        if (hasStrike) {
            return false;
        }

        return !this.pins.isAllDown();
    }

    @Override
    public void throwBowlingBall(int fallenPins) {
        if (this.isDone()) {
            throw new IllegalArgumentException("you can not throw more");
        }

        if (this.pins.isAllDown()) {
            this.pins = Pins.newInstance();
        }

        this.pins.throwBall(fallenPins);
        this.frameHistories.add(fallenPins);

    }

}
