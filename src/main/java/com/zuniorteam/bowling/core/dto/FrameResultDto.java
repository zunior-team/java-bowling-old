package com.zuniorteam.bowling.core.dto;

import java.util.List;

public class FrameResultDto {

    private final List<StepResultDto> stepResultDtos;

    public FrameResultDto(List<StepResultDto> stepResultDtos) {
        this.stepResultDtos = stepResultDtos;
    }

    public List<StepResultDto> getStepResultDtos() {
        return stepResultDtos;
    }
}
