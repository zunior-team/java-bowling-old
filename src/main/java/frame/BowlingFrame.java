package frame;

import model.FrameResult;
import model.Trial;
import overturn.OverturnScore;
import trial.TrialResult;

public interface BowlingFrame {

    TrialResult decreasePinsAndGetResult(OverturnScore overturnScore);

    FrameResult subtractPinsByOverturnPins(OverturnScore overturnScore, Trial trial);
}
