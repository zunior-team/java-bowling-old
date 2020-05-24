package bowling.pin;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Pin {
    public static final int MAX_COUNT_OF_PINS = 10;
    public static final int READY_STATE_VALUE = -1;
    public static final Pin READY = new Pin(READY_STATE_VALUE);

    public static final Map<Integer, Pin> PINS = IntStream.rangeClosed(0, MAX_COUNT_OF_PINS)
            .mapToObj(Pin::new)
            .collect(Collectors.toMap(Pin::getPins, Function.identity()));

    private final int downPin;

    private Pin(final int downPin) {
        this.downPin = downPin;
    }

    public static Pin of(final int downPins) {
        return PINS.get(downPins);
    }

    public int getPins() {
        return downPin;
    }
}
