package trial;

import org.apache.commons.lang3.StringUtils;

public enum TrialResultType {
    STRIKE("X"),
    SPARE("/"),
    MISS(StringUtils.EMPTY),
    GUTTER("-"),
    PROGRESS(StringUtils.EMPTY);

    private String expression;

    TrialResultType(String expression){
        this.expression = expression;
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
