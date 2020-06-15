package com.zuniorteam.bowling.core.frame;

import com.zuniorteam.bowling.core.dto.PitchResult;
import com.zuniorteam.bowling.core.pitch.Pitch;
import com.zuniorteam.bowling.core.value.FrameNumber;
import com.zuniorteam.bowling.core.value.PinSize;
import com.zuniorteam.bowling.core.value.PitchType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class FrameTest {

    @DisplayName("쓰러진 핀이, 남아있는 핀의 수 보다 많을때")
    @Test
    void testFallPinSuccess(){
        //given
        final FrameNumber frameNumber = FrameNumber.FIRST;
        final Frame frame = new FrameImpl(frameNumber, PinSize.MAX);
        final PinSize fallenPinSize = PinSize.of(3);

        //when
        final PitchResult pitchResult = frame.fallPin(PitchType.SECOND, fallenPinSize);

        //then
        assertThat(pitchResult.getFallenPinSize()).isEqualTo(fallenPinSize);
        assertThat(pitchResult.getFrameNumber()).isEqualTo(frameNumber);
    }

    @DisplayName("쓰러진 핀이, 남아있는 핀의 수 보다 많을때")
    @Test
    void testFallPinIfFallenMoreThanRemainPin(){
        final Frame frame = new FrameImpl(FrameNumber.FIRST, PinSize.ZERO);

        assertThrows(IllegalArgumentException.class, () -> frame.fallPin(PitchType.FIRST, PinSize.MAX));
    }

    @DisplayName("isAllFallen, 남아있는 핀의 개수 체크")
    @ParameterizedTest
    @CsvSource({"0, true", "1, false"})
    void testIsAllFallen(int remainPinSize, boolean expected){
        final Frame frame = new FrameImpl(FrameNumber.FIRST, PinSize.of(remainPinSize));

        assertThat(frame.isAllFallen()).isEqualTo(expected);
    }

    private static class FrameImpl extends Frame{

        public FrameImpl(FrameNumber frameNumber, PinSize pinSize) {
            super(frameNumber, pinSize);
        }

        @Override
        public Pitch createNextPitch(PitchType pitchType) {
            return null;
        }
    }

}