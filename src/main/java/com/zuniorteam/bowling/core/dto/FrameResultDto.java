package com.zuniorteam.bowling.core.dto;

import java.util.List;

public class FrameResultDto {

    private final List<StepResultDto> stepResults;

    public FrameResultDto(List<StepResultDto> stepResults) {
        this.stepResults = stepResults;
    }

    public List<StepResultDto> getStepResults() {
        return stepResults;
    }
}
