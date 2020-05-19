package trial;

import org.apache.commons.lang3.StringUtils;
import overturn.OverturnScore;

public enum TrialResultType {
    STRIKE("X"),
    SPARE("/"),
    GUTTER("-"),
    PROGRESS(StringUtils.EMPTY),
    BONUS(StringUtils.EMPTY),
    MISS(StringUtils.EMPTY),
    FINISH(StringUtils.EMPTY);

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

    public boolean isBonus(){
        return BONUS == this;
    }

    public TrialResultType getBonusType(){
        final TrialResultType bonus = TrialResultType.BONUS;
        bonus.expression = this.getExpression();
        return bonus;
    }

    public TrialResultType getFinishType(){
        final TrialResultType finish = TrialResultType.FINISH;
        finish.expression = this.getExpression();
        return finish;
    }

    public String getExpression(){
        return expression;
    }
}
