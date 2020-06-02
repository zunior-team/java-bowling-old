package com.zuniorteam.bowling.core.dto;

import com.zuniorteam.bowling.core.value.FrameNumber;
import com.zuniorteam.bowling.core.value.PinSize;
import com.zuniorteam.bowling.core.value.PitchResultType;

import java.util.Objects;

public class PitchResult {

    private final FrameNumber frameNumber;
    private final PitchResultType pitchResultType;
    private final PinSize fallenPinSize;

    public PitchResult(FrameNumber frameNumber, PitchResultType pitchResultType, PinSize fallenPinSize) {
        Objects.requireNonNull(frameNumber, "프레임 번호가 없습니다");
        Objects.requireNonNull(pitchResultType, "프레임 결과 타입이 없습니다");
        Objects.requireNonNull(fallenPinSize, "쓰러진 핀 개수가 없습니다");

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
