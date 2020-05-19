package domain;

public class NormalFrame extends Frame {
    private final int maxThrowCount = 2;

    private NormalFrame() {
        super();
    }

    public static NormalFrame newInstance() {
        return new NormalFrame();
    }


    @Override
    public boolean isDone() {
        if (this.pins.isAllDown()) {
            return true;
        }
        return this.frameHistories.size() == maxThrowCount;
    }

    @Override
    public void throwBowlingBall(int fallenPins) {
        if (this.frameHistories.size() + 1 > maxThrowCount) {
            throw new IllegalArgumentException("you can only throw " + maxThrowCount + " times in one frame");
        }

        this.pins.throwBall(fallenPins);

        this.frameHistories.add(fallenPins);
    }

}
