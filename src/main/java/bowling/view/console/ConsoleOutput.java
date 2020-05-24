package bowling.view.console;

import bowling.dto.PlayerStateDto;
import bowling.view.StateFormat;

import java.util.List;
import java.util.stream.IntStream;

import static bowling.frame.Frame.BASE_FRAME_NO;
import static bowling.frame.Frame.LAST_FRAME_NO;

public class ConsoleOutput {
    private static final String FRAME_FORMAT = "  %-3s |";
    private static final String NAME_FORMAT = "| %4s |";
    private static final String NUMBER_FORMAT = "  %02d  |";
    private static final String CUR_PAYER_STATE_FORMAT = "%d프레임 투구 :";
    private static final String EMPTY_STR = "";

    private ConsoleOutput() {}

    public static void showCurPlayer(final PlayerStateDto player) {
        System.out.print(String.format(CUR_PAYER_STATE_FORMAT, player.getCurFrameNo()));
    }

    public static void showScoreBoard(final List<PlayerStateDto> playersState) {
        showHeader();
        showPlayers(playersState);
        newLine();
    }

    private static void showHeader() {
        System.out.print(String.format(NAME_FORMAT, "NAME"));

        IntStream.rangeClosed(BASE_FRAME_NO, LAST_FRAME_NO)
                .forEach(no -> System.out.print(String.format(NUMBER_FORMAT, no)));

        newLine();
    }

    private static void showPlayers(final List<PlayerStateDto> playersState) {
        playersState.forEach(ConsoleOutput::ShowPlayer);
    }

    private static void ShowPlayer(final PlayerStateDto playerState) {
        System.out.print(String.format(NAME_FORMAT, playerState.getName()));

        playerState.getStates()
                .stream()
                .map(StateFormat::of)
                .forEach(state -> System.out.print(String.format(FRAME_FORMAT, state)));

        IntStream.range(playerState.getCurFrameNo(), LAST_FRAME_NO)
                .forEach(noStr -> System.out.print(String.format(FRAME_FORMAT, EMPTY_STR)));

        newLine();
    }

    private static void newLine() {
        System.out.println();
    }
}
