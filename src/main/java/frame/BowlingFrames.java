package frame;

import board.BowlingBoard;
import frame.impl.FinalFrame;
import frame.impl.NormalFrame;
import model.FrameResult;
import model.Result;
import model.TrialOrder;
import overturn.OverturnScore;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static frame.BowlingFramesConstant.FIRST_NUMBER_OF_FRAME;
import static frame.BowlingFramesConstant.LAST_NUMBER_OF_FRAME;

public class BowlingFrames {
    private final FrameNumber frameNumber = new FrameNumber(FIRST_NUMBER_OF_FRAME);
    private final List<BowlingFrame> bowlingFrames;

    private BowlingFrames(final List<BowlingFrame> bowlingFrames){
        this.bowlingFrames = bowlingFrames;
    }

    public static BowlingFrames create(){
        return new BowlingFrames(
                Collections.unmodifiableList(
                        IntStream.rangeClosed(1, LAST_NUMBER_OF_FRAME)
                                .mapToObj(i -> (i == LAST_NUMBER_OF_FRAME)
                                        ? new FinalFrame()
                                        : new NormalFrame())
                                .collect(Collectors.toList())));
    }


    public BowlingBoard getBowlingStatusByName(final String name){
        return new BowlingBoard(name, bowlingFrames);
    }

    public Result overturnByFrameNumber(final OverturnScore overturnScore, final FrameNumber frameNumber, final TrialOrder trialOrder){
        final BowlingFrame bowlingFrame = bowlingFrames.get(frameNumber.number());
        final FrameResult frameResult = bowlingFrame.subtractPinsByOverturnPins(overturnScore, trialOrder);
        return new Result(frameNumber, overturnScore, frameResult, trialOrder);
    }
}
