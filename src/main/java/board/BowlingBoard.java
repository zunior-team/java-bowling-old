package board;

import frame.BowlingFrame;

import java.util.List;

public class BowlingBoard {

    private final FrameStatus frameStatus;
    private final ScoreStatus scoreStatus;

    public BowlingBoard(final String name, final List<BowlingFrame> bowlingFrames){
        frameStatus = new FrameStatus();
        scoreStatus = new ScoreStatus(name);
    }
}
