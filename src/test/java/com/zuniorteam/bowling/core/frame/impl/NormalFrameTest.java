package com.zuniorteam.bowling.core.frame.impl;

import com.zuniorteam.bowling.core.frame.Frame;
import com.zuniorteam.bowling.core.pitch.Pitch;
import com.zuniorteam.bowling.core.value.FrameNumber;
import com.zuniorteam.bowling.core.value.PinSize;
import com.zuniorteam.bowling.core.value.PitchType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("일반 프레임 테스트")
class NormalFrameTest {

    @DisplayName("생성, null 주입시")
    @Test
    void testNewInstance(){
        assertThrows(AssertionError.class, () -> new NormalFrame(null));
    }

    @DisplayName("다음 pitch 생성, 첫번째 투구, 핀이 남았을때")
    @Test
    void testCreateNextPitch01(){
        //given
        final FrameNumber frameNumber = FrameNumber.FIRST;
        final Frame normalFrame = new NormalFrame(frameNumber);

        final Pitch nextPitch = normalFrame.createNextPitch(PitchType.FIRST);

        assertThat(nextPitch.getFrameNumber()).isEqualTo(frameNumber);
        assertThat(nextPitch.getPitchType()).isEqualTo(PitchType.SECOND);
    }

    @DisplayName("다음 pitch 생성, 첫번째 투구, 모든 핀이 쓰러졌을때")
    @Test
    void testCreateNextPitch02(){
        //given
        final FrameNumber frameNumber = FrameNumber.FIRST;
        final Frame normalFrame = new NormalFrame(frameNumber, PinSize.ZERO);

        final Pitch nextPitch = normalFrame.createNextPitch(PitchType.FIRST);

        assertThat(nextPitch.getFrameNumber()).isEqualTo(frameNumber.next());
        assertThat(nextPitch.getPitchType()).isEqualTo(PitchType.FIRST);
    }

    @DisplayName("다음 pitch 생성, 두번째 투구, 핀이 남았을때")
    @Test
    void testCreateNextPitch03(){
        //given
        final FrameNumber frameNumber = FrameNumber.FIRST;
        final Frame normalFrame = new NormalFrame(frameNumber);

        final Pitch nextPitch = normalFrame.createNextPitch(PitchType.SECOND);

        assertThat(nextPitch.getFrameNumber()).isEqualTo(frameNumber.next());
        assertThat(nextPitch.getPitchType()).isEqualTo(PitchType.FIRST);
    }

    @DisplayName("다음 pitch 생성, 두번째 투구, 모든 핀이 쓰러졌을때")
    @Test
    void testCreateNextPitch04(){
        //given
        final FrameNumber frameNumber = FrameNumber.FIRST;
        final Frame normalFrame = new NormalFrame(frameNumber, PinSize.ZERO);

        final Pitch nextPitch = normalFrame.createNextPitch(PitchType.SECOND);

        assertThat(nextPitch.getFrameNumber()).isEqualTo(frameNumber.next());
        assertThat(nextPitch.getPitchType()).isEqualTo(PitchType.FIRST);
    }

}