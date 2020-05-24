package bowling.player;

import bowling.dto.PlayerStateDto;

import java.util.List;
import java.util.stream.Collectors;

public class Players {

    private int curPlayerIdx; // nextPlayer = curPlayer + 1 % players.size();
    private final List<Player> players;

    private Players(final List<String> names) {
        validate(names);

        players = names.stream()
                .map(String::trim)
                .map(Player::init)
                .collect(Collectors.toList());
    }

    private void validate(List<String> names) {
        if (names == null || names.isEmpty()) {
            throw new IllegalArgumentException("Player names are null or empty");
        }
    }

    public static Players init(final List<String> names) {
        return new Players(names);
    }

    public void rotatePlayer() {
        curPlayerIdx++;
        curPlayerIdx %= players.size();
    }

    public boolean isGameEnd() {
        return players.stream()
                .allMatch(Player::isGameEnd);
    }

    public Player curPlayer() {
        return players.get(curPlayerIdx);
    }

    public List<PlayerStateDto> getPlayersState() {
        return players.stream()
                .map(PlayerStateDto::of)
                .collect(Collectors.toList());
    }
}
