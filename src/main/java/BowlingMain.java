import domain.Bowling;
import domain.Player;
import view.InputView;
import view.OutputView;
import view.dto.BowlingPrintDto;

import java.util.Scanner;

public class BowlingMain {
    private BowlingMain() {
    }

    public static void main(String[] args) {
        final InputView inputView = new InputView(new Scanner(System.in));
        final OutputView outputView = new OutputView();

        outputView.printInputPlayerNameMessage();
        final String name = inputView.inputPlayerName();

        final Player player = Player.of(name);


        final Bowling bowling = Bowling.newInstance(player);

        while (!bowling.isEnd()) {
            outputView.printInputFallenPinsMessageOf(bowling.nextFrame());
            bowling.throwBowlingBall(inputView.inputFallenPins());
        }


        new BowlingPrintDto(bowling);



    }
}
