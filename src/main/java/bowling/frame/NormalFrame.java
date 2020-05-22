package bowling.frame;

public class NormalFrame extends Frame {

    private NormalFrame(final int frameNo) {
        super(frameNo);
    }

    @Override
    Frame nextFrame() {
        if(frameNo == 9) {
            return new LastFrame(10);
        }

        return new NormalFrame(frameNo + 1);
    }

    public static Frame init() {
        return new NormalFrame(BASE_FRAME_NO);
    }
}
