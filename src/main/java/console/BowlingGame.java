package console;

import monitor.Monitor;
import player.Player;

public class BowlingGame {

    public static void play() {
        final Player player = Player.create(Monitor.enterPlayerName());
        Monitor.printBowlingStatusByPlayer(player);
    }
}
