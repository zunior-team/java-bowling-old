package com.zuniorteam.bowling.core.frame.impl;

import com.zuniorteam.bowling.core.frame.Frame;
import com.zuniorteam.bowling.core.pitch.Pitch;
import com.zuniorteam.bowling.core.value.FrameNumber;
import com.zuniorteam.bowling.core.value.PinSize;
import com.zuniorteam.bowling.core.value.PitchType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("마지막 프레임 테스트")
class LastFrameTest {

    @DisplayName("다음 pitch 생성, 첫번째 투구, 핀이 남았을때")
    @Test
    void testCreateNextPitch01(){
        //given
        final Frame lastFrame = new LastFrame();

        final Pitch nextPitch = lastFrame.createNextPitch(PitchType.FIRST);

        assertThat(nextPitch.getFrameNumber()).isEqualTo(FrameNumber.LAST);
        assertThat(nextPitch.getPitchType()).isEqualTo(PitchType.SECOND);
    }

    @DisplayName("다음 pitch 생성, 첫번째 투구, 모든 핀이 쓰러졌을때")
    @Test
    void testCreateNextPitch02(){
        //given
        final Frame lastFrame = new LastFrame(PinSize.ZERO);

        final Pitch nextPitch = lastFrame.createNextPitch(PitchType.FIRST);

        assertThat(nextPitch.getFrameNumber()).isEqualTo(FrameNumber.LAST);
        assertThat(nextPitch.getPitchType()).isEqualTo(PitchType.BONUS);
    }

    @DisplayName("다음 pitch 생성, 두번째 투구, 핀이 남았을때")
    @Test
    void testCreateNextPitch03(){
        //given
        final Frame lastFrame = new LastFrame();

        final Pitch nextPitch = lastFrame.createNextPitch(PitchType.SECOND);

        assertThat(nextPitch).isEqualTo(Pitch.END);
    }

    @DisplayName("다음 pitch 생성, 두번째 투구, 모든 핀이 쓰러졌을때")
    @Test
    void testCreateNextPitch04(){
        //given
        final Frame lastFrame = new LastFrame(PinSize.ZERO);

        final Pitch nextPitch = lastFrame.createNextPitch(PitchType.SECOND);

        assertThat(nextPitch.getFrameNumber()).isEqualTo(FrameNumber.LAST);
        assertThat(nextPitch.getPitchType()).isEqualTo(PitchType.BONUS);
    }

}