package console;

import board.BowlingBoard;
import frame.BowlingFrames;
import model.Round;
import model.Trial;
import monitor.Monitor;
import overturn.OverturnScore;
import player.Player;
import trial.TrialResultType;

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
                .forEach(round -> playOneRound(bowlingGameData, new Round(round), new Trial(1)));
    }

    private void playOneRound(final BowlingGameData bowlingGameData, final Round round, final Trial trial){
        final OverturnScore overturnScore = Monitor.enterOverturnPinsForRound(round.getRound(), trial.getTrial());

    }

    private void playOneRound(final Player player, final int round){
        final OverturnScore overTurnScore = Monitor.enterOverturnPinsForRound(round, 0);

        final TrialResultType resultType = player.playBowlingForRound(overTurnScore);
        Monitor.printBowlingStatusByPlayer(player.getBowlingBoard());

        if(!resultType.isProgress() && round != LAST_ROUND_NUMBER){
            return;
        }

        final OverturnScore secondOverTurnScore = Monitor.enterSecondOverturnPinsForRound(round);
        final TrialResultType secondTrialResultType = player.playBowlingForRound(secondOverTurnScore);
        Monitor.printBowlingStatusByPlayer(player.getBowlingBoard());

        if(!secondTrialResultType.isBonus()){
            return;
        }

        final OverturnScore lastOverturnScore = Monitor.enterThirdOverturnPinsForRound(round);
        final TrialResultType lastTrialResultType = player.playBowlingForRound(lastOverturnScore);
        Monitor.printBowlingStatusByPlayer(player.getBowlingBoard());
    }
}
