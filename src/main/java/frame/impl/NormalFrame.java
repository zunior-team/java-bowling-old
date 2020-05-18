package frame.impl;

import bowling.BowlingPins;
import frame.BowlingFrame;
import overturn.OverturnScore;
import trial.TrialOrder;
import trial.TrialResult;
import trial.TrialResultType;

public class NormalFrame implements BowlingFrame {

    private final BowlingPins bowlingPins;
    private TrialOrder trialOrder = TrialOrder.FIRST;

    public NormalFrame(){
        bowlingPins = new BowlingPins();
    }

    @SuppressWarnings("Duplicates")
    @Override
    public TrialResult decreasePinsAndGetResult(final OverturnScore overturnScore){
        final int alivePins = bowlingPins.getAlivePinsAfterDecreasePins(overturnScore);
        final TrialResultType trialResultType = TrialOrder.getTrialResultType(trialOrder, alivePins);
        final TrialResult trialResult = new TrialResult(trialResultType, trialOrder);
        this.trialOrder = trialResult.nextStatusAndGet();

        return trialResult;
    }
}
