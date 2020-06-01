package domain;

import domain.frame.impl.NormalFrame;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class NormalFrameTest {

    @Test
    @DisplayName("Frame 객체를 생성한다")
    void testNewInstance() {
        final NormalFrame normalFrame = NormalFrame.newInstance();

        assertThat(normalFrame).isNotNull();
    }

    @Test
    @DisplayName("Frame에서 공을 던지면 던진 공의 기록이 남는다")
    void testThrowBall() {
        final NormalFrame normalFrame = NormalFrame.newInstance();

        normalFrame.throwBowlingBall(4);

        assertThat(normalFrame.getFrameHistories())
                .hasSize(1)
                .element(0).isEqualTo(4);
    }

    @ParameterizedTest
    @CsvSource({"1,false", "2,true"})
    @DisplayName("isDone 메소드로 공이 모두 던져졌는지 확인할 수 있다")
    void testIsDone(int throwCount, boolean isDone) {
        final NormalFrame normalFrame = NormalFrame.newInstance();

        for (int i = 0; i < throwCount; i++) {
            normalFrame.throwBowlingBall(3);
        }

        assertThat(normalFrame.isDone())
                .isEqualTo(isDone);
    }

    @Test
    @DisplayName("지정된 2 이상회으로 공을 던질 수 없다")
    void testValidationOverThrow() {
        final NormalFrame normalFrame = NormalFrame.newInstance();

        for (int i = 0; i < 2; i++) {
            normalFrame.throwBowlingBall(2);
        }

        assertThrows(IllegalArgumentException.class, () ->
                normalFrame.throwBowlingBall(2));

    }
}