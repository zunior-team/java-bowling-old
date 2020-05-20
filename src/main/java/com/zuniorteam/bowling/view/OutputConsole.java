package com.zuniorteam.bowling.view;

import com.zuniorteam.bowling.core.dto.FrameResultDto;
import com.zuniorteam.bowling.core.dto.StepResultDto;
import com.zuniorteam.bowling.core.user.User;
import com.zuniorteam.bowling.core.value.PinSize;
import com.zuniorteam.bowling.view.render.StepResultRender;

import java.util.List;
import java.util.stream.Collectors;

import static com.zuniorteam.bowling.util.StringUtil.fillToCentered;

public class OutputConsole {

    private static final char BLANK = ' ';
    private static final int EACH_SPACE_LENGTH = 10;
    private static final String BORDER = "|";
    private static final String NEW_LINE = "\n";

    public void writeResult(User user, List<FrameResultDto> frameResults) {
        final String username = user.getUsername();

        for (int index = 0; index < frameResults.size(); index++) {
            System.out.println(writeEachFrameStep(index, frameResults, username));
        }
    }

    private String writeEachFrameStep(int frameIndex, List<FrameResultDto> frameResults, String username) {
        final StringBuilder drawer = new StringBuilder();

        final FrameResultDto frameResult = frameResults.get(frameIndex);
        final List<StepResultDto> stepResults = frameResult.getStepResults();

        for (int stepIndex = 0; stepIndex < stepResults.size(); stepIndex++) {

            final StepResultDto stepResultDto = stepResults.get(stepIndex);

            drawer.append(drawStepInfo(frameIndex, stepResultDto.getFallenPinSize()));
            drawer.append(drawBaseShape(frameResults.size()));
            drawer.append(NEW_LINE);

            drawer.append(drawUsername(username));
            drawer.append(drawFrameUntilIndex(frameResults, frameIndex));
            drawer.append(fillToCentered(drawerStepsUntilIndex(stepResults, stepIndex), BLANK, EACH_SPACE_LENGTH));
            drawer.append(BORDER);

            drawer.append(NEW_LINE);
            drawer.append(NEW_LINE);
        }

        return drawer.toString();
    }


    private String drawStepInfo(int frameIndex, PinSize fallenPinSize) {
        return new StringBuilder()
                .append(frameIndex + 1)
                .append(" 프레임 투구 : ")
                .append(fallenPinSize)
                .append(NEW_LINE)
                .toString();
    }

    private String drawBaseShape(int lengthOfFrame) {
        final StringBuilder drawer = new StringBuilder();

        drawer.append(BORDER)
                .append(fillToCentered("NAME", BLANK, EACH_SPACE_LENGTH))
                .append(BORDER);

        for (int i = 0; i < lengthOfFrame; i++) {
            drawer.append(fillToCentered(String.format("%02d", i + 1), BLANK, EACH_SPACE_LENGTH)).append(BORDER);
        }

        return drawer.toString();
    }

    private String drawUsername(String username) {
        return new StringBuilder()
                .append(BORDER)
                .append(fillToCentered(username, BLANK, EACH_SPACE_LENGTH))
                .append(BORDER)
                .toString();
    }

    private String drawFrameUntilIndex(List<FrameResultDto> frameResults, int frameIndex) {
        final StringBuilder drawer = new StringBuilder();

        for (int i = 0; i < frameIndex; i++) {
            final FrameResultDto frameResultDto = frameResults.get(i);

            final String drawSteps = frameResultDto.getStepResults().stream()
                    .map(StepResultRender::rend)
                    .collect(Collectors.joining(BORDER));

            drawer.append(fillToCentered(drawSteps, BLANK, EACH_SPACE_LENGTH))
                    .append(BORDER);
        }

        return drawer.toString();
    }

    private String drawerStepsUntilIndex(List<StepResultDto> stepResults, int stepIndex) {
        return stepResults.stream()
                .limit(stepIndex + 1)
                .map(StepResultRender::rend)
                .collect(Collectors.joining(BORDER));
    }

}
