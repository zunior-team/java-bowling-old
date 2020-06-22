package com.zuniorteam.bowling.core.frame.impl;


import com.zuniorteam.bowling.core.frame.Frame;
import com.zuniorteam.bowling.core.pitch.Pitch;
import com.zuniorteam.bowling.core.value.FrameNumber;
import com.zuniorteam.bowling.core.value.PinSize;
import com.zuniorteam.bowling.core.value.PitchType;

import static com.zuniorteam.bowling.core.value.PitchType.FIRST;
import static com.zuniorteam.bowling.core.value.PitchType.SECOND;

public class NormalFrame extends Frame {

    public NormalFrame(FrameNumber frameNumber) {
        this(frameNumber, PinSize.MAX);
    }

    public NormalFrame(FrameNumber frameNumber, PinSize pinSize) {
        super(frameNumber, pinSize);
    }

    @Override
    public Pitch createNextPitch(PitchType pitchType) {

        if (FIRST.equals(pitchType) && isAllFallen()) {
            return new Pitch(nextFrame(), FIRST);
        }

        if (FIRST.equals(pitchType) && !isAllFallen()) {
            return new Pitch( this, SECOND);
        }

        return new Pitch(nextFrame(), FIRST);
    }

    private Frame nextFrame() {
        final FrameNumber nextFrameNumber = getFrameNumber().next();

        if (nextFrameNumber.equals(FrameNumber.LAST)){
            return new LastFrame();
        }

        return new NormalFrame(nextFrameNumber);
    }

}
