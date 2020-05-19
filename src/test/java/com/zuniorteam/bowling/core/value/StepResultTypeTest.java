package com.zuniorteam.bowling.core.value;

import org.assertj.core.internal.bytebuddy.asm.Advice;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsSources;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

class StepResultTypeTest {

    @DisplayName("of 테스트")
    @ParameterizedTest
    @MethodSource("givenOf")
    void testOf(StepType stepType, int fallenPin, int remainPin, StepResultType expected){
        assertThat(StepResultType.of(stepType, fallenPin, remainPin)).isEqualTo(expected);
    }

    public static Stream<Arguments> givenOf(){
        return Stream.of(
                Arguments.of(StepType.FIRST, 10, 0, StepResultType.STRIKE),
                Arguments.of(StepType.FIRST, 9, 1, StepResultType.MISS),
                Arguments.of(StepType.FIRST, 0, 10, StepResultType.GUTTER),

                Arguments.of(StepType.SECOND, 0, 3, StepResultType.GUTTER),
                Arguments.of(StepType.SECOND, 9, 0, StepResultType.SPARE),
                Arguments.of(StepType.SECOND, 9, 1, StepResultType.MISS),

                Arguments.of(StepType.BONUS, 10, 0, StepResultType.STRIKE),
                Arguments.of(StepType.BONUS, 8, 2, StepResultType.MISS),
                Arguments.of(StepType.BONUS, 0, 10, StepResultType.GUTTER)
        );
    }

}