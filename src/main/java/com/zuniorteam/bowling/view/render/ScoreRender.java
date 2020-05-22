package com.zuniorteam.bowling.view.render;

import com.zuniorteam.bowling.core.dto.PitchResult;
import com.zuniorteam.bowling.core.value.FrameNumber;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.zuniorteam.bowling.util.StringUtil.fillToCentered;

public class ScoreRender {

    private static final int EACH_SPACE_LENGTH = 10;
    private static final char BLANK = ' ';
    private static final String BORDER = "|";
    private static final String NEW_LINE = "\n";

    public static String rend(String username, List<PitchResult> pitchResults) {

        final StringBuilder drawer = new StringBuilder();

        drawer.append(drawBaseShape());

        drawer.append(NEW_LINE);
        drawer.append(drawUsername(username));
        drawer.append(drawScoreTableData(pitchResults));
        drawer.append(NEW_LINE);
        drawer.append(NEW_LINE);

        return drawer.toString();
    }

    private static String drawBaseShape() {
        final StringBuilder drawer = new StringBuilder();

        drawer.append(BORDER)
                .append(fillToCentered("NAME", BLANK, EACH_SPACE_LENGTH))
                .append(BORDER);

        for (int i = FrameNumber.FIRST_FRAME_NUMBER_VALUE; i <= FrameNumber.LAST_FRAME_NUMBER_VALUE; i++) {
            drawer.append(fillToCentered(String.format("%02d", i), BLANK, EACH_SPACE_LENGTH)).append(BORDER);
        }

        return drawer.toString();
    }

    private static String drawUsername(String username) {
        return new StringBuilder()
                .append(BORDER)
                .append(fillToCentered(username, BLANK, EACH_SPACE_LENGTH))
                .append(BORDER)
                .toString();
    }

    private static String drawScoreTableData(List<PitchResult> pitchResults) {

        final StringBuilder drawer = new StringBuilder();

        Map<FrameNumber, List<String>> scores = new HashMap<>();

        for (int i = FrameNumber.FIRST_FRAME_NUMBER_VALUE; i <= FrameNumber.LAST_FRAME_NUMBER_VALUE; i++) {
            scores.put(FrameNumber.of(i), new ArrayList<>());
        }

        for (PitchResult pitchResult : pitchResults) {
            final FrameNumber frameNumber = pitchResult.getFrameNumber();
            scores.get(frameNumber).add(PitchResultRender.rend(pitchResult.getPitchResultType(), pitchResult.getFallenPinSize()));
        }


        for (FrameNumber frameNumber : scores.keySet()) {
            final String score = String.join(BORDER, scores.get(frameNumber));

            drawer.append(fillToCentered(score, BLANK, EACH_SPACE_LENGTH))
                    .append(BORDER);
        }

        return drawer.toString();
    }
}
