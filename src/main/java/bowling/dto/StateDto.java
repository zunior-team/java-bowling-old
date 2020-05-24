package bowling.dto;

import bowling.state.State;

import java.util.List;

public class StateDto {
    private static final int FIRST_INDEX = 0;
    private static final int SECOND_INDEX = 1;
    private static final int THIRD_INDEX = 2;
    private static final int READY_STATE_VALUE = -1;

    private final Class<? extends State> stateType;
    private final List<Integer> downPins;

    private StateDto(final State state) {
        this.stateType = state.getClass();
        this.downPins = state.getDownPins();
    }

    public static StateDto of(final State state) {
        return new StateDto(state);
    }

    public Class<? extends State> getStateType() {
        return stateType;
    }

    public int getNoOfFirstDownPins() {
        return getDownPin(FIRST_INDEX);
    }

    public int getNoOfSecondDownPins() {
        return getDownPin(SECOND_INDEX);
    }

    public int getNoOfExtraDownPins() {
        return getDownPin(THIRD_INDEX);
    }

    public int getDownPin(final int idx) {
        if (downPins.size() <= idx) {
            return READY_STATE_VALUE;
        }

        return downPins.get(idx);
    }
}
