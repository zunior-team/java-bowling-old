package bowling.state;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LastPlaying extends State {
    private static final int MAX_TRY_COUNT = 3;

    private final List<State> states;
    private int tryCount;

    private LastPlaying() {
        states = new ArrayList<>(MAX_TRY_COUNT);
        states.add(Ready.getInstance());
    }

    public static LastPlaying init() {
        return new LastPlaying();
    }

    @Override
    public State downPins(final int numOfDownPins) {
        tryCount++;
        State state = lastState().downPins(numOfDownPins);

        updateStates(state);

        if (isEnd()) {
            return LastEnd.init(states);
        }

        return this;
    }

    private void updateStates(final State state) {
        // 상태 업데이트
        states.remove(lastIdx());
        states.add(state);

        // 스트라이크나 스페어라면 추가 기회 제공 but 지금 까지 3회 미만으로 던졌을 때만!
        if (!isEnd() && (isStrike(state) || isSpare(state))) {
            states.add(Ready.getInstance());
        }
    }

    // 3번 굴렸거나, 마지막 상태가 MISS면 끝
    @Override
    public boolean isEnd() {
        return tryCount == MAX_TRY_COUNT || isLastStateMiss();
    }

    @Override
    public List<Integer> getDownPins() {
        return states.stream()
                .map(State::getDownPins)
                .flatMap(List::stream)
                .collect(Collectors.toList());
    }

    private boolean isLastStateMiss() {
        return isMiss(lastState());
    }

    private State lastState() {
        return states.get(lastIdx());
    }

    private int lastIdx() {
        return states.size() - 1;
    }
}
