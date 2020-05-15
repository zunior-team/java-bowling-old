package trial;

public enum TrialResultType {
    STRIKE, SPARE, MISS, GUTTER, PROGRESS;

    public boolean isProgress(){
        return PROGRESS == this;
    }
}
