package bowling;

import bowling.player.Player;

public class BowlingGame {
    public static void main(String[] args) {
        String names = "";

        Bowling bowling = Bowling.init(names);
        // show score board

        while(!bowling.isGameEnd()) {
            Player curPlayer = bowling.curPlayer();

            int numOfDownPins = 10;

            curPlayer.play(numOfDownPins);
            // show score board
        }
    }
}
