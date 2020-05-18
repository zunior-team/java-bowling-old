package trial;

public class TrialResult {
    private final TrialResultType trialResultType;
    private final TrialOrder trialOrder;

    public TrialResult(final TrialResultType trialResultType, final TrialOrder trialOrder){
        this.trialResultType = trialResultType;
        this.trialOrder = trialOrder;
    }

    public TrialOrder nextStatusAndGet(){
        return trialOrder.next();
    }

    public TrialOrder getCurrentStatus(){
        return trialOrder;
    }

    public TrialResultType getTrialResultType(){
        return trialResultType;
    }
}
