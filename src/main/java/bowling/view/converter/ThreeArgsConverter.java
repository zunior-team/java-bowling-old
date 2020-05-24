package bowling.view.converter;

import bowling.dto.StateDto;

public class ThreeArgsConverter extends StateStringConverter {
    public static final ThreeArgsConverter INSTANCE = new ThreeArgsConverter();

    private ThreeArgsConverter() {}

    @Override
    public String convert(final String format, final StateDto state) {
        return String.format(format, getFirstAsSymbol(state), getSecondAsSymbol(state), getExtraAsSymbol(state));
    }
}
