package domain;

import com.google.common.base.Strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.joining;

public class Frame {
    public static final int MAX_TURN_IN_FRAMES = 2;
    public static final int ZERO = 0;
    public static final int NUMBER_OF_PINS = 10;

    private List<Integer> turns = new ArrayList<>();


    private Frame() {

    }

    public static Frame newInstanceByFirstThrow(int fallenPins) {
        final Frame frame = new Frame();
        if (fallenPins < ZERO) {
            throw new IllegalArgumentException("fallen pins min value is [" + 0 + "]");
        }
        if (fallenPins > NUMBER_OF_PINS) {
            throw new IllegalArgumentException("fallen pins max value is [" + NUMBER_OF_PINS + "]");
        }
        if (frame.turns.size() > MAX_TURN_IN_FRAMES) {
            throw new IllegalArgumentException("you can only throw " + MAX_TURN_IN_FRAMES + " times in one frame");
        }
        frame.turns.add(fallenPins);
        return frame;
    }


    public boolean isDone() {
        if (turns.size() == MAX_TURN_IN_FRAMES) {
            return true;
        }
        return sumOfFallenPins() == NUMBER_OF_PINS;
    }

    private int sumOfFallenPins() {
        return turns.stream()
                .mapToInt(Integer::intValue)
                .sum();
    }

    @Override
    public String toString() {
        return this.turns.stream().map(String::valueOf).collect(joining("|"));
    }

    public void throwBowlingBall(int fallenPins) {
        if (fallenPins < ZERO) {
            throw new IllegalArgumentException("fallen pins min value is [" + ZERO + "]");
        }
        if (fallenPins > NUMBER_OF_PINS) {
            throw new IllegalArgumentException("fallen pins max value is [" + NUMBER_OF_PINS + "]");
        }
        if (this.turns.size() > MAX_TURN_IN_FRAMES) {
            throw new IllegalArgumentException("you can only throw " + MAX_TURN_IN_FRAMES + " times in one frame");
        }
        this.turns.add(fallenPins);

        if (sumOfFallenPins() > NUMBER_OF_PINS) {
            throw new IllegalArgumentException("sum of fallen pins must be smaller than [" + NUMBER_OF_PINS + "]");
        }
    }
}
