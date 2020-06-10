package frame.impl;

import bowling.BowlingPins;
import frame.BowlingFrame;
import model.FrameResult;
import model.TrialOrder;
import model.TrialResult;
import overturn.OverturnScore;

public class NormalFrame implements BowlingFrame {

    public static final String NORMAL_FRAME = "NORMAL_FRAME";
    private final BowlingPins bowlingPins;

    public NormalFrame(){
        bowlingPins = new BowlingPins();
    }

    @Override
    public FrameResult subtractPinsByOverturnPins(final OverturnScore overturnScore, final TrialOrder trialOrder) {
        final int alivePins = bowlingPins.getAlivePinsAfterDecreasePins(overturnScore);
        return FrameResult.getFrameResult(new TrialResult(alivePins, NORMAL_FRAME, trialOrder.getOrder()));
    }
}
