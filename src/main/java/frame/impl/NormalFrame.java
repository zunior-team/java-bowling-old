package frame.impl;

import bowling.BowlingPins;
import frame.BowlingFrame;
import overturn.OverturnScore;
import trial.TrialOrder;
import trial.TrialResult;
import trial.TrialResultType;

import java.util.List;

public class NormalFrame implements BowlingFrame {

    private final BowlingPins bowlingPins;
    private TrialOrder trialOrder = TrialOrder.FIRST;

    public NormalFrame(){
        bowlingPins = new BowlingPins();
    }

    @SuppressWarnings("Duplicates")
    @Override
    public TrialResult decreasePinsAndGetResult(final OverturnScore overturnScore){

        final List<TrialResultType> resultTypes = bowlingPins.getTrialResultTypesAfterOverturnPins(overturnScore, trialOrder);

        if(overturnScore.isOverturnZero()) {
            final TrialResult trialResult = new TrialResult(TrialResultType.GUTTER, trialOrder);
            this.trialOrder = trialResult.nextStatusAndGet();
            return trialResult;
        }

        final int alivePins = bowlingPins.getAlivePinsAfterDecreasePins(overturnScore);


        final TrialResult trialResult = new TrialResult(TrialOrder.getTrialResultType(trialOrder, alivePins), trialOrder);
        this.trialOrder = trialResult.nextStatusAndGet();

        return trialResult;
    }
}
