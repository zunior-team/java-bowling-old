package domain;

public class Pins {
    public static final int NUMBER_OF_PINS = 10;
    public static final int ZERO = 0;

    private int countOfPins = NUMBER_OF_PINS;

    private Pins() {
    }

    public static Pins newInstance() {
        return new Pins();
    }


    public void throwBall(int fallenPins) {
        if (fallenPins < ZERO) {
            throw new IllegalArgumentException("fallen pins min value is [" + 0 + "]");
        }
        if (fallenPins > NUMBER_OF_PINS) {
            throw new IllegalArgumentException("fallen pins max value is [" + NUMBER_OF_PINS + "]");
        }
        if (this.countOfPins - fallenPins < ZERO) {
            throw new IllegalArgumentException("left pins must be positive or zero");
        }

        this.countOfPins -= fallenPins;
    }

    public int leftPins() {
        return this.countOfPins;
    }

    public boolean isAllDown() {
        return this.countOfPins == ZERO;
    }
}
