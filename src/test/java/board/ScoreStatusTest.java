package board;

import frame.BowlingFrame;
import frame.FinalFrame;
import frame.NormalFrame;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("점수 상태는")
class ScoreStatusTest {

    private static final int LAST_NUMBER_OF_FRAME = 10;

    @ParameterizedTest
    @MethodSource("provideScoreStatus")
    @DisplayName("new 예약어를 통해 생성된다.")
    public void constructor_UseNewKeyword_CreateSuccess(final String name, final List<BowlingFrame> bowlingFrames) {
        // when
        final ScoreStatus scoreStatus = new ScoreStatus(name, bowlingFrames);

        // then
        assertThat(scoreStatus).isNotNull();
    }

    private static Stream<Arguments> provideScoreStatus() {
        return Stream.of(
                Arguments.of("KOK", IntStream.rangeClosed(1, LAST_NUMBER_OF_FRAME)
                        .mapToObj(i -> (i == LAST_NUMBER_OF_FRAME) ? new FinalFrame() : new NormalFrame())
                        .collect(Collectors.toList()))

        );
    }
}
