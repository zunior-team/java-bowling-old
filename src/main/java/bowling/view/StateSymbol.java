package bowling.view;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum StateSymbol {
    READY(-1, " "),
    ZERO(0, "-"),
    TEN(10, "X");

    private static final Map<Integer, String> SYMBOLS = Stream.of(values())
            .collect(Collectors.toMap(StateSymbol::getNum, StateSymbol::getSymbol));

    private final int num;
    private final String symbol;

    StateSymbol(final int num, final String symbol) {
        this.num = num;
        this.symbol = symbol;
    }

    public static String convert(final int num) {
        return SYMBOLS.getOrDefault(num, String.valueOf(num));
    }

    private int getNum() {
        return num;
    }

    private String getSymbol() {
        return symbol;
    }
}
