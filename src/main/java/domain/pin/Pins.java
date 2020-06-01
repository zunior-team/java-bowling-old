package domain.pin;

public class Pins {
    public static final int MAX_NUMBER_OF_PINS = 10;
    public static final int ZERO = 0;

    private int countOfPins = MAX_NUMBER_OF_PINS;

    private Pins() {
    }

    public static Pins newInstance() {
        return new Pins();
    }


    public void throwBall(int fallenPins) {
        validateFallenPins(fallenPins);

        this.countOfPins -= fallenPins;
    }

    private void validateFallenPins(int fallenPins) {
        if (fallenPins < ZERO) {
            throw new IllegalArgumentException("fallen pins min value is [" + ZERO + "]");
        }
        if (fallenPins > MAX_NUMBER_OF_PINS) {
            throw new IllegalArgumentException("fallen pins max value is [" + MAX_NUMBER_OF_PINS + "]");
        }
        if (this.countOfPins - fallenPins < ZERO) {
            throw new IllegalArgumentException("left pins must be positive or zero");
        }
    }

    public int leftPins() {
        return this.countOfPins;
    }

    public boolean isAllDown() {
        return this.countOfPins == ZERO;
    }
}
