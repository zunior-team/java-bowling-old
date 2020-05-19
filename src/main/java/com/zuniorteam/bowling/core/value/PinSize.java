package com.zuniorteam.bowling.core.value;


import java.util.Objects;

import static com.zuniorteam.bowling.core.value.Compared.*;

public class PinSize {

    public static final int MIN_PIN_SIZE = Number.ZERO;
    public static final int MAX_PIN_SIZE = 10;

    public static final PinSize ZERO = new PinSize(Number.ZERO);
    public static final PinSize MAX = new PinSize(MAX_PIN_SIZE);

    private final int value;

    private PinSize(int value){
        validate(value);
        this.value = value;
    }

    private void validate(int value) {
        if(value < MIN_PIN_SIZE || value > MAX_PIN_SIZE){
            throw new IllegalArgumentException("잘못된 핀 개수 입니다 : " + value);
        }
    }

    public static PinSize of(int value) {
        return new PinSize(value);
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PinSize pinSize = (PinSize) o;
        return value == pinSize.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    public int value(){
        return value;
    }

    public PinSize subtract(PinSize pinSize) {
        return PinSize.of(this.value - pinSize.value());
    }

    public PinSize add(PinSize pinSize) {
        return PinSize.of(this.value + pinSize.value());
    }

    public Compared compareTo(PinSize pinSize){
        if(this.value == pinSize.value()){
            return SAME;
        }

        return this.value > pinSize.value ? MORE : LESS;
    }
}
