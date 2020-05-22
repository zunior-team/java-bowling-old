package com.zuniorteam.bowling.core.frame.impl;


import com.zuniorteam.bowling.core.frame.Frame;
import com.zuniorteam.bowling.core.pitch.Pitch;
import com.zuniorteam.bowling.core.value.FrameNumber;
import com.zuniorteam.bowling.core.value.PinSize;
import com.zuniorteam.bowling.core.value.PitchType;

import static com.zuniorteam.bowling.core.value.PitchType.*;

public class LastFrame extends Frame {

    public LastFrame() {
        this(PinSize.MAX);
    }

    public LastFrame(PinSize pinSize) {
        super(FrameNumber.LAST, pinSize);
    }

    @Override
    public Pitch createNextPitch(PitchType pitchType) {

        if(pitchType.equals(FIRST) && !isAllFallen()){
            return new Pitch(this, SECOND);
        }

        if(pitchType.equals(FIRST) && isAllFallen()){
            return new Pitch(new LastFrame(), BONUS);
        }

        if(pitchType.equals(SECOND) && isAllFallen()){
            return new Pitch(new LastFrame(), BONUS);
        }

        return Pitch.END;
    }
}