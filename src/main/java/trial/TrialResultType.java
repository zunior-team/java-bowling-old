package trial;

import org.apache.commons.lang3.StringUtils;
import overturn.OverturnScore;

public enum TrialResultType {
    STRIKE("X"),
    SPARE("/"),
    GUTTER("-"),
    PROGRESS(StringUtils.EMPTY),
    MISS(StringUtils.EMPTY);

    private String expression;

    TrialResultType(String expression){
        this.expression = expression;
    }

    public String getBowlingContentByType(final OverturnScore overturnScore){
        if(overturnScore.isOverturnZero()){
            return GUTTER.getExpression();
        }

        return (this == PROGRESS || this == MISS)
                ? String.valueOf(overturnScore.getOverturnPins())
                : this.getExpression();
    }

    public boolean isProgress(){
        return PROGRESS == this;
    }

    public boolean isStrikeOrSpare(){
        return STRIKE == this || SPARE == this;
    }

    public String getExpression(){
        return expression;
    }
}
