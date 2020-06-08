package console;

import board.BowlingBoard;
import frame.BowlingFrames;
import player.Player;

public class BowlingGameData {
    private Player player;
    private BowlingFrames bowlingFrames;
    private BowlingBoard bowlingBoard;

    public BowlingGameData(final Player player,
                           final BowlingFrames bowlingFrames,
                           final BowlingBoard bowlingBoard){
        this.player = player;
        this.bowlingFrames = bowlingFrames;
        this.bowlingBoard = bowlingBoard;
    }
}
