package bowling.state;

public enum StateEnum {
    READY,
    SECOND_TRY,
    MISS,
    GUTTER,
    SPAIR,
    STRIKE;


    public StateEnum updateState() {
        return READY;
    }
}
