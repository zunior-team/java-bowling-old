package com.zuniorteam.bowling.core.pitch;

import com.zuniorteam.bowling.core.dto.PitchResult;
import com.zuniorteam.bowling.core.frame.Frame;
import com.zuniorteam.bowling.core.value.FrameNumber;
import com.zuniorteam.bowling.core.value.PinSize;
import com.zuniorteam.bowling.core.value.PitchType;

public class Pitch {

    public static final Pitch END = new Pitch();

    private Frame frame;
    private PitchType pitchType;

    private Pitch(){};

    public Pitch(Frame frame, PitchType pitchType) {
        assert frame != null;
        assert pitchType != null;

        this.frame = frame;
        this.pitchType = pitchType;
    }

    public PitchResult play(PinSize fallenPinSize) {
        return frame.fallPin(pitchType, fallenPinSize);
    }

    public Pitch next() {
        return frame.createNextPitch(pitchType);
    }

    public FrameNumber getFrameNumber() {
        return frame.getFrameNumber();
    }

    public PitchType getPitchType() {
        return pitchType;
    }
}
