package console;

import monitor.Monitor;
import overturn.OverturnScore;
import player.Player;
import trial.TrialResultType;

import java.util.stream.IntStream;

import static console.BowlingGameConstant.*;

public class BowlingGame {

    public static void play() {
        final Player player = Player.create(Monitor.enterPlayerName());
        Monitor.printBowlingStatusByPlayer(player.getBowlingBoard());

        IntStream.rangeClosed(FIRST_ROUND_NUMBER, LAST_ROUND_NUMBER)
                .forEach(round -> playBowling(player, round));
    }

    private static void playBowling(final Player player, final int round){
        final OverturnScore overTurnScore = Monitor.enterOverturnPinsForRound(round);
        final TrialResultType resultType = player.playBowlingForRound(overTurnScore);
        Monitor.printBowlingStatusByPlayer(player.getBowlingBoard());

        if(!resultType.isProgress()){
            return;
        }

        final OverturnScore secondOverTurnScore = Monitor.enterSecondOverturnPinsForRound(round);
        final TrialResultType secondTrialResultType = player.playBowlingForRound(secondOverTurnScore);
        Monitor.printBowlingStatusByPlayer(player.getBowlingBoard());
    }
}
