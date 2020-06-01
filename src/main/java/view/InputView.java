package view;

import java.util.Objects;
import java.util.Scanner;

public class InputView {
    private final Scanner scanner;

    public InputView(Scanner scanner) {
        Objects.requireNonNull(scanner, "Scanner cannot be null");
        this.scanner = scanner;
    }

    public String inputPlayerName() {
        return scanner.nextLine();
    }

    public int inputFallenPins() {
        return Integer.parseInt(scanner.nextLine());
    }
}
