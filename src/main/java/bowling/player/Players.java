package bowling.player;

import java.util.List;

public class Players {
    private int curPlayerIndex; // nextPlayer = curPlayer + 1 % players.size();
    private List<Player> players;

    private void rotatePlayer() {
        curPlayerIndex++;
        curPlayerIndex %= players.size();
    }
}
