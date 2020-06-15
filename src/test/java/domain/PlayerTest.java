package domain;

import domain.player.Player;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PlayerTest {

    @ParameterizedTest
    @ValueSource(strings = {"한글이름", "longName", "123", "j w"})
    @NullAndEmptySource
    @DisplayName("영어이름이 아닌 이름, 길이가 맞지 않는 이름, NULL, 빈 문자열 등으로 Player를 생성할 수 없다.")
    void testNotValidName(String name) {
        assertThrows(IllegalArgumentException.class,
                () -> Player.of(name));
    }

    @ParameterizedTest
    @ValueSource(strings = {"cjw", "lck"})
    @DisplayName("지정된 길이의 이름으로 Player 를 생성한다")
    void testValidName(String name) {
        final Player player = Player.of(name);
        
        assertThat(player).isNotNull();
    }

    @ParameterizedTest
    @ValueSource(strings = {"cjw", "lck"})
    @DisplayName("생성된 Player의 toString()은 name과 동일하다")
    void testToString(String name) {
        final Player player = Player.of(name);

        assertThat(player.toString()).isEqualTo(name);
    }

    
}