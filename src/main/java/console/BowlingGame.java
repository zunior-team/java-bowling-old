package console;

import monitor.Monitor;
import player.Player;

public class BowlingGame {

    private static final int FIRST_ROUND_NUMBER = 1;
    private static final int LAST_ROUND_NUMBER = 10;

    public static void play() {
        final Player player = Player.create(Monitor.enterPlayerName());
        Monitor.printBowlingStatusByPlayer(player.getBowlingBoard());


    }
}
