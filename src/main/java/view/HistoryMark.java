package view;

import java.util.Arrays;
import java.util.Map;

import static java.util.stream.Collectors.toMap;

public enum HistoryMark {

    STRIKE(10, "X"),
    GUTTER(0, "-");

    private static final Map<Integer, String> COLLECT = Arrays.stream(values())
            .collect(
                    toMap(o -> o.numberOfPins,
                            o -> o.mark)
            );

    private final int numberOfPins;
    private final String mark;

    HistoryMark(final int numberOfPins, final String mark) {
        this.numberOfPins = numberOfPins;
        this.mark = mark;
    }

    public static String findMarkOrItSelf(int numberOfPins) {
        return COLLECT.getOrDefault(numberOfPins, String.valueOf(numberOfPins));
    }
}
