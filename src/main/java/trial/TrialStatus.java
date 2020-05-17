package trial;

import java.util.HashMap;
import java.util.Map;

public enum TrialStatus{
    FIRST, SECOND, LAST;

    private static final Map<TrialStatus, TrialStatus> nextTrial = new HashMap<>();
    private static final int REMAIN_ZERO = 0;

    static {
        nextTrial.put(FIRST, SECOND);
        nextTrial.put(SECOND, LAST);

    }

    public static TrialResultType getTrialResultType(TrialStatus currentStatus, final int remainPins) {
        if (currentStatus == FIRST) {
            return (remainPins == REMAIN_ZERO) ? TrialResultType.STRIKE : TrialResultType.PROGRESS;
        }

        return (remainPins == REMAIN_ZERO)
                ? TrialResultType.SPARE
                : TrialResultType.MISS;
    }

    public TrialStatus next() {
        return nextTrial.get(this);
    }
}
