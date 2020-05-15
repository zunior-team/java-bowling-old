package console;

import monitor.Monitor;
import player.Player;

import java.util.stream.IntStream;

import static console.BowlingGameConstant.*;

public class BowlingGame {

    public static void play() {
        final Player player = Player.create(Monitor.enterPlayerName());
        Monitor.printBowlingStatusByPlayer(player.getBowlingBoard());

        IntStream.rangeClosed(FIRST_ROUND_NUMBER, LAST_ROUND_NUMBER)
                .mapToObj(Monitor::enterOverturnPinsForRound)
                .map(player::playBowlingForRound)
                .forEach(System.out::println);
    }
}
