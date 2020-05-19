package com.zuniorteam.bowling.core.value;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static com.zuniorteam.bowling.core.value.FrameNumber.FIRST_FRAME_NUMBER_VALUE;
import static com.zuniorteam.bowling.core.value.FrameNumber.LAST_FRAME_NUMBER_VALUE;
import static org.junit.jupiter.api.Assertions.assertThrows;

class FrameNumberTest {

    @DisplayName("적절하지 않은 프레임 번호일때")
    @ParameterizedTest
    @ValueSource(ints = { FIRST_FRAME_NUMBER_VALUE - 1, LAST_FRAME_NUMBER_VALUE + 1})
    void testNewInstanceIfInvalidFrameNumber(int frameNumber) {
        assertThrows(IllegalArgumentException.class, () -> FrameNumber.of(frameNumber));
    }


}