package view;

import domain.frame.Frame;
import domain.player.Player;
import view.dto.BowlingPrintDto;

import java.util.List;

import static domain.player.Player.NAME_LENGTH;
import static java.util.stream.Collectors.toList;

public class OutputView {
    public static final String THREE_SPACE = "   ";
    public static final String NAME = "NAME";
    private static final String FORMAT = "|  %s   |  %s   |  %s   |  %s   |  %s   |  %s   |  %s   |  %s   |  %s   |  %s   |  %s   |";

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
                        NAME, " 1 ", " 2 ",
                        " 3 ", " 4 ", " 5 ",
                        " 6 ", " 7 ", " 8 ",
                        " 9 ", " 10 "
                )
        );
    }

    private void printResult(Player player, List<Frame> frames) {
        final List<String> parsedFrames = frames.stream()
                .map(Frame::getFrameHistories)
                .map(FrameHistoryParser::parse)
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
