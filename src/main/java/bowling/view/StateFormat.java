package bowling.view;

import bowling.dto.StateDto;
import bowling.state.*;
import bowling.view.converter.*;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public enum StateFormat {
    READY(Ready.class, "", ZeroArgConverter.INSTANCE),
    PLAYING(Playing.class, "%s", OneArgConverter.INSTANCE),
    MISS(Miss.class, "%s|%s", TwoArgsConverter.INSTANCE),
    SPARE(Spare.class, "%s|/", OneArgConverter.INSTANCE),
    STRIKE(Strike.class, "X", ZeroArgConverter.INSTANCE),
    LAST_PLAYING(LastPlaying.class, "%s%s%s", ThreeArgsConverter.INSTANCE),
    GAME_END(GameEnd.class, "%s%s%s", ThreeArgsConverter.INSTANCE);

    private static final Map<Class<? extends State>, StateFormat> STATE_FORMATS =
            Arrays.stream(StateFormat.values())
                    .collect(Collectors.toMap(StateFormat::getStateType, Function.identity()));

    private final Class<? extends State> stateType;
    private final String format;
    private final StateStringConverter converter;

    StateFormat(final Class<? extends State> stateType, final String format, final StateStringConverter converter) {
        this.stateType = stateType;
        this.format = format;
        this.converter = converter;
    }

    private Class<? extends State> getStateType() {
        return stateType;
    }

    public static String of(final StateDto state) {
        StateFormat stateFormat = STATE_FORMATS.get(state.getStateType());

        return stateFormat.converter
                .convert(stateFormat.format, state);
    }
}
