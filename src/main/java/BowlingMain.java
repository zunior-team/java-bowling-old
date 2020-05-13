import domain.Player;
import view.InputView;

import java.util.Scanner;

public class BowlingMain {
    private BowlingMain() {
    }

    public static void main(String[] args) {
        final InputView inputView = new InputView(new Scanner(System.in));

        final String name = inputView.inputPlayerName();

        final Player player = Player.of(name);


    }
}
