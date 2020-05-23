package bowling.frame;

public class ExtraFrameOfStrike extends Frame {
    protected ExtraFrameOfStrike(int frameNo) {
        super(frameNo);
    }

    @Override
    Frame nextFrame() {
        return null;
    }
}
