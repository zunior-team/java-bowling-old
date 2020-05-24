package bowling;

import bowling.dto.PlayerStateDto;
import bowling.player.Player;
import bowling.player.Players;

import java.util.List;

// 없어도 될 클래스지만 논리적 표현을 위해
public class Bowling {
    private final Players players;

    private Bowling(final List<String> names) {
        players = Players.init(names);
    }

    public static Bowling init(final List<String> names) {
        return new Bowling(names);
    }

    public boolean isGameEnd() {
        return players.isGameEnd();
    }

    public Player curPlayer() {
        return players.curPlayer();
    }

    public void rotatePlayer() {
        players.rotatePlayer();
    }

    public List<PlayerStateDto> getPlayersState() {
        return players.getPlayersState();
    }
}
