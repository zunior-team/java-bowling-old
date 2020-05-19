package com.zuniorteam.bowling.core.value;

import java.util.Arrays;
import java.util.Objects;

import static com.zuniorteam.bowling.core.value.PinSize.ZERO;
import static com.zuniorteam.bowling.core.value.StepType.*;

public enum StepResultType {

    GUTTER {
        public boolean is(StepType stepType, PinSize fallenPinSize, PinSize remainPinSize) {
            return fallenPinSize.equals(ZERO);
        }
    },

    MISS {
        public boolean is(StepType stepType, PinSize fallenPinSize, PinSize remainPinSize) {
            return false;
        }
    },

    SPARE {
        public boolean is(StepType stepType, PinSize fallenPinSize, PinSize remainPinSize) {
            return remainPinSize.equals(ZERO) && SECOND.equals(stepType);
        }
    },

    STRIKE {
        public boolean is(StepType stepType, PinSize fallenPinSize, PinSize remainPinSize) {
            return remainPinSize.equals(ZERO) && (FIRST.equals(stepType) || BONUS.equals(stepType));
        }
    };

    public abstract boolean is(StepType stepType, PinSize fallenPinSize, PinSize remainPinSize);

    public static StepResultType of(StepType stepType, PinSize fallenPinSize, PinSize remainPinSize) {
        validate(stepType, fallenPinSize, remainPinSize);
        return Arrays.stream(StepResultType.values())
                .filter(stepResultType -> stepResultType.is(stepType, fallenPinSize, remainPinSize))
                .findFirst().orElse(MISS);
    }

    private static void validate(StepType stepType, PinSize fallenPinSize, PinSize remainPinSize) {
        if (Objects.isNull(stepType)) {
            throw new IllegalArgumentException("스텝 타입을 입력해주세요");
        }

        if (Objects.isNull(fallenPinSize)) {
            throw new IllegalArgumentException("쓰러진 핀의 크기를 입력해주세요");
        }

        if (Objects.isNull(remainPinSize)) {
            throw new IllegalArgumentException("남아있는 핀의 크기를 입력해주세요");
        }

        if (fallenPinSize.add(remainPinSize).compareTo(PinSize.MAX) > 0) {
            throw new IllegalArgumentException(
                    "쓰리진 핀의 갯수와, 남아있는 핀의 개수의 합이 "
                            + PinSize.MAX + " 보다 클 수 없습니다." +
                            "쓰러진 :" + fallenPinSize + " 남아있는 : " + remainPinSize);
        }


    }

}
