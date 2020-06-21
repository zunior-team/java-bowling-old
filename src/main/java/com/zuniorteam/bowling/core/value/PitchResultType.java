package com.zuniorteam.bowling.core.value;

import java.util.Arrays;
import java.util.Objects;

import static com.zuniorteam.bowling.core.value.PinSize.ZERO;
import static com.zuniorteam.bowling.core.value.PitchType.*;

public enum PitchResultType {

    GUTTER((pitchType, fallenPinSize, remainPinSize) -> fallenPinSize.equals(ZERO)),
    MISS((pitchType, fallenPinSize, remainPinSize) -> false),
    SPARE ((pitchType, fallenPinSize, remainPinSize) -> remainPinSize.equals(ZERO) && SECOND.equals(pitchType)),
    STRIKE ((pitchType, fallenPinSize, remainPinSize) -> remainPinSize.equals(ZERO) && (FIRST.equals(pitchType) || BONUS.equals(pitchType)));

    PitchResultType(Eq eq) {
        this.eq = eq;
    }

    public static PitchResultType of(PitchType pitchType, PinSize fallenPinSize, PinSize remainPinSize) {
        validate(pitchType, fallenPinSize, remainPinSize);

        return Arrays.stream(PitchResultType.values())
                .filter(stepResultType -> stepResultType.eq.eq(pitchType, fallenPinSize, remainPinSize))
                .findFirst().orElse(MISS);
    }


    private final Eq eq;


    private static void validate(PitchType pitchType, PinSize fallenPinSize, PinSize remainPinSize) {
        if (Objects.isNull(pitchType)) {
            throw new IllegalArgumentException("스텝 타입을 입력해주세요");
        }

        if (Objects.isNull(fallenPinSize)) {
            throw new IllegalArgumentException("쓰러진 핀의 크기를 입력해주세요");
        }

        if (Objects.isNull(remainPinSize)) {
            throw new IllegalArgumentException("남아있는 핀의 크기를 입력해주세요");
        }
    }

    @FunctionalInterface
    public interface Eq {
        boolean eq(PitchType pitchType, PinSize fallenPinSize, PinSize remainPinSize);
    }

}
