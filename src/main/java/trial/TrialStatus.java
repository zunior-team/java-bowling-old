package trial;

public enum TrialStatus {
    FIRST, SECOND, LAST, END;

    private static final int REMAIN_ZERO = 0;
    private static final int REMAIN_TEN = 10;

    public static TrialResultType getTrialResultType(final TrialStatus currentStatus, final int remainPins){
        if(currentStatus == FIRST){
            return (remainPins == REMAIN_ZERO) ? TrialResultType.STRIKE : TrialResultType.PROGRESS;
        } else {
            if(remainPins == REMAIN_TEN){
                return TrialResultType.GUTTER;
            } else if (remainPins == REMAIN_ZERO){
                return TrialResultType.SPARE;
            } else {
                return TrialResultType.MISS;
            }
        }
    }
}
