package bowling.frame;

import bowling.exception.IllegalTryException;

import java.util.List;

public class ExtraFrame extends Frame {
    public ExtraFrame() {
        super(11);
    }

    public static ExtraFrame init() {
        return new ExtraFrame();
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
