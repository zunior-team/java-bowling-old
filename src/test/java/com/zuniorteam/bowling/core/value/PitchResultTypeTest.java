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

class PitchResultTypeTest {

    @DisplayName("of 테스트, null 주입 시")
    @Test
    void testOfIfArgsIsNull() {
        Assertions.assertAll(
                () -> assertThrows(IllegalArgumentException.class, () -> PitchResultType.of(null, PinSize.ZERO, PinSize.MAX)),
                () -> assertThrows(IllegalArgumentException.class, () -> PitchResultType.of(PitchType.FIRST, null, PinSize.MAX)),
                () -> assertThrows(IllegalArgumentException.class, () -> PitchResultType.of(PitchType.FIRST, PinSize.ZERO, null))
        );
    }

    @DisplayName("of 테스트")
    @ParameterizedTest
    @MethodSource("givenOf")
    void testOf(PitchType pitchType, PinSize fallenPin, PinSize remainPin, PitchResultType expected) {
        assertThat(PitchResultType.of(pitchType, fallenPin, remainPin)).isEqualTo(expected);
    }

    public static Stream<Arguments> givenOf() {
        return Stream.of(
                Arguments.of(PitchType.FIRST, PinSize.of(10), PinSize.of(0), PitchResultType.STRIKE),
                Arguments.of(PitchType.FIRST, PinSize.of(9), PinSize.of(1), PitchResultType.MISS),
                Arguments.of(PitchType.FIRST, PinSize.of(0), PinSize.of(10), PitchResultType.GUTTER),

                Arguments.of(PitchType.SECOND, PinSize.of(0), PinSize.of(3), PitchResultType.GUTTER),
                Arguments.of(PitchType.SECOND, PinSize.of(9), PinSize.of(0), PitchResultType.SPARE),
                Arguments.of(PitchType.SECOND, PinSize.of(9), PinSize.of(1), PitchResultType.MISS),

                Arguments.of(PitchType.BONUS, PinSize.of(10), PinSize.of(0), PitchResultType.STRIKE),
                Arguments.of(PitchType.BONUS, PinSize.of(8), PinSize.of(2), PitchResultType.MISS),
                Arguments.of(PitchType.BONUS, PinSize.of(0), PinSize.of(10), PitchResultType.GUTTER)
        );
    }

}