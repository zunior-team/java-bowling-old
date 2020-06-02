package com.zuniorteam.bowling.core.value;

import java.util.Objects;

public class FrameNumber {

    public static final int FIRST_FRAME_NUMBER_VALUE = 1;
    public static final int LAST_FRAME_NUMBER_VALUE = 10;

    public static final FrameNumber FIRST = new FrameNumber(FIRST_FRAME_NUMBER_VALUE);
    public static final FrameNumber LAST = new FrameNumber(LAST_FRAME_NUMBER_VALUE);

    private final int number;

    private FrameNumber(int number) {
        validate(number);
        this.number = number;
    }

    public static FrameNumber of(int number){
        return new FrameNumber(number);
    }

    private void validate(int number) {
        if (number < FIRST_FRAME_NUMBER_VALUE || number > LAST_FRAME_NUMBER_VALUE) {
            throw new IllegalArgumentException("적절하지 않은 프레임 번호 입니다 : " + number);
        }
    }

    public int value() {
        return number;
    }

    public FrameNumber next() {
        return new FrameNumber(this.number + 1);
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FrameNumber that = (FrameNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }




}
