package frame.impl;

import bowling.BowlingPins;
import frame.BowlingFrame;
import model.FrameResult;
import model.TrialOrder;
import model.TrialResult;
import overturn.OverturnScore;

import java.util.ArrayList;
import java.util.List;

public class FinalFrame implements BowlingFrame {

    public static final String FINAL_FRAME = "FINAL_FRAME";
    private final List<BowlingPins> bowlingPinsList = new ArrayList<>();

    public FinalFrame(){
        bowlingPinsList.add(null);
        bowlingPinsList.add(new BowlingPins());
        bowlingPinsList.add(new BowlingPins());
        bowlingPinsList.add(new BowlingPins());
    }

    @Override
    public FrameResult subtractPinsByOverturnPins(OverturnScore overturnScore, TrialOrder trialOrder) {
        final BowlingPins bowlingPins = bowlingPinsList.get(trialOrder.getOrder());
        final int alivePins = bowlingPins.getAlivePinsAfterDecreasePins(overturnScore);
        return FrameResult.getFrameResult(new TrialResult(alivePins, FINAL_FRAME, trialOrder.getOrder()));
    }
}
