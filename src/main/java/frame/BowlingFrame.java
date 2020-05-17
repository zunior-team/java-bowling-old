package frame;

import overturn.OverturnScore;
import trial.TrialResult;

public interface BowlingFrame {

    TrialResult decreasePinsAndGetResult(OverturnScore overturnScore);
}
