package trial;

public class TrialResult {
    private final TrialResultType trialResultType;
    private final TrialOrder trialOrder;

    public TrialResult(final TrialResultType trialResultType, final TrialOrder trialOrder){
        this.trialResultType = trialResultType;
        this.trialOrder = trialOrder;
    }

    public TrialOrder nextStatusAndGet(){
        if(trialResultType.isBonus() && trialOrder == TrialOrder.FIRST){
            return TrialOrder.THIRD;
        }

        return trialOrder.next();
    }

    public TrialResultType getTrialResultType(){
        return trialResultType;
    }

    public TrialResult givenOneMoreTrialIfPossible(){
        if(trialResultType.isStrikeOrSpare()){
            return new TrialResult(trialResultType.getBonusType(), trialOrder);
        }

        return this;
    }
}
