package bowling.frame;

import bowling.exception.IllegalTryException;
import bowling.state.Strike;

import java.util.List;

public class LastFrame extends Frame {
    private ExtraFrame extraFrame; // extra frame을 둘 것인가 아니면 추가 핀을 둘것인가..

    protected LastFrame(int frameNo) {
        super(frameNo);
    }

    @Override
    public void roll(int countOfFallenPins) {
        super.roll(countOfFallenPins);

        if (isStrike()) {
            extraFrame = ExtraFrame.init();
        }
    }

    @Override
    public boolean isLastFrame() {
        return !isStrike();
    }

    private boolean isStrike() {
        return state instanceof Strike;
    }

    // strike 이면 extraFrame에 위임
    @Override
    public boolean isFrameEnd() {
        if (isStrike()) {
            return extraFrame.isFrameEnd();
        }

        return super.isFrameEnd();
    }

    @Override
    public boolean isGameEnd() {
        return super.isGameEnd();
    }

    @Override
    public void appendNextFrame(List<Frame> frames) {
        throw new IllegalTryException();
    }

    @Override
    Frame nextFrame() {
        throw new IllegalTryException();
    }
}
