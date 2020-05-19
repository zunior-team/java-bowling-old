package frame;

import frame.impl.FinalFrame;
import frame.impl.NormalFrame;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import overturn.OverturnScore;
import trial.TrialResult;
import trial.TrialResultType;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("볼링 프레임은")
class BowlingFrameTest {

    @DisplayName("1 ~ 9 프레임에 있는 핀을 넘어트리고 결과를 반환한다.")
    @ParameterizedTest
    @MethodSource("provideOverturnScore")
    void decreasePinsAndGetResult_NormalFrameTest(final int overturnScore, final TrialResultType expectedTrialResultType) {
        // given
        final BowlingFrame bowlingFrame = new NormalFrame();

        // when
        final TrialResult trialResult = bowlingFrame.decreasePinsAndGetResult(new OverturnScore(overturnScore));

        // then
        assertThat(trialResult.getTrialResultType()).isEqualTo(expectedTrialResultType);
    }

    @DisplayName("10 프레임에 있는 핀을 넘어트리고 결과를 반환한다.")
    @ParameterizedTest
    @MethodSource("provideOverturnScore")
    void decreasePinsAndGetResult_FinalFrameTest(final int overturnScore, final TrialResultType expectedTrialResultType) {
        // given
        final BowlingFrame bowlingFrame = new FinalFrame();

        // when
        final TrialResult trialResult = bowlingFrame.decreasePinsAndGetResult(new OverturnScore(overturnScore));

        // then
        assertThat(trialResult.getTrialResultType()).isEqualTo(expectedTrialResultType);
    }

    private static Stream<Arguments> provideOverturnScore(){
        return Stream.of(
            arguments(0, TrialResultType.PROGRESS),
            arguments(1, TrialResultType.PROGRESS),
            arguments(2, TrialResultType.PROGRESS),
            arguments(3, TrialResultType.PROGRESS),
            arguments(4, TrialResultType.PROGRESS),
            arguments(5, TrialResultType.PROGRESS),
            arguments(6, TrialResultType.PROGRESS),
            arguments(7, TrialResultType.PROGRESS),
            arguments(8, TrialResultType.PROGRESS),
            arguments(9, TrialResultType.PROGRESS),
            arguments(10, TrialResultType.STRIKE)
        );
    }
}
