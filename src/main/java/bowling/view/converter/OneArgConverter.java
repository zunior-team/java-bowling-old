package bowling.view.converter;

import bowling.dto.StateDto;

public class OneArgConverter extends StateStringConverter {
    public static final OneArgConverter INSTANCE = new OneArgConverter();

    private OneArgConverter() {}

    @Override
    public String convert(final String format, final StateDto state) {
        return String.format(format, getFirstAsSymbol(state));
    }
}
