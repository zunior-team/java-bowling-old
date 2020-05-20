package com.zuniorteam.bowling.core.frame.impl;


import com.zuniorteam.bowling.core.dto.FrameResultDto;
import com.zuniorteam.bowling.core.dto.StepResultDto;
import com.zuniorteam.bowling.core.frame.AbstractFrame;
import com.zuniorteam.bowling.core.frame.Frame;
import com.zuniorteam.bowling.core.step.player.StepPlayer;
import com.zuniorteam.bowling.core.value.PinSize;
import com.zuniorteam.bowling.core.value.StepResultType;
import com.zuniorteam.bowling.core.value.StepType;

import java.util.List;

import static com.zuniorteam.bowling.core.value.StepResultType.SPARE;
import static com.zuniorteam.bowling.core.value.StepResultType.STRIKE;
import static com.zuniorteam.bowling.util.CollectionUtil.simpleMap;

public class LastFrame extends AbstractFrame {

    @Override
    public Frame createNext() {
        return END;
    }

    @Override
    public FrameResultDto play(StepPlayer stepPlayer) {
        final List<StepResultDto> stepResults = this.playBase(stepPlayer);

        if (isPlayBonusStep(stepResults)) {
            stepResults.add(stepPlayer.play(StepType.BONUS, PinSize.MAX));
        }

        return new FrameResultDto(stepResults);
    }

    private boolean isPlayBonusStep(List<StepResultDto> stepResults) {
        final List<StepResultType> stepResultTypes = simpleMap(stepResults, StepResultDto::getStepResultType);
        return stepResultTypes.contains(STRIKE) || stepResultTypes.contains(SPARE);
    }

}