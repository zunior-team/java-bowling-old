package com.zuniorteam.bowling.core.pitch;

import com.zuniorteam.bowling.core.frame.impl.NormalFrame;
import com.zuniorteam.bowling.core.value.FrameNumber;
import com.zuniorteam.bowling.core.value.PitchType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Pitch 테스트")
class PitchTest {

    @DisplayName("생성, null 주입시")
    @Test
    public void testNewInstanceIfArgsIsNull(){
        assertAll(
                () -> assertThrows(AssertionError.class, () -> new Pitch(null, null)),
                () -> assertThrows(AssertionError.class, () -> new Pitch(new NormalFrame(FrameNumber.FIRST), null)),
                () -> assertThrows(AssertionError.class, () -> new Pitch(null, PitchType.FIRST))
        );
    }

}