package bowling.state;

import java.util.*;
import java.util.stream.Collectors;

public class LastPlaying extends State {
    private static final int MAX_TRY_COUNT = 3;

    private final Stack<State> stack;
    private int tryCount;

    private LastPlaying() {
        stack = new Stack<>();
        stack.push(Ready.getInstance());
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
            return GameEnd.init(stack);
        }

        return this;
    }

    private State lastState() {
        return stack.peek();
    }

    // 상태 업데이트
    private void updateStates(final State state) {
        stack.pop();
        stack.push(state);

        giveExtraChance(state);
    }

    // 스트라이크나 스페어라면 추가 기회 제공 but 지금 까지 3회 미만으로 던졌을 때만!
    private void giveExtraChance(State state) {
        if (!isEnd() && (isStrike(state) || isSpare(state))) {
            stack.push(Ready.getInstance());
        }
    }

    // 3번 굴렸거나, 마지막 상태가 MISS면 끝
    @Override
    public boolean isEnd() {
        return tryCount == MAX_TRY_COUNT || isMiss(lastState());
    }

    @Override
    public List<Integer> getDownPins() {
        return stack.stream()
                .map(State::getDownPins)
                .flatMap(List::stream)
                .collect(Collectors.toList());
    }

}
