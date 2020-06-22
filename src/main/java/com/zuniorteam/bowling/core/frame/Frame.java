package com.zuniorteam.bowling.core.frame;

import com.zuniorteam.bowling.core.dto.PitchResult;
import com.zuniorteam.bowling.core.pitch.Pitch;
import com.zuniorteam.bowling.core.value.*;

import java.util.Objects;


public abstract class Frame{

    private FrameNumber frameNumber;
    private PinSize remainPinSize;

    public Frame(FrameNumber frameNumber, PinSize pinSize) {
        Objects.requireNonNull(frameNumber, "프레임번호가 없습니다");
        Objects.requireNonNull(pinSize, "핀 사이즈가 없습니다");

        this.frameNumber = frameNumber;
        this.remainPinSize = pinSize;
    }

    public abstract Pitch createNextPitch(PitchType pitchType);

    public FrameNumber getFrameNumber() {
        return frameNumber;
    }

    public PitchResult fallPin(PitchType pitchType, PinSize fallenPinSize) {
        if (fallenPinSize.compareTo(remainPinSize) > 0) {
            throw new IllegalArgumentException( "쓰리진 핀의 갯수가 남아있는 핀의 개수보다 많습니다 쓰러진 : " + fallenPinSize + " 남아있는 : " + remainPinSize);
        }

        this.remainPinSize = this.remainPinSize.subtract(fallenPinSize);
        final PitchResultType pitchResultType = PitchResultType.of(pitchType, fallenPinSize, remainPinSize);

        return new PitchResult(frameNumber, pitchResultType, fallenPinSize);
    }

    protected boolean isAllFallen(){
        return this.remainPinSize.equals(PinSize.ZERO);
    }

}
