package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class FrameTest {

    @Test
    @DisplayName("Frame 객체를 생성한다")
    void testNewInstance() {
        final Frame frame = Frame.newInstance();

        assertThat(frame).isNotNull();
    }

    @Test
    @DisplayName("Frame에서 공을 던지면 던진 공의 기록이 남는다")
    void testThrowBall() {
        final Frame frame = Frame.newInstance();

        frame.throwBowlingBall(4);

        assertThat(frame.getFrameHistories())
                .hasSize(1)
                .element(0).isEqualTo(4);
    }

    @ParameterizedTest
    @CsvSource({"1,false", "2,true"})
    @DisplayName("isDone 메소드로 공이 모두 던져졌는지 확인할 수 있다")
    void testIsDone(int throwCount, boolean isDone) {
        final Frame frame = Frame.newInstance();

        for (int i = 0; i < throwCount; i++) {
            frame.throwBowlingBall(3);
        }

        assertThat(frame.isDone())
                .isEqualTo(isDone);
    }

    @Test
    @DisplayName("지정된 회수 이상으로 공을 던질 수 없다")
    void testValidationOverThrow() {
        final Frame frame = Frame.newInstance();

        for (int i = 0; i < Frame.MAX_THROW_COUNT_IN_FRAMES; i++) {
            frame.throwBowlingBall(2);
        }

        assertThrows(IllegalArgumentException.class, () ->
                frame.throwBowlingBall(2));

    }
}