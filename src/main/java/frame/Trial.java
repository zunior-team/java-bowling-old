package frame;

public class Trial {

    private static final int REMAIN_ZERO = 0;
    private static final int REMAIN_TEN = 10;
    private Status status = Status.FIRST;

    enum Status {
        FIRST, SECOND, LAST
    }

    public TrialResultType getTrialResultType(int remainPins){
        if(remainPins == REMAIN_ZERO && status == Status.FIRST){
            status = Status.SECOND;
            return TrialResultType.STRIKE;
        }

        if(remainPins == REMAIN_TEN && status == Status.SECOND){
            return TrialResultType.GUTTER;
        }

        if(remainPins == REMAIN_ZERO && status == Status.SECOND){
            return TrialResultType.SPARE;
        }

        if(status == Status.SECOND){
            return TrialResultType.MISS;
        }

        return TrialResultType.PROGRESS;
    }
}
