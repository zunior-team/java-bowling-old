package console;

import board.BowlingBoard;
import frame.BowlingFrames;
import frame.FrameNumber;
import model.Result;
import model.TrialOrder;
import overturn.OverturnScore;
import player.Player;

public class BowlingGameData {
    private final Player player;
    private final BowlingFrames bowlingFrames;
    private final BowlingBoard bowlingBoard;

    public BowlingGameData(final Player player,
                           final BowlingFrames bowlingFrames,
                           final BowlingBoard bowlingBoard){
        this.player = player;
        this.bowlingFrames = bowlingFrames;
        this.bowlingBoard = bowlingBoard;
    }

    public Result getResultAfterRollTheBall(final FrameNumber frameNumber,
                                            final OverturnScore overturnScore,
                                            final TrialOrder trialOrder){

        return bowlingBoard.fillScoreBoard(bowlingFrames.overturnByFrameNumber(overturnScore, frameNumber, trialOrder));
    }
}
