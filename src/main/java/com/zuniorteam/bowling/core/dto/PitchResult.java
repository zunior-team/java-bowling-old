package com.zuniorteam.bowling.core.dto;

import com.zuniorteam.bowling.core.value.FrameNumber;
import com.zuniorteam.bowling.core.value.PinSize;
import com.zuniorteam.bowling.core.value.PitchResultType;

public class PitchResult {

    private FrameNumber frameNumber;
    private PitchResultType pitchResultType;
    private PinSize fallenPinSize;

    public PitchResult(FrameNumber frameNumber, PitchResultType pitchResultType, PinSize fallenPinSize) {
        assert frameNumber != null;
        assert pitchResultType != null;
        assert fallenPinSize != null;

        this.frameNumber = frameNumber;
        this.pitchResultType = pitchResultType;
        this.fallenPinSize = fallenPinSize;
    }

    public FrameNumber getFrameNumber() {
        return frameNumber;
    }

    public PitchResultType getPitchResultType() {
        return pitchResultType;
    }

    public PinSize getFallenPinSize() {
        return fallenPinSize;
    }
}
