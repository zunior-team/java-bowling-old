package trial;

import overturn.OverturnScore;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public enum TrialOrder {
    FIRST, SECOND, THIRD;

    private static final Map<TrialOrder, TrialOrder> nextTrial = new HashMap<>();
    private static final int ZERO = 0;

    static {
        nextTrial.put(FIRST, SECOND);
        nextTrial.put(SECOND, THIRD);

    }

    public static TrialResultType getTrialResultType(TrialOrder currentStatus, final int alivePins) {
        if (currentStatus == FIRST) {
            return (alivePins == ZERO) ? TrialResultType.STRIKE : TrialResultType.PROGRESS;
        }

        return (alivePins == ZERO)
                ? TrialResultType.SPARE
                : TrialResultType.MISS;
    }

    public TrialOrder next() {
        return nextTrial.get(this);
    }
}
