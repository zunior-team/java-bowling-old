package com.zuniorteam.bowling.core.frame.impl;

import com.zuniorteam.bowling.core.dto.FrameResultDto;
import com.zuniorteam.bowling.core.dto.StepResultDto;
import com.zuniorteam.bowling.core.frame.Frame;
import com.zuniorteam.bowling.core.step.player.StepPlayer;
import com.zuniorteam.bowling.core.step.player.impl.RandomStepPlayer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mockito;

import static com.zuniorteam.bowling.core.frame.Frame.FIRST_FRAME;
import static com.zuniorteam.bowling.core.frame.Frame.LAST_FRAME;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

@DisplayName("일반 프레임 테스트")
class NormalFrameTest {

    @DisplayName("적절하지 않은 프레임 번호일때")
    @ParameterizedTest
    @ValueSource(ints = {FIRST_FRAME - 1, LAST_FRAME + 1})
    void testNewInstanceIfInvalidFrameNumber(int frameNumber) {
        assertThrows(IllegalArgumentException.class, () -> new NormalFrame(frameNumber));
    }

    @DisplayName("NEXT 프레임 생성")
    @Test
    void testCreateNext(){
        //given
        final NormalFrame normalFrame = new NormalFrame(FIRST_FRAME);

        //then
        final Frame nextFrame = normalFrame.createNext();

        //then
        assertThat(nextFrame).extracting("frameNumber").isEqualTo(FIRST_FRAME + 1);
    }

    @DisplayName("NEXT 프레임 생성, 마지막 프레임 이전")
    @Test
    void testCreateNextIfBeforeLastFrame(){
        //given
        final NormalFrame normalFrame = new NormalFrame(LAST_FRAME - 1);

        //then
        final Frame nextFrame = normalFrame.createNext();

        //then
        assertThat(nextFrame.getClass()).isEqualTo(LastFrame.class);
    }

    @DisplayName("play 테스트")
    @Test
    void testPlay(){
        //given
        final RandomStepPlayer stepPlayer = Mockito.mock(RandomStepPlayer.class);
        final StepResultDto stepResultDto = Mockito.mock(StepResultDto.class);

        given(stepPlayer.play(any(), any())).willReturn(stepResultDto);

        //when
        final FrameResultDto frameResultDto = new NormalFrame(FIRST_FRAME).play(stepPlayer);

        //then
        assertThat(frameResultDto.getStepResultDtos()).containsExactly(stepResultDto, stepResultDto);
    }


}