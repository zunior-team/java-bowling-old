package com.zuniorteam.bowling.core.frame.impl;

import com.zuniorteam.bowling.core.dto.FrameResultDto;
import com.zuniorteam.bowling.core.dto.StepResultDto;
import com.zuniorteam.bowling.core.step.player.impl.RandomStepPlayer;
import com.zuniorteam.bowling.core.value.PinSize;
import com.zuniorteam.bowling.core.value.StepResultType;
import com.zuniorteam.bowling.core.value.StepType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.BDDMockito.given;

class LastFrameTest {

    @DisplayName("next 생성")
    @Test
    void testCreateNext(){
        final LastFrame lastFrame = new LastFrame();

        assertThat(lastFrame.createNext()).isNull();
    }


    @DisplayName("play 테스트, 보너스 있을때")
    @Test
    void testPlay(){
        //given
        final RandomStepPlayer stepPlayer = Mockito.mock(RandomStepPlayer.class);
        final StepResultDto firstStepResultDto = Mockito.mock(StepResultDto.class);
        final StepResultDto secondStepResultDto = Mockito.mock(StepResultDto.class);
        final StepResultDto bonusStepResultDto = Mockito.mock(StepResultDto.class);

        given(stepPlayer.play(eq(StepType.FIRST), any())).willReturn(firstStepResultDto);
        given(stepPlayer.play(eq(StepType.SECOND), any())).willReturn(secondStepResultDto);
        given(stepPlayer.play(eq(StepType.BONUS), any())).willReturn(bonusStepResultDto);

        given(firstStepResultDto.getStepResultType()).willReturn(StepResultType.GUTTER);
        given(firstStepResultDto.getFallenPinSize()).willReturn(PinSize.ZERO);
        given(secondStepResultDto.getStepResultType()).willReturn(StepResultType.STRIKE);

        //when
        final FrameResultDto frameResultDto = new LastFrame().play(stepPlayer);

        //then
        assertThat(frameResultDto.getStepResultDtos()).containsExactly(firstStepResultDto, secondStepResultDto, bonusStepResultDto);
    }
}