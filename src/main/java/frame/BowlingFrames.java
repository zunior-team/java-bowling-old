package frame;

import board.BowlingBoard;
import overturn.OverturnScore;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BowlingFrames {

    private static final int FIRST_NUMBER_OF_FRAME = 1;
    private static final int LAST_NUMBER_OF_FRAME = 10;
    private final AtomicInteger currentFrame = new AtomicInteger(FIRST_NUMBER_OF_FRAME);
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

    public void overturn(final OverturnScore overturnScore){
        final BowlingFrame bowlingFrame = bowlingFrames.get(currentFrame.get());
        bowlingFrame.decreasePins(overturnScore);
    }
}
