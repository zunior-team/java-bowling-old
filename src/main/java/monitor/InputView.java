package monitor;

import java.util.Scanner;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final StringBuilder builder = new StringBuilder();

    private InputView(){}

    public static String askPlayerName(){
        System.out.print("플레이어 이름은 (3 english letters) ? : ");
        return SCANNER.nextLine();
    }

    public static int askPinsCountForRound(final int round, final int trial){
        builder.setLength(0); // 초기화
        builder.append(round).append("프레임 투구 : ");
        for(int t = 0; t < trial; t++){
            builder.append("->")
                    .append("\\s")
                    .append(":");
        }
        System.out.print(builder.toString());
        return SCANNER.nextInt();
    }

    public static int askPinsCountForRound(final int round){
        builder.setLength(0); // 초기화
        builder.append(round).append("프레임 투구 : ");

        System.out.print(builder.toString());
        return SCANNER.nextInt();
    }

    public static int askSecondPinsCountForRound(final int round){
        System.out.print(round + " 프레임 투구 : -> : ");
        return SCANNER.nextInt();
    }

    public static int askThirdPinsCountForRound(final int round) {
        System.out.print(round + " 프레임 투구 : -> : -> : ");
        return SCANNER.nextInt();
    }
}
