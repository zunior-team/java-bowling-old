package domain.frame.impl;

import domain.frame.Frame;
import domain.frame.Frames;

import static domain.pin.Pins.ZERO;

public class NormalFrame extends Frame {
    private static final int MAX_THROW_COUNT = 2;

    private NormalFrame(int frameNumber) {
        if (frameNumber < ZERO || frameNumber > Frames.MAX_FRAME_COUNT) {
            throw new IllegalArgumentException("생성된 프레임의 숫자가 유효하지 않습니다.");
        }
        this.frameNumber = frameNumber;
    }

    public static NormalFrame newInstanceByFrameNumber(int frameNumber) {
        return new NormalFrame(frameNumber);
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
