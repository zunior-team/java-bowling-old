package domain;

public class FinalFrame extends Frame {

    private static final int MAX_THROW_COUNT = 3;

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
        if (MAX_THROW_COUNT == this.frameHistories.size()) {
            return true;
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
