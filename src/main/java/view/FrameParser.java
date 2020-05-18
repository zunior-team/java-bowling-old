package view;

import domain.Frame;

import java.util.List;

public class FrameParser {
    private FrameParser() {
    }

    public static String parse(Frame frame) {
        final List<Integer> throwResult = frame.getThrowResult();
        final StringBuilder resultBuilder = new StringBuilder();

        final int firstThrow = throwResult.get(0);
        if (firstThrow == 10) {
            return "X";
        }

        resultBuilder.append(firstThrow);

        if (throwResult.size() == 1) {
            return resultBuilder.toString().replace("0", "-");
        }

        resultBuilder.append("|");

        if (firstThrow + throwResult.get(1) == 10) {
            resultBuilder.append("/");
        } else {
            resultBuilder.append(throwResult.get(1));
        }



        return resultBuilder.toString().replace("0", "-");
    }
}
