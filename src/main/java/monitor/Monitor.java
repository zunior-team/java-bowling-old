package monitor;

public class Monitor {

    private static final String WHITE_SPACE = "\\s";
    private static final String EMPTY = "";

    public static String enterPlayerName(){
        return InputView.askPlayerName()
                .replaceAll(WHITE_SPACE, EMPTY)
                .trim();
    }

}
