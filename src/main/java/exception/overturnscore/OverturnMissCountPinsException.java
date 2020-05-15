package exception.overturnscore;

import exception.master.BowlingException;

public class OverturnMissCountPinsException extends BowlingException {

    private static final String PINS_MISS_COUNT_FORMAT = "현재 남아있는 볼링핀의 개수[%d] 보다 더 많은 볼링핀[%d] 을 넘길 수 없습니다.";

    public OverturnMissCountPinsException(int alivePins, int inputPins) {
        super(String.format(PINS_MISS_COUNT_FORMAT, alivePins, inputPins));
    }
}
