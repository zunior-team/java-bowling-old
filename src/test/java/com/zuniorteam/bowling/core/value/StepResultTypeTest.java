package com.zuniorteam.bowling.core.value;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

class StepResultTypeTest {

    @DisplayName("of 테스트, null 주입 시")
    @Test
    void testOfIfArgsIsNull() {
        Assertions.assertAll(
                () -> assertThrows(IllegalArgumentException.class, () -> StepResultType.of(null, PinSize.ZERO, PinSize.MAX)),
                () -> assertThrows(IllegalArgumentException.class, () -> StepResultType.of(StepType.FIRST, null, PinSize.MAX)),
                () -> assertThrows(IllegalArgumentException.class, () -> StepResultType.of(StepType.FIRST, PinSize.ZERO, null))
        );
    }

    @DisplayName("of 테스트, 쓰러진 갯수와, 남아있는 핀의 개수가 일관성없을때")
    @Test
    void testOfIfInvalid() {
        assertThrows(IllegalArgumentException.class, () -> StepResultType.of(StepType.FIRST, PinSize.MAX, PinSize.MAX));
    }

    @DisplayName("of 테스트")
    @ParameterizedTest
    @MethodSource("givenOf")
    void testOf(StepType stepType, PinSize fallenPin, PinSize remainPin, StepResultType expected) {
        assertThat(StepResultType.of(stepType, fallenPin, remainPin)).isEqualTo(expected);
    }

    public static Stream<Arguments> givenOf() {
        return Stream.of(
                Arguments.of(StepType.FIRST, PinSize.of(10), PinSize.of(0), StepResultType.STRIKE),
                Arguments.of(StepType.FIRST, PinSize.of(9), PinSize.of(1), StepResultType.MISS),
                Arguments.of(StepType.FIRST, PinSize.of(0), PinSize.of(10), StepResultType.GUTTER),

                Arguments.of(StepType.SECOND, PinSize.of(0), PinSize.of(3), StepResultType.GUTTER),
                Arguments.of(StepType.SECOND, PinSize.of(9), PinSize.of(0), StepResultType.SPARE),
                Arguments.of(StepType.SECOND, PinSize.of(9), PinSize.of(1), StepResultType.MISS),

                Arguments.of(StepType.BONUS, PinSize.of(10), PinSize.of(0), StepResultType.STRIKE),
                Arguments.of(StepType.BONUS, PinSize.of(8), PinSize.of(2), StepResultType.MISS),
                Arguments.of(StepType.BONUS, PinSize.of(0), PinSize.of(10), StepResultType.GUTTER)
        );
    }

}