package model;

import java.util.HashMap;
import java.util.Map;

import static frame.impl.FinalFrame.FINAL_FRAME;
import static frame.impl.NormalFrame.NORMAL_FRAME;

public enum FrameResult {
    NORMAL,
    GUTTER,
    STRIKE,
    SPARE,
    BONUS;

    private static final int ALL_ALIVE_PINS = 10;
    private static final int ALL_DEAD_PINS = 0;
    private static final int FIRST_ROUND = 1;
    private static final int SECOND_ROUND = 2;
    private static final int LAST_ROUND = 3;

    private static final Map<Boolean, Map<TrialResult, FrameResult>> RESULT_SET = new HashMap<>();
    private static final Map<TrialResult, FrameResult> NORMAL_RESULT_SET = new HashMap<>();
    private static final Map<TrialResult, FrameResult> FINAL_RESULT_SET = new HashMap<>();

    static{
        // 일반 프레임 : 결과내용.
        NORMAL_RESULT_SET.put(new TrialResult(ALL_DEAD_PINS, NORMAL_FRAME, FIRST_ROUND), FrameResult.STRIKE);
        NORMAL_RESULT_SET.put(new TrialResult(ALL_DEAD_PINS, NORMAL_FRAME, SECOND_ROUND), FrameResult.SPARE);
        NORMAL_RESULT_SET.put(new TrialResult(ALL_ALIVE_PINS, NORMAL_FRAME, FIRST_ROUND), FrameResult.GUTTER);
        NORMAL_RESULT_SET.put(new TrialResult(ALL_ALIVE_PINS, NORMAL_FRAME, SECOND_ROUND), FrameResult.GUTTER);


        // 마지막 프레임 : 결과내용.
        FINAL_RESULT_SET.put(new TrialResult(ALL_DEAD_PINS, FINAL_FRAME, FIRST_ROUND), FrameResult.BONUS);
        FINAL_RESULT_SET.put(new TrialResult(ALL_DEAD_PINS, FINAL_FRAME, SECOND_ROUND), FrameResult.BONUS);
        FINAL_RESULT_SET.put(new TrialResult(ALL_DEAD_PINS, FINAL_FRAME, LAST_ROUND), FrameResult.STRIKE);
        FINAL_RESULT_SET.put(new TrialResult(ALL_ALIVE_PINS, FINAL_FRAME, FIRST_ROUND), FrameResult.GUTTER);
        FINAL_RESULT_SET.put(new TrialResult(ALL_ALIVE_PINS, FINAL_FRAME, SECOND_ROUND), FrameResult.GUTTER);
        FINAL_RESULT_SET.put(new TrialResult(ALL_ALIVE_PINS, FINAL_FRAME, LAST_ROUND), FrameResult.GUTTER);

        // true, NORMAL
        // false, FINAL
        RESULT_SET.put(Boolean.TRUE, NORMAL_RESULT_SET);
        RESULT_SET.put(Boolean.FALSE, FINAL_RESULT_SET);
    }

    public static FrameResult getFrameResult(final TrialResult trialResult){
        return RESULT_SET.get(trialResult.isNormalTrial())
                .getOrDefault(trialResult, FrameResult.NORMAL);
    }

    public boolean isStrike(){
        return this == STRIKE;
    }

    public boolean isSpare(){
        return this == SPARE;
    }

    public boolean isBonus(){
        return this == BONUS;
    }
}
