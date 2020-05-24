package bowling;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatCode;

@DisplayName("볼링 객체 테스트")
class BowlingTest {

    @ParameterizedTest
    @ValueSource(strings = {"player1", "player1,player2", "player1,player2,player3"})
    @DisplayName("초기화 테스트 : 사람 이름을 받아서 볼링 객체 초기화")
    void init(final String names) {
        assertThatCode(() -> Bowling.init(names)).doesNotThrowAnyException();
    }
}