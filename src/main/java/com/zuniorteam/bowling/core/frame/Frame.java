package com.zuniorteam.bowling.core.frame;

import com.zuniorteam.bowling.core.dto.FrameResultDto;
import com.zuniorteam.bowling.core.dto.StepResultDto;
import com.zuniorteam.bowling.core.step.player.StepPlayer;
import com.zuniorteam.bowling.core.value.StepType;

import java.util.ArrayList;
import java.util.List;

import static com.zuniorteam.bowling.core.BowlingGame.NUMBER_OF_PIN;
import static com.zuniorteam.bowling.core.value.Number.ZERO;

public abstract class Frame {
    public static final int FIRST_FRAME = 1;
    public static final int LAST_FRAME = 10;

    public abstract Frame createNext();
    public abstract FrameResultDto play(StepPlayer stepPlayer);

    protected List<StepResultDto> playBase(StepPlayer stepPlayer){
        final List<StepResultDto> stepResults = new ArrayList<>();

        final StepResultDto firstStepResultDto = stepPlayer.play(StepType.FIRST, NUMBER_OF_PIN);
        stepResults.add(firstStepResultDto);

        final int numberOfRemainPin = NUMBER_OF_PIN - firstStepResultDto.getNumberOfFallenPin();
        if (numberOfRemainPin > ZERO) {
            stepResults.add(stepPlayer.play(StepType.SECOND, numberOfRemainPin));
        }

        return stepResults;
    }
}
