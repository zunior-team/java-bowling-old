package domain.pin;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PinTest {

    @Test
    @DisplayName("Pin의 isStanding 기본 값은 true로 생성된다.")
    void createTest() {
        Pin pin = new Pin();

        assertThat(pin).isNotNull();
        assertThat(pin.isStanding()).isTrue();
    }

    @Test
    @DisplayName("Pin 을 넘어뜨릴 수 있다")
    void testFall() {
        Pin pin = new Pin();

        assertThat(pin.isStanding()).isTrue();

        pin.fall();

        assertThat(pin.isStanding()).isFalse();
    }
}