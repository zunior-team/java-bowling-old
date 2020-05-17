package trial;

public class TrialResult {
    private final TrialResultType trialResultType;
    private final TrialStatus trialStatus;

    public TrialResult(final TrialResultType trialResultType, final TrialStatus trialStatus){
        this.trialResultType = trialResultType;
        this.trialStatus = trialStatus;
    }

    public TrialStatus nextStatusAndGet(){
        return trialStatus.next();
    }

    public TrialStatus getCurrentStatus(){
        return trialStatus;
    }

    public TrialResultType getTrialResultType(){
        return trialResultType;
    }
}
