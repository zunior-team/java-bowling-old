package trial;

import java.util.Objects;

public class Trial {

    private final TrialOrder trialOrder;
    private final int alivePins;

    private Trial(final TrialOrder trialOrder, final int alivePins){
        this.trialOrder = trialOrder;
        this.alivePins = alivePins;
    }

    static Trial create(final TrialOrder trialOrder, final int alivePins){
        return new Trial(trialOrder, alivePins);
    }

    static Trial createByFirst(final int alivePins){
        return new Trial(TrialOrder.FIRST, alivePins);
    }

    static Trial createBySecond(final int alivePins){
        return new Trial(TrialOrder.SECOND, alivePins);
    }

    static Trial createByThird(final int alivePins) {
        return new Trial(TrialOrder.THIRD, alivePins);
    }

    public TrialResultType getResultType(){
        if(trialOrder == TrialOrder.FIRST){
            return (alivePins == 0)
                    ? TrialResultType.STRIKE
                    : TrialResultType.PROGRESS;
        }

        if(trialOrder == TrialOrder.SECOND) {
            return (alivePins == 0)
                    ? TrialResultType.SPARE
                    : TrialResultType.MISS;
        }

        return (alivePins == 0)
                ? TrialResultType.STRIKE
                : TrialResultType.MISS;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        trial.Trial trial = (trial.Trial) o;
        return alivePins == trial.alivePins &&
                trialOrder == trial.trialOrder;
    }

    @Override
    public int hashCode() {
        return Objects.hash(trialOrder, alivePins);
    }
}
