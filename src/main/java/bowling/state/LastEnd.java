package bowling.state;

import java.util.List;
import java.util.stream.Collectors;

public class LastEnd extends EndState {
    private final List<State> states;

    private LastEnd(final List<State> states) {
        if (states == null) {
            throw new IllegalArgumentException("Invalid states");
        }

        this.states = states;
    }
    public static LastEnd init(final List<State> states) {
        return new LastEnd(states);
    }

    @Override
    public List<Integer> getDownPins() {
        return states.stream()
                .map(State::getDownPins)
                .flatMap(List::stream)
                .collect(Collectors.toList());
    }
}
