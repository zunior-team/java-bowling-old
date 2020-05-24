package bowling.state;

import java.util.List;
import java.util.stream.Collectors;

public class GameEnd extends EndState {
    private final List<State> states;

    private GameEnd(final List<State> states) {
        if (states == null) {
            throw new IllegalArgumentException("Invalid states");
        }

        this.states = states;
    }

    public static GameEnd init(final List<State> states) {
        return new GameEnd(states);
    }

    @Override
    public List<Integer> getDownPins() {
        return states.stream()
                .map(State::getDownPins)
                .flatMap(List::stream)
                .collect(Collectors.toList());
    }
}
