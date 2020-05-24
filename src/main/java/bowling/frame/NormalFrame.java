package bowling.frame;

public class NormalFrame extends Frame {

    private NormalFrame(final int frameNo) {
        super(frameNo);
    }

    @Override
    Frame nextFrame() {
        int nextFrameNo = frameNo + 1;

        if(nextFrameNo == LAST_FRAME_NO) {
            return LastFrame.init();
        }

        return new NormalFrame(nextFrameNo);
    }

    public static Frame init() {
        return new NormalFrame(BASE_FRAME_NO);
    }
}
