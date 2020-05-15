package bowling;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static bowling.BowlingPinConstant.FIRST_PIN_NUMBER;
import static bowling.BowlingPinConstant.LAST_PIN_NUMBER;

public class BowlingPins {

    private final List<BowlingPin> bowlingPins;

    public BowlingPins() {
        this.bowlingPins = IntStream.rangeClosed(FIRST_PIN_NUMBER, LAST_PIN_NUMBER)
                .mapToObj(pin -> new BowlingPin())
                .collect(Collectors.toList());
    }

    public int getAlivePinsCount() {
        return bowlingPins.stream()
                .filter(BowlingPin::isAlive)
                .mapToInt(pin -> 1)
                .sum();
    }

    public void decreaseAlivePins(int decreasePinsCount) {
        bowlingPins.stream()
                .filter(BowlingPin::isAlive)
                .limit(decreasePinsCount)
                .forEach(BowlingPin::overturn);
    }
}
