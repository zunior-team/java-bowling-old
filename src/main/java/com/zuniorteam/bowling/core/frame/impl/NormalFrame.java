package com.zuniorteam.bowling.core.frame.impl;


import com.zuniorteam.bowling.core.dto.FrameResultDto;
import com.zuniorteam.bowling.core.frame.AbstractFrame;
import com.zuniorteam.bowling.core.frame.Frame;
import com.zuniorteam.bowling.core.step.player.StepPlayer;
import com.zuniorteam.bowling.core.value.FrameNumber;

public class NormalFrame extends AbstractFrame {

    private final FrameNumber frameNumber;

    protected NormalFrame(FrameNumber frameNumber) {
        this.frameNumber = frameNumber;
    }

    @Override
    public Frame createNext() {
        final FrameNumber nextFrameNumber = frameNumber.next();

        if (nextFrameNumber.equals(FrameNumber.LAST)){
            return new LastFrame();
        }

        return new NormalFrame(nextFrameNumber);
    }

    @Override
    public FrameResultDto play(StepPlayer stepPlayer) {
        return new FrameResultDto(this.playBase(stepPlayer));
    }

}