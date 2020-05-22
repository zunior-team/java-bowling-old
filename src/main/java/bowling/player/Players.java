package bowling.player;

import bowling.utils.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Players {
    private static final String SPLITTER = ",";

    private int curPlayerIdx; // nextPlayer = curPlayer + 1 % players.size();
    private final List<Player> players;

    private Players(final String names) {
        validate(names);

        players = Arrays.stream(names.split(SPLITTER))
                .map(String::trim)
                .map(Player::init)
                .collect(Collectors.toList());
    }

    private void validate(String names) {
        if (StringUtils.isEmpty(names)) {
            throw new IllegalArgumentException("Player names are empty");
        }
    }

    public static Players init(final String names) {
        return new Players(names);
    }

    private void rotatePlayer() {
        curPlayerIdx++;
        curPlayerIdx %= players.size();
    }
}
