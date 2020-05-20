package com.zuniorteam.bowling.core.frame.impl;

import com.zuniorteam.bowling.core.dto.FrameResultDto;
import com.zuniorteam.bowling.core.dto.StepResultDto;
import com.zuniorteam.bowling.core.frame.Frame;
import com.zuniorteam.bowling.core.step.player.impl.RandomStepPlayer;
import com.zuniorteam.bowling.core.value.FrameNumber;
import com.zuniorteam.bowling.core.value.PinSize;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mockito;

import static com.zuniorteam.bowling.core.value.FrameNumber.LAST_FRAME_NUMBER_VALUE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

@DisplayName("일반 프레임 테스트")
class NormalFrameTest {

    @DisplayName("생성, null 주입시")
    @Test
    void testNewInstance(){
        assertThrows(AssertionError.class, () -> new NormalFrame(null));
    }

    @DisplayName("NEXT 프레임 생성")
    @Test
    void testCreateNext(){
        //given
        final NormalFrame normalFrame = new NormalFrame(FrameNumber.FIRST);

        //then
        final Frame nextFrame = normalFrame.createNext();

        //then
        assertThat(nextFrame).extracting("frameNumber").isEqualTo(FrameNumber.FIRST.next());
    }

    @DisplayName("NEXT 프레임 생성, 마지막 프레임 이전")
    @Test
    void testCreateNextIfBeforeLastFrame(){
        //given
        final NormalFrame normalFrame = new NormalFrame(FrameNumber.of(LAST_FRAME_NUMBER_VALUE - 1));

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
        given(stepResultDto.getFallenPinSize()).willReturn(PinSize.ZERO);

        //when
        final FrameResultDto frameResultDto = new NormalFrame(FrameNumber.of(2)).play(stepPlayer);

        //then
        assertThat(frameResultDto.getStepResults()).containsExactly(stepResultDto, stepResultDto);
    }


}