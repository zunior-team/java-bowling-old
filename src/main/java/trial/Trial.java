package trial;

import java.util.Objects;

import static bowling.BowlingPinConstant.*;

public class Trial {

    private final int overturnPinCount;
    private final int alivePinCount;

    private final boolean isAllOverturn;
    private final boolean isAllAlive;
    private final TrialOrder trialOrder;

    private Trial(final int overturnPinCount,
                  final int alivePinCount,
                  final TrialOrder trialOrder) {
        this.overturnPinCount = overturnPinCount;
        this.alivePinCount = alivePinCount;
        this.trialOrder = trialOrder;
    }

    private Trial(final boolean isAllOverturn, final boolean isAllAlive, TrialOrder trialOrder){
        this.isAllOverturn = isAllOverturn;
        this.isAllAlive = isAllAlive;
        this.trialOrder = trialOrder;
    }

    private Trial(final int alivePinCount, final TrialOrder trialOrder){
        this(0, alivePinCount, trialOrder);
    }

    public static Trial create(final int overturnPinCount, final int alivePinCount, final TrialOrder trialOrder){
        return new Trial(overturnPinCount, alivePinCount, trialOrder);
    }

    static Trial createStrike(){
        return new Trial(Boolean.TRUE, Boolean.FALSE, TrialOrder.FIRST);
    }

    static Trial createGutterInProgress(){
        return new Trial(Boolean.FALSE, Boolean.TRUE, TrialOrder.FIRST);
    }

    static Trial createGutterInFinish(){
        return new Trial(ZERO_PIN_COUNT, ALIVE_OF_PIN_COUNT, TrialOrder.SECOND);
    }

    static Trial createSpare(final int overturnPinCount){
        return new Trial(overturnPinCount, ZERO_PIN_COUNT, TrialOrder.SECOND);
    }

    public Trial createNormalInProgress(){
        return new Trial()
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Trial trial = (Trial) o;
        return overturnPinCount == trial.overturnPinCount &&
                alivePinCount == trial.alivePinCount &&
                trialOrder == trial.trialOrder;
    }

    @Override
    public int hashCode() {
        return Objects.hash(overturnPinCount, alivePinCount, trialOrder);
    }
}
