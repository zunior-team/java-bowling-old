package view;

import domain.pin.Pins;
import spark.utils.CollectionUtils;
import utils.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FrameHistoryParser {
    
    public String parse(List<Integer> frameHistories) {
        if (CollectionUtils.isEmpty(frameHistories)) {
            return StringUtils.EMPTY;
        }

        final List<String> mappedHistories = frameHistories.stream()
                .map(HistoryMark::findMarkOrItSelf)
                .collect(Collectors.toList());

        if (frameHistories.size() == 1) {
            return String.format(" %s ", mappedHistories.get(0));
        }
        if (frameHistories.size() == 2) {
            final int sum = frameHistories.stream()
                    .mapToInt(Integer::intValue)
                    .sum();

            final String format = Pins.MAX_NUMBER_OF_PINS == sum ?
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
