package trial;

import org.apache.commons.lang3.StringUtils;

import java.util.*;
import java.util.stream.IntStream;

import static console.BowlingGameConstant.FIRST_ROUND_NUMBER;
import static console.BowlingGameConstant.LAST_ROUND_NUMBER;

public enum TrialResultType {
    STRIKE("X"),
    SPARE("/"),
    MISS(StringUtils.EMPTY),
    GUTTER("-"),
    NORMAL(StringUtils.EMPTY),
    PROGRESS(StringUtils.EMPTY),
    FINISH(StringUtils.EMPTY);

    private static final Map<Trial, List<TrialResultType>> trialSet = new HashMap<>();

    static {
        trialSet.put(Trial.createStrike(), Collections.singletonList(STRIKE));
        trialSet.put(Trial.createGutterInProgress(), Arrays.asList(GUTTER, PROGRESS));
        trialSet.put(Trial.createGutterInFinish(), Arrays.asList(GUTTER, FINISH));
        IntStream.rangeClosed(FIRST_ROUND_NUMBER, LAST_ROUND_NUMBER)
                .forEach(round -> trialSet.put(Trial.createSpare(round), Collections.singletonList(SPARE)));
    }

    private String expression;

    TrialResultType(String expression){
        this.expression = expression;
    }

    public static List<TrialResultType> getResultByTrial(final Trial trial){
        return trialSet.getOrDefault(trial, Collections.singletonList(NORMAL));
    }

    public boolean isProgress(){
        return PROGRESS == this;
    }

    public boolean isMiss() {return MISS == this;};

    public boolean isGutter() {
        return GUTTER == this;
    }

    public String getExpression(){
        return expression;
    }
}
