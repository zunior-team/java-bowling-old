package bowling.frame;

public class ExtraFrameOfSpare extends Frame {
    protected ExtraFrameOfSpare(int frameNo) {
        super(frameNo);
    }

    @Override
    Frame nextFrame() {
        return null;
    }
}
