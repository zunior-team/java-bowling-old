package bowling.pin;

public class Pins {
    private static final int MAX_COUNT_OF_PINS = 10;
    private int firstFallPins;
    private int secondFallPins;

    private Pins() {}

    private Pins(final int firstFallPins, final int secondFallPins) {
        this.firstFallPins = firstFallPins;
        this.secondFallPins = secondFallPins;
    }

    public static Pins init() {
        return new Pins();
    }

    private Pins roll(final int firstFallPins, final int secondFallPins) {
        return new Pins(firstFallPins, secondFallPins);
    }

    public Pins firstRoll(int countOfFallenPins) {
        return roll(countOfFallenPins, 0);
    }

    public Pins secondRoll(final int countOfFallenPins) {
        return roll(this.firstFallPins, countOfFallenPins);
    }

    public boolean isAllFallen() {
        return firstFallPins + secondFallPins == MAX_COUNT_OF_PINS;
    }
}
