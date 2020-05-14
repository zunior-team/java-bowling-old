package monitor;

import player.Player;

import static monitor.MonitorConstant.EMPTY;
import static monitor.MonitorConstant.WHITE_SPACE;

public class Monitor {

    public static String enterPlayerName(){
        return InputView.askPlayerName()
                .replaceAll(WHITE_SPACE, EMPTY)
                .trim();
    }

    public static void printBowlingStatusByPlayer(final Player player){
//        new BowlingStatusDto(player);
    }
}
