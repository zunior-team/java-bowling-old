package com.zuniorteam.bowling.core.step.player.impl;

import com.zuniorteam.bowling.core.BowlingGame;
import com.zuniorteam.bowling.core.dto.StepResultDto;
import com.zuniorteam.bowling.core.step.player.StepPlayer;
import com.zuniorteam.bowling.core.value.Number;
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

    public StepResultDto play(StepType stepType, int numberOfCurrentPin) {
        validatePlay(stepType, numberOfCurrentPin);

        final int numberOfFallenPin = threadLocalRandom.nextInt(numberOfCurrentPin + 1);
        final int numberOfRemainPin = numberOfCurrentPin - numberOfFallenPin;
        return new StepResultDto(StepResultType.of(stepType, numberOfFallenPin, numberOfRemainPin), numberOfFallenPin);
    }

    private void validatePlay(StepType stepType, int numberOfCurrentPin) {
        if(Objects.isNull(stepType)){
            throw new IllegalArgumentException("스텝 type을 입력해주세요");
        }

        if(numberOfCurrentPin > BowlingGame.NUMBER_OF_PIN
                || numberOfCurrentPin < Number.ZERO){
            throw new IllegalArgumentException("적절하지 않은 PIN 개수 입니다 : " + numberOfCurrentPin);
        }
    }

}
