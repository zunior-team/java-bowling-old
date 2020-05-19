package com.zuniorteam.bowling.core.step.player;

import com.zuniorteam.bowling.core.dto.StepResultDto;
import com.zuniorteam.bowling.core.value.PinSize;
import com.zuniorteam.bowling.core.value.StepType;

public interface StepPlayer{

    StepResultDto play(StepType stepType, PinSize currentPinSize);
}
