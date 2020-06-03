package domain.pin;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Pins {
    public static final int MAX_NUMBER_OF_PINS = 10;
    public static final int ZERO = 0;

    private final List<Pin> pins = Stream.generate(Pin::newStandingPin)
            .limit(MAX_NUMBER_OF_PINS)
            .collect(Collectors.toList());

    private Pins() {
    }

    public static Pins newInstance() {
        return new Pins();
    }

    public void throwBall(int fallenPins) {
        validateFallenPins(fallenPins);

        this.pins.stream()
                .filter(Pin::isStanding)
                .limit(fallenPins)
                .forEach(Pin::fall);
    }

    private void validateFallenPins(int fallenPins) {
        if (fallenPins < ZERO) {
            throw new IllegalArgumentException("fallen pins min value is [" + ZERO + "]");
        }
        if (fallenPins > MAX_NUMBER_OF_PINS) {
            throw new IllegalArgumentException("fallen pins max value is [" + MAX_NUMBER_OF_PINS + "]");
        }
        if (leftPins() - fallenPins < ZERO) {
            throw new IllegalArgumentException("left pins must be positive or zero");
        }
    }

    public int leftPins() {
        return (int) this.pins.stream()
                .filter(Pin::isStanding)
                .count();
    }


    public boolean isAllDown() {
        return leftPins() == ZERO;
    }
}
