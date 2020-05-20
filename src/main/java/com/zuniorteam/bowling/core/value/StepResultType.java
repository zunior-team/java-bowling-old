package com.zuniorteam.bowling.core.value;

import java.util.Arrays;
import java.util.Objects;

import static com.zuniorteam.bowling.core.value.PinSize.ZERO;
import static com.zuniorteam.bowling.core.value.StepType.*;

public enum StepResultType {

    GUTTER((stepType, fallenPinSize, remainPinSize) -> fallenPinSize.equals(ZERO)),
    MISS((stepType, fallenPinSize, remainPinSize) -> false),
    SPARE((stepType, fallenPinSize, remainPinSize) -> remainPinSize.equals(ZERO) && SECOND.equals(stepType)),
    STRIKE((stepType, fallenPinSize, remainPinSize) -> remainPinSize.equals(ZERO) && (FIRST.equals(stepType) || BONUS.equals(stepType)));

    private final StepResultType.EqualStrategy equalStrategy;

    StepResultType(EqualStrategy equalStrategy) {
        this.equalStrategy = equalStrategy;
    }

    public static StepResultType of(StepType stepType, PinSize fallenPinSize, PinSize remainPinSize) {
        validate(stepType, fallenPinSize, remainPinSize);

        return Arrays.stream(StepResultType.values())
                .filter(stepResultType -> stepResultType.equalStrategy.eq(stepType, fallenPinSize, remainPinSize))
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

        if (fallenPinSize.add(remainPinSize).compareTo(PinSize.MAX) == Compared.MORE) {
            throw new IllegalArgumentException(
                    "쓰리진 핀의 갯수와, 남아있는 핀의 개수의 합이 "
                            + PinSize.MAX + " 보다 클 수 없습니다." +
                            "쓰러진 :" + fallenPinSize + " 남아있는 : " + remainPinSize);
        }
    }

    @FunctionalInterface
    public interface EqualStrategy {
        boolean eq(StepType stepType, PinSize fallenPinSize, PinSize remainPinSize);
    }

}
