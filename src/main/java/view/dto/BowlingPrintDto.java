package view.dto;

import domain.Bowling;
import domain.Player;

import java.util.ArrayList;
import java.util.List;

public class BowlingPrintDto {

    public static final String THREE_SPACE = "   ";
    public static final String NAME = "NAME";
    private static final String FORMAT = "|  %s   |  %s   |  %s   |  %s   |  %s   |  %s   |  %s   |  %s   |  %s   |  %s   |  %s   |";
    public static final String LINE_BREAK = "\n";

    private String header;
    private List<String> frames = new ArrayList<>();
    private Player player;

    public BowlingPrintDto(Bowling bowling) {
        initHeader();
        this.player = bowling.getPlayer();
    }

    private void initHeader() {
        this.header = String.format(
                FORMAT,
                NAME, THREE_SPACE, THREE_SPACE,
                THREE_SPACE, THREE_SPACE, THREE_SPACE,
                THREE_SPACE, THREE_SPACE, THREE_SPACE,
                THREE_SPACE, THREE_SPACE
        );
    }

//    @Override
//    public String toString() {
//        String result = String.format(FORMAT, )
//        return header + LINE_BREAK + result;
//    }
}
