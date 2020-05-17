package view;

import java.util.Objects;
import java.util.Scanner;

import static domain.Player.NAME_LENGTH;

public class InputView {
    private final Scanner scanner;

    public InputView(Scanner scanner) {
        Objects.requireNonNull(scanner);
        this.scanner = scanner;
    }

    public String inputPlayerName() {
        return scanner.nextLine();
    }

    public int inputFallenPins() {
        return Integer.parseInt(scanner.nextLine());
    }
}
