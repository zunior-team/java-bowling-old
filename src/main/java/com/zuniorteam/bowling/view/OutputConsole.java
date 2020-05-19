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

    public void writeResult(User user, List<FrameResultDto> frameResultDtos) {
        final String username = user.getUsername();

        for (int index = 0; index < frameResultDtos.size(); index++) {
            System.out.println(writeEachFrameStep(index, frameResultDtos, username));
        }
    }

    private String writeEachFrameStep(int frameIndex, List<FrameResultDto> frameResultDtos, String username) {
        StringBuilder draw = new StringBuilder();

        final FrameResultDto frameResultDto = frameResultDtos.get(frameIndex);
        final List<StepResultDto> stepResultDtos = frameResultDto.getStepResultDtos();

        for (int i = 0; i < stepResultDtos.size(); i++) {

            final StepResultDto stepResultDto = stepResultDtos.get(i);

            draw.append(drawStepInfo(frameIndex, stepResultDto.getFallenPinSize()));
            draw.append(drawBaseShape(frameResultDtos.size()));
            draw.append(NEW_LINE);

            draw.append(drawUsername(username));
            draw.append(drawFrameUntilIndex(frameResultDtos, frameIndex));
            draw.append(fillToCentered(drawerStepsUntilIndex(stepResultDtos, i), BLANK, EACH_SPACE_LENGTH));
            draw.append(BORDER);

            draw.append(NEW_LINE);
            draw.append(NEW_LINE);
        }

        return draw.toString();
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

    private String drawFrameUntilIndex(List<FrameResultDto> frameResultDtos, int frameIndex) {
        final StringBuilder drawer = new StringBuilder();

        for (int i = 0; i < frameIndex; i++) {
            final FrameResultDto frameResultDto = frameResultDtos.get(i);

            final String drawSteps = frameResultDto.getStepResultDtos().stream()
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
