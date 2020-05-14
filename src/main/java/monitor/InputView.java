package monitor;

import java.util.Scanner;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);

    private InputView(){}

    public static String askPlayerName(){
        System.out.println("플레이어 이름은 (3 english letters) ? :");
        return SCANNER.nextLine();
    }
}
