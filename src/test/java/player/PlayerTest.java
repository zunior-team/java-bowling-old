package player;

import exception.PlayerCreateException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("플레이어는")
class PlayerTest {

    @DisplayName("이름을 받아 생성된다.")
    @ParameterizedTest
    @ValueSource(strings = {"SON", "PAR", "ZUM", "KEE", "LEE"})
    void create_ValidName_NotNull(final String name){
        // when
        final Player player = Player.create(name);

        // then
        assertThat(player).isNotNull();
    }

    @DisplayName("이름이 널일 시, 생성되지 못한다.")
    @ParameterizedTest
    @NullSource
    void create_NullString_ExceptionThrown(final String name){
        // when & then
        assertThrows(NullPointerException.class, () -> Player.create(name));
    }

    @DisplayName("이름이 공백 또는 세자리를 넘어갈 시 생성되지 못한다.")
    @ParameterizedTest
    @CsvSource({
        "'', PARK, SUNG, DONG"
    })
    void create_InValidName_ExceptionThrown(final String name){
        // when & then
        assertThrows(PlayerCreateException.class, () -> Player.create(name));
    }
}
