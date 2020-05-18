package view;

import domain.Frame;
import domain.Player;
import view.dto.BowlingPrintDto;

import java.util.List;

import static domain.Player.NAME_LENGTH;
import static java.util.stream.Collectors.*;

public class OutputView {
    public static final String THREE_SPACE = "   ";
    public static final String NAME = "NAME";
    private static final String FORMAT = "|  %s   |  %s   |  %s   |  %s   |  %s   |  %s   |  %s   |  %s   |  %s   |  %s   |  %s   |";
    public static final String LINE_BREAK = "\n";

    public void printInputPlayerNameMessage() {
        System.out.println("플레이어 이름은(" + NAME_LENGTH + " english letters)?: ");
    }

    public void printInputFallenPinsMessageOf(int nextFrame) {
        System.out.println(nextFrame + " 프레임 투구 : ");
    }

    public void printBowling(BowlingPrintDto dto) {
        printHeader();
        printResult(dto.getPlayer(), dto.getFrames());
    }


    private void printHeader() {
        System.out.println(
                String.format(
                        FORMAT,
                        NAME, THREE_SPACE, THREE_SPACE,
                        THREE_SPACE, THREE_SPACE, THREE_SPACE,
                        THREE_SPACE, THREE_SPACE, THREE_SPACE,
                        THREE_SPACE, THREE_SPACE
                )
        );
    }

    private void printResult(Player player, List<Frame> frames) {
        final List<String> parsedFrames = frames.stream()
                .map(FrameResultFormatParser::parse)
                .collect(toList());

        while (parsedFrames.size() != 10) {
            parsedFrames.add(THREE_SPACE);
        }

        System.out.println(
                String.format(
                        FORMAT,
                        " " + player, parsedFrames.get(0), parsedFrames.get(1),
                        parsedFrames.get(2), parsedFrames.get(3), parsedFrames.get(4),
                        parsedFrames.get(5), parsedFrames.get(6), parsedFrames.get(7),
                        parsedFrames.get(8), parsedFrames.get(9)
                )
        );
    }
}
