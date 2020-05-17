package frame.impl;

import bowling.BowlingPins;
import exception.overturnscore.OverturnMissCountPinsException;
import frame.BowlingFrame;
import overturn.OverturnScore;
import trial.TrialResult;
import trial.TrialResultType;
import trial.TrialStatus;

public class NormalFrame implements BowlingFrame {

    private final BowlingPins bowlingPins;
    private TrialStatus status = TrialStatus.FIRST;

    public NormalFrame(){
        bowlingPins = new BowlingPins();
    }

    @SuppressWarnings("Duplicates")
    @Override
    public TrialResult decreasePins(final OverturnScore overturnScore){
        if(overturnScore.isOverturnZero()) {
            final TrialResult trialResult = new TrialResult(TrialResultType.GUTTER, status);
            this.status = trialResult.nextStatusAndGet();
            return trialResult;
        }

        final int alivePins = bowlingPins.getAlivePinsAfterDecreasePins(overturnScore);
        final TrialResult trialResult = new TrialResult(TrialStatus.getTrialResultType(status, alivePins), status);
        this.status = trialResult.nextStatusAndGet();

        return trialResult;
    }
}
