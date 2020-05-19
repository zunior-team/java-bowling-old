package domain;

public class FinalFrame extends Frame {

    private final int maxThrowCount = 3;

    private FinalFrame() {
        super();
    }

    public static FinalFrame newInstance() {
        return new FinalFrame();
    }


    @Override
    public boolean isDone() {
        if (this.frameHistories.size() <= 1) {
            return false;
        }
        if (this.maxThrowCount == this.frameHistories.size()) {
            return true;
        }

        return !this.pins.isAllDown();
    }

    @Override
    public void throwBowlingBall(int fallenPins) {
        if (this.frameHistories.size() + 1 > maxThrowCount) {
            throw new IllegalArgumentException("you can only throw " + maxThrowCount + " times in one frame");
        }
        if (this.pins.isAllDown()) {
            this.pins = Pins.newInstance();
        }

        this.pins.throwBall(fallenPins);
        this.frameHistories.add(fallenPins);
    }

}
