package com.zuniorteam.bowling.core.frame.impl;


import com.zuniorteam.bowling.core.dto.FrameResultDto;
import com.zuniorteam.bowling.core.frame.AbstractFrame;
import com.zuniorteam.bowling.core.frame.Frame;
import com.zuniorteam.bowling.core.step.player.StepPlayer;

public class NormalFrame extends AbstractFrame {

    private final int frameNumber;

    protected NormalFrame(int frameNumber) {
        validate(frameNumber);
        this.frameNumber = frameNumber;
    }

    private void validate(int frameNumber) {
        if (frameNumber < FIRST_FRAME
                || frameNumber > LAST_FRAME) {
            throw new IllegalArgumentException("적절하지 않은 프레임 번호 입니다 : " + frameNumber);
        }
    }

    @Override
    public Frame createNext() {
        if (this.frameNumber == LAST_FRAME - 1) {
            return new LastFrame();
        }

        return new NormalFrame(frameNumber + 1);
    }

    @Override
    public FrameResultDto play(StepPlayer stepPlayer) {
        return new FrameResultDto(this.playBase(stepPlayer));
    }

}