package frame;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("볼링 프레임은")
class BowlingFramesTest {

    @Test
    @DisplayName("생성된다.")
    void create() {
        // when
        final BowlingFrames bowlingFrames = BowlingFrames.create();

        // then
        assertThat(bowlingFrames).isNotNull();
    }
}
