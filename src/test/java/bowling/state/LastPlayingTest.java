package bowling.state;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

@DisplayName("마지막 프레임 테스트")
class LastPlayingTest {
    @Test
    @DisplayName("테스트")
    void test() {
        LastPlaying frameState = LastPlaying.init();

        System.out.println("초기화 직후");
        System.out.println(Arrays.toString(frameState.getDownPins().toArray()));

        State state = frameState.downPins(10);
        System.out.println("10 던진후");
        System.out.println(Arrays.toString(state.getDownPins().toArray()));
        state = frameState.downPins(10);
        System.out.println("10 던진후");
        System.out.println(Arrays.toString(state.getDownPins().toArray()));
        state = frameState.downPins(10);
        System.out.println("10 던진후");
        System.out.println(Arrays.toString(state.getDownPins().toArray()));
    }

    @Test
    @DisplayName("테스트")
    void test2() {
        LastPlaying frameState = LastPlaying.init();

        System.out.println("초기화 직후");
        System.out.println(Arrays.toString(frameState.getDownPins().toArray()));

        State state = frameState.downPins(2);
        System.out.println("2 던진후");
        System.out.println(Arrays.toString(state.getDownPins().toArray()));
        state = frameState.downPins(1);
        System.out.println("1 던진후");
        System.out.println(Arrays.toString(state.getDownPins().toArray()));
        System.out.println("Is End : " + state.isEnd());
    }

    @Test
    @DisplayName("테스트")
    void test4() {
        LastPlaying frameState = LastPlaying.init();

        System.out.println("초기화 직후");
        System.out.println(Arrays.toString(frameState.getDownPins().toArray()));

        State state = frameState.downPins(10);
        System.out.println("10 던진후");
        System.out.println(Arrays.toString(state.getDownPins().toArray()));
        state = frameState.downPins(1);
        System.out.println("1 던진후");
        System.out.println(Arrays.toString(state.getDownPins().toArray()));
        System.out.println("Is End : " + state.isEnd());
        state = frameState.downPins(9);
        System.out.println("9 던진후");
        System.out.println(Arrays.toString(state.getDownPins().toArray()));
        System.out.println("Is End : " + state.isEnd());
    }

    @Test
    @DisplayName("테스트")
    void test3() {
        LastPlaying frameState = LastPlaying.init();

        System.out.println("초기화 직후");
        System.out.println(Arrays.toString(frameState.getDownPins().toArray()));

        State state = frameState.downPins(2);
        System.out.println("2 던진후");
        System.out.println(Arrays.toString(state.getDownPins().toArray()));
        state = frameState.downPins(8);
        System.out.println("8 던진후");
        System.out.println(Arrays.toString(state.getDownPins().toArray()));
        System.out.println("Is End : " + state.isEnd());
        state = frameState.downPins(1);
        System.out.println("1 던진후");
        System.out.println(Arrays.toString(state.getDownPins().toArray()));
        System.out.println("Is End : " + state.isEnd());
    }
}