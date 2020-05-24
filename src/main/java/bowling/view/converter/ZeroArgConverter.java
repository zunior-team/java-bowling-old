package bowling.view.converter;

import bowling.dto.StateDto;

public class ZeroArgConverter extends StateStringConverter {
    public static final ZeroArgConverter INSTANCE = new ZeroArgConverter();

    private ZeroArgConverter() {}

    @Override
    public String convert(final String format, final StateDto state) {
        return format;
    }
}
