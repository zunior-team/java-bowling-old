package bowling.frame;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;

@DisplayName("프레임 일급 컬렉션 테스트")
class FramesTest {

    @Test
    @DisplayName("초기화 : init 팩토리 메서드 테스트")
    void init() {
        assertThatCode(() -> Frames.init()).doesNotThrowAnyException();
    }
}