package bowling.view.converter;

import bowling.dto.StateDto;
import bowling.view.StateSymbol;

public abstract class StateStringConverter {
    public abstract String convert(final String format, final StateDto state);

    protected String getFirstAsSymbol(final StateDto state) {
        return StateSymbol.convert(state.getNoOfFirstDownPins());
    }

    protected String getSecondAsSymbol(final StateDto state) {
        return StateSymbol.convert(state.getNoOfSecondDownPins());
    }

    protected String getExtraAsSymbol(final StateDto state) {
        return StateSymbol.convert(state.getNoOfExtraDownPins());
    }
}
