package domain;

import static domain.Pins.ZERO;

public enum FrameResult {
    STRIKE,
    SPARE,
    MISS;

    public static FrameResult findByThrowCountAndLeftPins(int throwCount, int leftPins) {
        if (throwCount == 1 && leftPins == ZERO) {
            return STRIKE;
        }
        if (leftPins == ZERO) {
            return SPARE;
        }
        return MISS;
    }
}
