package bowling.frame;

import java.util.List;

public class ExtraFrame extends Frame {
    public ExtraFrame() {
        super(11);
    }

    @Override
    void appendNextFrame(List<Frame> frames) {

    }

    @Override
    Frame nextFrame() {
        return null;
    }
}
