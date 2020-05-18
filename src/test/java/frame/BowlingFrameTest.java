package frame;

import frame.impl.NormalFrame;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import overturn.OverturnScore;
import trial.TrialResult;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("볼링 프레임은")
class BowlingFrameTest {

    @DisplayName("현재 프레임에 있는 핀을 넘어트리고 결과를 반환한다.")
    @ParameterizedTest
    @MethodSource("provideOverturnScore")
    void decreasePinsAndGetResult_NormalFrameTest(final OverturnScore overturnScore) {
        // given
        final BowlingFrame bowlingFrame = new NormalFrame();

        // when
        final TrialResult trialResult = bowlingFrame.decreasePinsAndGetResult(overturnScore);

        // then

    }

    private static Stream<Arguments> provideOverturnScore(){
        return Stream.of(
            arguments(new OverturnScore(0)),
            arguments(new OverturnScore(1)),
            arguments(new OverturnScore(2)),
            arguments(new OverturnScore(3)),
            arguments(new OverturnScore(4)),
            arguments(new OverturnScore(5)),
            arguments(new OverturnScore(6)),
            arguments(new OverturnScore(7)),
            arguments(new OverturnScore(8)),
            arguments(new OverturnScore(9)),
            arguments(new OverturnScore(10))
        );
    }
}
