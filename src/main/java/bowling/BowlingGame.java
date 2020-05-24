package bowling;

import bowling.dto.PlayerStateDto;
import bowling.player.Player;
import bowling.view.console.ConsoleInput;
import bowling.view.console.ConsoleOutput;

import java.util.List;

public class BowlingGame {
    public static void main(String[] args) {
        List<String> names = ConsoleInput.inputPlayers();

        Bowling bowling = Bowling.init(names);
        ConsoleOutput.showScoreBoard(bowling.getPlayersState());

        while(!bowling.isGameEnd()) {
            Player curPlayer = bowling.curPlayer();
            ConsoleOutput.showCurPlayer(PlayerStateDto.of(curPlayer));

            int numOfDownPins = ConsoleInput.inputDownPins();
            curPlayer.play(numOfDownPins);

            ConsoleOutput.showScoreBoard(bowling.getPlayersState());

            bowling.rotatePlayer();
        }
    }
}
