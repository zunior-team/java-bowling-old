package frame;

import board.BowlingBoard;
import frame.impl.FinalFrame;
import frame.impl.NormalFrame;
import overturn.OverturnScore;
import trial.TrialResultType;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

    public Map<FrameNumber, TrialResultType> overturn(final OverturnScore overturnScore){
        final BowlingFrame bowlingFrame = frameNumber.getCurrentBowlingFrame(bowlingFrames);
        final TrialResultType resultType = bowlingFrame.decreasePins(overturnScore);

        @SuppressWarnings("unchecked")
        final Map<FrameNumber, TrialResultType> results = Collections.unmodifiableMap(new HashMap(){{put(frameNumber.newInstance(), resultType);}});
        frameNumber.increaseByTrialType(resultType);

        return results;
    }
}
