package frame.impl;

import bowling.BowlingPins;
import exception.overturnscore.OverturnMissCountPinsException;
import frame.BowlingFrame;
import overturn.OverturnScore;
import trial.TrialResultType;
import trial.TrialStatus;

public class NormalFrame implements BowlingFrame {

    private static final TrialResultType GUTTER = TrialResultType.GUTTER;
    private final BowlingPins bowlingPins;
    private TrialStatus status = TrialStatus.FIRST;

    public NormalFrame(){
        bowlingPins = new BowlingPins();
    }

    @SuppressWarnings("Duplicates")
    @Override
    public TrialResultType decreasePins(final OverturnScore overturnScore){
        final int overturnPins = overturnScore.getOverturnPins();
        final int alivePins = bowlingPins.getAlivePinsCount();

        if(overturnPins == 0){
            return GUTTER;
        }

        if(overturnPins > alivePins){
            throw new OverturnMissCountPinsException(alivePins, overturnPins);
        }

        bowlingPins.decreaseAlivePins(overturnPins);
        final int remainPins = alivePins - overturnPins;

        return TrialStatus.getTrialResultType(status, remainPins);
    }
}
