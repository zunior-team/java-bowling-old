package monitor;

import board.BowlingBoard;

import java.util.List;
import java.util.stream.Collectors;

import static monitor.MonitorConstant.*;

public class Monitor {

    public static String enterPlayerName(){
        return InputView.askPlayerName()
                .replaceAll(WHITE_SPACE, EMPTY)
                .trim();
    }

    public static void printBowlingStatusByPlayer(final BowlingBoard bowlingBoard){
        final List<String> lines = bowlingBoard.getBowingStatus()
                .stream()
                .map(line -> BAR + String.join(BAR, line) + BAR)
                .map(String::trim)
                .collect(Collectors.toList());
        OutputView.printStatus(lines);
    }
}
