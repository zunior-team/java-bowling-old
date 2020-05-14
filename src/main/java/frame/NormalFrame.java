package frame;

import score.Score;
import score.ScoreType;

public class NormalFrame implements BowlingFrame{

    private ScoreType scoreType = ScoreType.WAITING;
    private Score score;
}
