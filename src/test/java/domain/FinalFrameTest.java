package domain;

import domain.frame.Frame;
import domain.frame.impl.FinalFrame;
import domain.pin.Pins;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class FinalFrameTest {

    @Test
    @DisplayName("스트라이크이면 한번 더 던질 수 있다.")
    void testStrikeOneMoreChance() {
        final FinalFrame finalFrame = FinalFrame.newInstance();

        finalFrame.throwBowlingBall(10);

        assertThat(finalFrame.isDone()).isFalse();
    }

    @Test
    @DisplayName("스트라이크를 연속 두번 던지면 더이상 던질 수 없다.")
    void testOnlyTwoStrikeAvailable() {
        final FinalFrame finalFrame = FinalFrame.newInstance();

        finalFrame.throwBowlingBall(10);
        finalFrame.throwBowlingBall(10);

        assertThat(finalFrame.isDone()).isTrue();
    }

    @Test
    @DisplayName("스페어면 한번 더 던질 수 있다")
    void testSpareOneMoreChance() {
        final FinalFrame finalFrame = FinalFrame.newInstance();

        final int firstThrow = 3;
        finalFrame.throwBowlingBall(firstThrow);
        finalFrame.throwBowlingBall(Pins.NUMBER_OF_PINS - firstThrow);

        assertThat(finalFrame.isDone()).isFalse();
    }

    @Test
    @DisplayName("스페어나 스트라이크가 아니라면 세번 던질 수는 없다.")
    void testNoChanceIfNotSpareOrStrike() {
        final FinalFrame finalFrame = FinalFrame.newInstance();

        finalFrame.throwBowlingBall(3);
        finalFrame.throwBowlingBall(3);

        assertThat(finalFrame.isDone()).isTrue();
    }

    @Test
    @DisplayName("공을 던지면 공을 던진 이력이 남는다")
    void testHistory() {
        final Frame finalFrame = FinalFrame.newInstance();

        finalFrame.throwBowlingBall(3);

        assertThat(finalFrame.getFrameHistories()).hasSize(1)
                .element(0).isEqualTo(3);
    }

}