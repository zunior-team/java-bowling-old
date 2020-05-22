package bowling.state;

public enum StateEnum {
    READY,
    SECOND_TRY,
    MISS,
    SPARE,
    STRIKE;

    public StateEnum updateState() {
        return READY;
    }
}
