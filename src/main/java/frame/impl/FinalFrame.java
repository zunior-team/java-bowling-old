package frame.impl;

import bowling.BowlingPins;
import frame.BowlingFrame;
import overturn.OverturnScore;
import trial.TrialOrder;
import trial.TrialResult;

public class FinalFrame implements BowlingFrame {

    private final BowlingPins bowlingPins;
    private TrialOrder status = TrialOrder.FIRST;

    public FinalFrame(){
        bowlingPins = new BowlingPins();
    }

    @SuppressWarnings("Duplicates")
    @Override
    public TrialResult decreasePinsAndGetResult(OverturnScore overturnScore) {
//        final int overturnPins = overturnScore.getOverturnPins();
//        final int alivePins = bowlingPins.getAlivePinsCount();
//
//        if(overturnPins > alivePins){
//            throw new OverturnMissCountPinsException(alivePins, overturnPins);
//        }
//
//        bowlingPins.decreaseAlivePins(overturnPins);
//        final int remainPins = alivePins - overturnPins;
//
//        return TrialOrder.getTrialResultType(status, remainPins);
        return null;
    }
}
