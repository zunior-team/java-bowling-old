package console;

import monitor.Monitor;
import player.Player;

public class BowlingGame {

    public static final Monitor MONITOR = new Monitor();

    public static void play() {
        Player player = Player.create(MONITOR.enterPlayerName());
    }
}
