package overturn;

import exception.overturnscore.OverturnScoreCreateException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("넘어트린 핀의 점수는")
class OverturnScoreTest {

    @DisplayName("점수를 받아 생성된다.")
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3, 5, 10})
    public void create_ValidScore_Success(final int overturnPins){
        // when
        final OverturnScore overturnScore = new OverturnScore(overturnPins);

        // then
        assertThat(overturnScore).isNotNull();
    }

    @DisplayName("잘못된 점수를 받아 생성되지 못한다.")
    @ParameterizedTest
    @ValueSource(ints = {-1, 11})
    public void create_InValidScore_ExceptionThrown(final int overturnPins) {
        // when & then
        assertThrows(OverturnScoreCreateException.class, () -> new OverturnScore(overturnPins));
    }
}
