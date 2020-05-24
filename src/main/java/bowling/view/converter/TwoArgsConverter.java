package bowling.view.converter;

import bowling.dto.StateDto;

public class TwoArgsConverter extends StateStringConverter {
    public static final TwoArgsConverter INSTANCE = new TwoArgsConverter();

    private TwoArgsConverter() {}

    @Override
    public String convert(final String format, final StateDto state) {
        return String.format(format, getFirstAsSymbol(state), getSecondAsSymbol(state));
    }
}
