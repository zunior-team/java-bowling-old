package board;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("점수 스냅샷은")
class ScoreSnapshotTest {

    @DisplayName("스냅샷 요소를 하나 추가한다.")
    @ParameterizedTest
    @ValueSource(strings = {"X", "/", "-", "1", "2"})
    void addTest(String element) {
        // given
        final ScoreSnapshot scoreSnapshot = ScoreSnapshot.createSnapShotEmpty(0);
    }
}