package bowling.frame;

public class LastFrame extends Frame {

    protected LastFrame(int frameNo) {
        super(frameNo);
    }

    @Override
    public void rollTheBall(int countOfFallenPins) {
        super.rollTheBall(countOfFallenPins);
    }

    @Override
    Frame nextFrame() {
        return null;
    }

    // strike 이면 extraFrame에 위임
}
