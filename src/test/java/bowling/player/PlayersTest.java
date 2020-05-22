package bowling.player;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

@DisplayName("볼링 플레이어 객체 테스트")
class PlayersTest {

    @ParameterizedTest
    @ValueSource(strings = {"player1", "player1,player2", "player1,player2,player3"})
    @DisplayName("초기화 테스트 : 플레이어 이름을 받아서 플레이어 일급 컬렉션 객체 초기화")
    void init(final String names) {
        assertThatCode(() -> Players.init(names)).doesNotThrowAnyException();
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("초기화 실패 : 플레이어 이름이 없거나 빈값일때")
    void initFail(final String names) {
        assertThatIllegalArgumentException().isThrownBy(() -> Players.init(names));
    }
}