package com.zuniorteam.bowling.core.step.player.impl;

import com.zuniorteam.bowling.core.dto.StepResultDto;
import com.zuniorteam.bowling.core.value.StepType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mockito;

import java.util.concurrent.ThreadLocalRandom;

import static com.zuniorteam.bowling.core.BowlingGame.NUMBER_OF_PIN;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.BDDMockito.given;

@DisplayName("RANDOM 스템 플레이어 테스트")
class RandomStepPlayerTest {

    @DisplayName("생성, Assertion Error")
    @Test
    void testNewInstanceIfArgsIsNull() {
        assertThrows(AssertionError.class, () -> new RandomStepPlayer(null));
    }

    @DisplayName("스텝 play, StepType 이 null 일때")
    @Test
    void testPlayIfStepTypeIsNull() {
        final RandomStepPlayer randomStepPlayer = new RandomStepPlayer(ThreadLocalRandom.current());

        assertThrows(IllegalArgumentException.class, () -> randomStepPlayer.play(null, NUMBER_OF_PIN));
    }

    @DisplayName("스텝 play, 현재 pin 개수가 범위를 벗어 났을때")
    @ParameterizedTest
    @ValueSource(ints = {-1, NUMBER_OF_PIN + 1})
    void testPlayIfInvalidCurrentPin(int numberOfCurrentPin) {
        final RandomStepPlayer randomStepPlayer = new RandomStepPlayer(ThreadLocalRandom.current());

        assertThrows(IllegalArgumentException.class, () -> randomStepPlayer.play(StepType.FIRST, numberOfCurrentPin));
    }

    @DisplayName("스텝 play")
    @ParameterizedTest
    @ValueSource(ints = {1, 7, 8})
    void testPlay(int numberOfFallenPin) {
        final ThreadLocalRandom threadLocalRandom = Mockito.mock(ThreadLocalRandom.class);
        given(threadLocalRandom.nextInt(anyInt())).willReturn(numberOfFallenPin);

        final RandomStepPlayer randomStepPlayer = new RandomStepPlayer(threadLocalRandom);

        final StepResultDto stepResultDto = randomStepPlayer.play(StepType.FIRST, NUMBER_OF_PIN);
        //then
        assertThat(stepResultDto.getNumberOfFallenPin()).isEqualTo(numberOfFallenPin);
    }

}