package com.zuniorteam.bowling.core.value;

import java.util.Objects;

public class FrameNumber {

    public static final int FIRST_FRAME_NUMBER_VALUE = 1;
    public static final int LAST_FRAME_NUMBER_VALUE = 10;

    public static final FrameNumber FIRST = new FrameNumber(FIRST_FRAME_NUMBER_VALUE);
    public static final FrameNumber LAST = new FrameNumber(LAST_FRAME_NUMBER_VALUE);

    private final int value;

    private FrameNumber(int value) {
        validate(value);
        this.value = value;
    }

    public static FrameNumber of(int value){
        return new FrameNumber(value);
    }

    private void validate(int frameNumber) {
        if (frameNumber < FIRST_FRAME_NUMBER_VALUE || frameNumber > LAST_FRAME_NUMBER_VALUE) {
            throw new IllegalArgumentException("적절하지 않은 프레임 번호 입니다 : " + frameNumber);
        }
    }

    public int value() {
        return value;
    }

    public FrameNumber next() {
        return new FrameNumber(this.value + 1);
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FrameNumber that = (FrameNumber) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }




}
