package view;

import domain.Frame;
import domain.FrameResult;
import org.apache.commons.lang3.StringUtils;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class FrameResultFormatParser {
    private static Map<FrameResult, String> formattingMap = new EnumMap<>(FrameResult.class);

    static {
        formattingMap.put(FrameResult.STRIKE, " X ");
        formattingMap.put(FrameResult.SPARE, "%s|/");
        formattingMap.put(FrameResult.MISS, "%s|%s");
    }

    private FrameResultFormatParser() {
    }

    public static String parse(Frame frame) {
        return format(frame.getFrameResult(), frame.getFrameHistories()).replace("0", "-");
    }

    private static String format(FrameResult frameResult, List<Integer> frameHistories) {
        final String format = formattingMap.get(frameResult);

        final int throwCount = frameHistories.size();
        if (throwCount == 1) {
            return String.format(format, frameHistories.get(0), " ");
        }

        return String.format(format, frameHistories.get(0), frameHistories.get(1));
    }
}
