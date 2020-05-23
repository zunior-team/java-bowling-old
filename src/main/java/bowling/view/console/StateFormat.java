package bowling.view.console;

import bowling.state.*;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public enum StateFormat {
    READY(Ready.class, ""),
    PLAYING(Playing.class, "%d"),
    MISS(Miss.class, "%d|%s"),
    SPARE(Spare.class, "%d|/"),
    STRIKE(Strike.class, "X"),
    LAST_FRAME_STATE(LastPlaying.class, "%s%s%s"),
    LAST_FRAME_END(LastEnd.class, "%s%s%s");

    private static final Map<Class<? extends State>, StateFormat> STATE_FORMATS =
            Arrays.stream(StateFormat.values())
                    .collect(Collectors.toMap(StateFormat::getStateType, Function.identity()));

    private final Class<? extends State> stateType;
    private final String format;

    StateFormat(final Class<? extends State> stateType, final String format) {
        this.stateType = stateType;
        this.format = format;
    }

    private Class<? extends State> getStateType() {
        return stateType;
    }
}
