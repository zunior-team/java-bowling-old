package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class BowlingTest {

    @Test
    @DisplayName("player가 null이면 볼링 객체를 생성할 수 없다")
    void testNullPlayer() {
        assertThrows(NullPointerException.class, () ->
                Bowling.newInstance(null)
        );
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 5, 10})
    @DisplayName("볼링 객체르 통해 공을 던질 수 있다.")
    void testThrowBall(int fallenPins) {
        final Bowling bowling = Bowling.newInstance(Player.of("tst"));

        assertDoesNotThrow(() ->
                bowling.throwBowlingBall(fallenPins)
        );
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 12})
    @DisplayName("볼링 객체르 통해 지정된 핀의 갯수의 범위를 벗어나서는 공을 던질 수 없다")
    void testThrowBallNotInRange(int fallenPins) {
        final Bowling bowling = Bowling.newInstance(Player.of("tst"));

        assertThrows(IllegalArgumentException.class, () ->
                bowling.throwBowlingBall(fallenPins)
        );
    }
}