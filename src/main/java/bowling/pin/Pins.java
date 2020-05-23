package bowling.pin;

public class Pins {
    public static final int MAX_COUNT_OF_PINS = 10;

    private int firstFallPins;
    private int secondFallPins;

    protected Pins() {}

    private Pins(final int firstFallPins, final int secondFallPins) {
        this.firstFallPins = firstFallPins;
        this.secondFallPins = secondFallPins;
    }

    public static Pins init() {
        return new Pins();
    }

    private Pins down(final int firstFallPins, final int secondFallPins) {
        return new Pins(firstFallPins, secondFallPins);
    }

    public Pins secondRoll(final int countOfFallenPins) {
        return down(this.firstFallPins, countOfFallenPins);
    }

    public boolean isAllDown() {
        return firstFallPins + secondFallPins == MAX_COUNT_OF_PINS;
    }

    public boolean isPinLeft() {
        return firstFallPins + secondFallPins < MAX_COUNT_OF_PINS;
    }

    public void downPins(int numOfDownPins) {
        this.firstFallPins = numOfDownPins;
    }

    public void downLeftPins(int numOfDownPins) {
        this.secondFallPins = numOfDownPins;
    }
}
