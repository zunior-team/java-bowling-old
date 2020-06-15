package frame;

import model.FrameResult;
import model.TrialOrder;
import overturn.OverturnScore;

public interface BowlingFrame {

    FrameResult subtractPinsByOverturnPins(OverturnScore overturnScore, TrialOrder trialOrder);
}
