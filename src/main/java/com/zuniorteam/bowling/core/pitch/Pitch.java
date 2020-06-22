package com.zuniorteam.bowling.core.pitch;

import com.zuniorteam.bowling.core.dto.PitchResult;
import com.zuniorteam.bowling.core.frame.Frame;
import com.zuniorteam.bowling.core.value.FrameNumber;
import com.zuniorteam.bowling.core.value.PinSize;
import com.zuniorteam.bowling.core.value.PitchType;

import java.util.Objects;

public class Pitch {

    // 좋은 방법일까요..?
    // 멤버변수 final 의 강제성을 분실했습니다..
    // 의견부탁드립니다..!
    public static final Pitch END = new Pitch();

    private Frame frame;
    private PitchType pitchType;

    private Pitch(){}

    public Pitch(Frame frame, PitchType pitchType) {
        Objects.requireNonNull(frame, "프레임이 없습니다");
        Objects.requireNonNull(pitchType, "투구타입이 없습니다");

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
