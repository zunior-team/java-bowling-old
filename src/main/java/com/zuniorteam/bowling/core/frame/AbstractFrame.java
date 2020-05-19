package com.zuniorteam.bowling.core.frame;

import com.zuniorteam.bowling.core.dto.StepResultDto;
import com.zuniorteam.bowling.core.step.player.StepPlayer;
import com.zuniorteam.bowling.core.value.Compared;
import com.zuniorteam.bowling.core.value.PinSize;
import com.zuniorteam.bowling.core.value.StepType;

import java.util.ArrayList;
import java.util.List;


public abstract class AbstractFrame implements Frame{

    public static final int FIRST_FRAME = 1;
    public static final int LAST_FRAME = 10;

    protected List<StepResultDto> playBase(StepPlayer stepPlayer){
        final List<StepResultDto> stepResults = new ArrayList<>();

        final StepResultDto firstStepResultDto = stepPlayer.play(StepType.FIRST, PinSize.MAX);
        stepResults.add(firstStepResultDto);

        final PinSize remainPinSize = PinSize.MAX.subtract(firstStepResultDto.getFallenPinSize());

        if (remainPinSize.compareTo(PinSize.ZERO) == Compared.MORE) {
            stepResults.add(stepPlayer.play(StepType.SECOND, remainPinSize));
        }

        return stepResults;
    }
}
