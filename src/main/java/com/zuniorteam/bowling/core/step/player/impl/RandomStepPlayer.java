package com.zuniorteam.bowling.core.step.player.impl;

import com.zuniorteam.bowling.core.dto.StepResultDto;
import com.zuniorteam.bowling.core.step.player.StepPlayer;
import com.zuniorteam.bowling.core.value.PinSize;
import com.zuniorteam.bowling.core.value.StepResultType;
import com.zuniorteam.bowling.core.value.StepType;

import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;

public class RandomStepPlayer implements StepPlayer {

    private final ThreadLocalRandom threadLocalRandom;

    public RandomStepPlayer(ThreadLocalRandom threadLocalRandom) {
        assert threadLocalRandom != null;

        this.threadLocalRandom = threadLocalRandom;
    }

    public StepResultDto play(StepType stepType, PinSize currentPinSize) {
        validatePlay(stepType, currentPinSize);

        final PinSize fallenPinSize = PinSize.of(threadLocalRandom.nextInt(currentPinSize.value() + 1));
        final PinSize remainPinSize = currentPinSize.subtract(fallenPinSize);
        return new StepResultDto(StepResultType.of(stepType, fallenPinSize, remainPinSize), fallenPinSize);
    }

    private void validatePlay(StepType stepType, PinSize currentPinSize) {
        if(Objects.isNull(stepType)){
            throw new IllegalArgumentException("스텝 type을 입력해주세요");
        }

        if(Objects.isNull(currentPinSize)){
            throw new IllegalArgumentException("핀 사이즈를 입력해주세요");
        }

    }

}
