package bowling;

import bowling.player.Player;
import bowling.player.Players;

// 없어도 될 클래스
public class Bowling {
    private final Players players;

    private Bowling(final String names) {
        players = Players.init(names);
    }

    public static Bowling init(final String names) {
        return new Bowling(names);
    }

    public boolean isGameEnd() {
        return players.isGameEnd();
    }

    public Player curPlayer() {
        return players.curPlayer();
    }
}
