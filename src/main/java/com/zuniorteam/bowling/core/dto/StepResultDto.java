package com.zuniorteam.bowling.core.dto;

import com.zuniorteam.bowling.core.value.StepResultType;

public class StepResultDto {

    private StepResultType stepResultType;
    private int numberOfFallenPin;

    public StepResultDto(StepResultType stepResultType, int numberOfFallenPin) {
        this.stepResultType = stepResultType;
        this.numberOfFallenPin = numberOfFallenPin;
    }

    public StepResultType getStepResultType() {
        return stepResultType;
    }

    public int getNumberOfFallenPin() {
        return numberOfFallenPin;
    }
}
