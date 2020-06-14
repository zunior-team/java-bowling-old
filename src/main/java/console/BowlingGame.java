package console;

import board.BowlingBoard;
import frame.BowlingFrames;
import frame.FrameNumber;
import model.Result;
import model.Round;
import model.TrialOrder;
import monitor.Monitor;
import overturn.OverturnScore;
import player.Player;

import java.util.stream.IntStream;

import static console.BowlingGameConstant.FIRST_ROUND_NUMBER;
import static console.BowlingGameConstant.LAST_ROUND_NUMBER;

public class BowlingGame {

    public void play() {
        final String name = Monitor.enterPlayerName();
        final BowlingFrames bowlingFrames = BowlingFrames.create();
        final Player player = Player.create(name);
        final BowlingBoard bowlingBoard = bowlingFrames.getBowlingStatusByName(player.getName());

        Monitor.printBowlingStatusByPlayer(bowlingBoard);
        final BowlingGameData bowlingGameData = new BowlingGameData(player, bowlingFrames, bowlingBoard);

        IntStream.rangeClosed(FIRST_ROUND_NUMBER, LAST_ROUND_NUMBER)
                .forEach(round -> playOneRound(bowlingGameData, new Round(round), new TrialOrder(1)));
    }

    private void playOneRound(final BowlingGameData bowlingGameData, final Round round, final TrialOrder trialOrder){
        final FrameNumber frameNumber = round.toFrameNumber();
        final OverturnScore overturnScore = Monitor.enterOverturnPinsForRound(round.getRound(), trialOrder.getOrder());
        final Result result = bowlingGameData.getResultAfterRollTheBall(frameNumber, overturnScore, trialOrder);

        Monitor.printBowlingStatusByPlayer(result.getCurrentBowlingBoard());

        if(result.isNextRound()){
            return;
        }

        if(result.isEnd()){
            return;
        }

        playOneRound(bowlingGameData, round, trialOrder.next());
    }
}
