package view;

import domain.Pins;
import spark.utils.CollectionUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class FrameHistoryParser {

    private static Map<Integer, String> replaces = new HashMap<>();

    static {
        replaces.put(10, "X");
        replaces.put(0, "-");
    }

    private FrameHistoryParser() {
    }

    public static String parse(List<Integer> frameHistories) {
        if (CollectionUtils.isEmpty(frameHistories)) {
            return "";
        }

        final List<String> mappedHistories = frameHistories.stream()
                .map(fallenPins -> replaces.getOrDefault(fallenPins, fallenPins.toString()))
                .collect(Collectors.toList());

        if (frameHistories.size() == 1) {
            return String.format(" %s ", mappedHistories.get(0));
        }
        if (frameHistories.size() == 2) {
            final int sum = frameHistories.stream()
                    .mapToInt(Integer::intValue)
                    .sum();

            final String format = Pins.NUMBER_OF_PINS == sum ?
                    "%s|/" :
                    "%s|%s";
            return String.format(format, mappedHistories.get(0), mappedHistories.get(1));
        }
        if (frameHistories.size() == 3) {
            return String.format("%s|%s|%s", mappedHistories.get(0), mappedHistories.get(1), mappedHistories.get(2));
        }

        return "";
    }
}
