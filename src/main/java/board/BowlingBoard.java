package board;

import frame.BowlingFrame;
import model.Result;

import java.util.ArrayList;
import java.util.List;

public class BowlingBoard {

    private final FrameStatus frameStatus;
    private final ScoreStatus scoreStatus;

    public BowlingBoard(final String name, final List<BowlingFrame> bowlingFrames){
        frameStatus = new FrameStatus();
        scoreStatus = new ScoreStatus(name, bowlingFrames);
    }

    public List<List<String>> getBowingStatus(){
        final List<List<String>> status = new ArrayList<>();
        status.add(frameStatus.getFrameStatus());
        status.add(scoreStatus.getScoreStatus());
        return status;
    }

    public Result fillScoreBoard(final Result result){
        scoreStatus.fillScoreByFrameNumber(result.getCurrentFrameNumber())
                .add(result.getScore());
        return result.attach(this);
    }
}
