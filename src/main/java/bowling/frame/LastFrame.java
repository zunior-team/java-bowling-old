package bowling.frame;

public class LastFrame extends Frame {
    private ExtraFrame extraFrame; // extra frame을 둘 것인가 아니면 추가 핀을 둘것인가..

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
