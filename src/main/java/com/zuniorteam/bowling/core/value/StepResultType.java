package com.zuniorteam.bowling.core.value;

import java.util.Arrays;

import static com.zuniorteam.bowling.core.value.Number.ZERO;
import static com.zuniorteam.bowling.core.value.StepType.*;

public enum StepResultType {

    GUTTER {
        public boolean is(StepType stepType, int numberOfFallenPin, int numberOfRemainPin) {
            return numberOfFallenPin == ZERO;
        }
    },

    MISS {
        public boolean is(StepType stepType, int numberOfFallenPin, int numberOfRemainPin) {
            return false;
        }
    },

    SPARE {
        public boolean is(StepType stepType, int numberOfFallenPin, int numberOfRemainPin) {
            return numberOfRemainPin == ZERO && SECOND.equals(stepType);
        }
    },

    STRIKE {
        public boolean is(StepType stepType, int numberOfFallenPin, int numberOfRemainPin) {
            return numberOfRemainPin == ZERO && (FIRST.equals(stepType) || BONUS.equals(stepType));
        }
    };

    public abstract boolean is(StepType stepType, int numberOfFallenPin, int numberOfRemainPin);

    public static StepResultType of(StepType stepType, int numberOfFallenPin, int numberOfRemainPin) {
        return Arrays.stream(StepResultType.values())
                .filter(stepResultType -> stepResultType.is(stepType, numberOfFallenPin, numberOfRemainPin))
                .findFirst().orElse(MISS);
    }

}
