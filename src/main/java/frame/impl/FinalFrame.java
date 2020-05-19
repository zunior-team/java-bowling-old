package frame.impl;

import bowling.BowlingPins;
import frame.BowlingFrame;
import overturn.OverturnScore;
import trial.TrialOrder;
import trial.TrialResult;
import trial.TrialResultType;

public class FinalFrame implements BowlingFrame {

    private final BowlingPins bowlingPins;
    private TrialOrder trialOrder = TrialOrder.FIRST;

    public FinalFrame(){
        bowlingPins = new BowlingPins();
    }

    @SuppressWarnings("Duplicates")
    @Override
    public TrialResult decreasePinsAndGetResult(OverturnScore overturnScore) {

        final BowlingPins nowBowlingPins = trialOrder.getBonusBowlingPinsIfPossible(bowlingPins);
        final int alivePins = nowBowlingPins.getAlivePinsAfterDecreasePins(overturnScore);
        final TrialResultType trialResultType = TrialOrder.getTrialResultType(trialOrder, alivePins);

        final TrialResult trialResult = new TrialResult(trialResultType, trialOrder);
        final TrialResult newTrialResult = trialResult.givenOneMoreTrialIfPossible();
        this.trialOrder = newTrialResult.nextStatusAndGet();

        return newTrialResult;
    }
}
