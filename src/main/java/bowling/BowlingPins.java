package bowling;

import exception.overturnscore.OverturnMissCountPinsException;
import overturn.OverturnScore;

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

    public int getAlivePinsAfterDecreasePins(final OverturnScore overturnScore){
        this.decreaseAlivePins(overturnScore.getOverturnPins());
        return getAlivePinsCount();
    }

    public int getCurrentAlivePins(){
        return getAlivePinsCount();
    }

    private int getAlivePinsCount() {
        return bowlingPins.stream()
                .filter(BowlingPin::isAlive)
                .mapToInt(pin -> 1)
                .sum();
    }

    private void decreaseAlivePins(int decreasePinsCount) {
        this.validatePinsCount(decreasePinsCount);

        bowlingPins.stream()
                .filter(BowlingPin::isAlive)
                .limit(decreasePinsCount)
                .forEach(BowlingPin::overturn);
    }

    private void validatePinsCount(final int decreasePinsCount){
        final int currentAlivePins = getAlivePinsCount();

        if(decreasePinsCount > currentAlivePins) {
            throw new OverturnMissCountPinsException(currentAlivePins, decreasePinsCount);
        }
    }
}
