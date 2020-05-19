package com.zuniorteam.bowling.core.dto;

import com.zuniorteam.bowling.core.value.PinSize;
import com.zuniorteam.bowling.core.value.StepResultType;

public class StepResultDto {

    private StepResultType stepResultType;
    private PinSize fallenPinSize;

    public StepResultDto(StepResultType stepResultType, PinSize fallenPinSize) {
        this.stepResultType = stepResultType;
        this.fallenPinSize = fallenPinSize;
    }

    public StepResultType getStepResultType() {
        return stepResultType;
    }

    public PinSize getFallenPinSize() {
        return fallenPinSize;
    }
}
