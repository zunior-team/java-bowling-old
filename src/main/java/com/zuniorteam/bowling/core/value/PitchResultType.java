package com.zuniorteam.bowling.core.value;

import java.util.Arrays;
import java.util.Objects;

import static com.zuniorteam.bowling.core.value.PinSize.ZERO;
import static com.zuniorteam.bowling.core.value.PitchType.*;

public enum PitchResultType {

    GUTTER{
        @Override
        public boolean eq(PitchType pitchType, PinSize fallenPinSize, PinSize remainPinSize) {
            return fallenPinSize.equals(ZERO);
        }
    },

    MISS{
        @Override
        public boolean eq(PitchType pitchType, PinSize fallenPinSize, PinSize remainPinSize) {
            return false;
        }
    },

    SPARE{
        @Override
        public boolean eq(PitchType pitchType, PinSize fallenPinSize, PinSize remainPinSize) {
            return remainPinSize.equals(ZERO) && SECOND.equals(pitchType);
        }
    },

    STRIKE{
        @Override
        public boolean eq(PitchType pitchType, PinSize fallenPinSize, PinSize remainPinSize) {
            return remainPinSize.equals(ZERO) && (FIRST.equals(pitchType) || BONUS.equals(pitchType));
        }
    };

    public abstract boolean eq(PitchType pitchType, PinSize fallenPinSize, PinSize remainPinSize);

    public static PitchResultType of(PitchType pitchType, PinSize fallenPinSize, PinSize remainPinSize) {
        validate(pitchType, fallenPinSize, remainPinSize);

        return Arrays.stream(PitchResultType.values())
                .filter(stepResultType -> stepResultType.eq(pitchType, fallenPinSize, remainPinSize))
                .findFirst().orElse(MISS);
    }

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

}
