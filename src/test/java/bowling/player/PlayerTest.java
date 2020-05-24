package bowling.player;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

@DisplayName("플레이어 객체에 대한 테스트")
class PlayerTest {

    @Test
    @DisplayName("초기화 테스트 : 이름을 받아서 플레이어 객체 초기화")
    void init() {
        assertThatCode(() -> Player.init("name")).doesNotThrowAnyException();
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("초기화 실패 : 플레이어 이름이 없거나 빈값일때")
    void initFail(final String name) {
        assertThatIllegalArgumentException().isThrownBy(() -> Player.init(name));
    }
}