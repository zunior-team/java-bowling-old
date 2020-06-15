package utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;


class StringUtilsTest {

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("입력값에 null 또는 빈 문자열이 들어오면 true를 리턴한다.")
    void testNullOrEmptyTrue(String test) {
        assertThat(StringUtils.isEmpty(test)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {"asdf", "123"})
    @DisplayName("입력값에 null 또는 빈 문자열이 아닌 문자가 들어오면 false를 리턴한다.")
    void testNotNullAndNotEmptyFalse(String test) {
        assertThat(StringUtils.isEmpty(test)).isFalse();
    }


    @ParameterizedTest
    @ValueSource(strings = {"hello", "world"})
    @DisplayName("입력값에 영문자만으로 구성된 문자열이 들어오면 true를 리턴한다.")
    void testIsEnglishLetterOnlyTrue(String test) {
        assertThat(StringUtils.isEnglishLettersOnly(test)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {"asdf123", "123" , "   ", "azxc  "})
    @DisplayName("입력값에 영문자가 아닌 문자가 들어오면 false를 리턴한다.")
    void testIsEnglishLetterOnlyFalse(String test) {
        assertThat(StringUtils.isEnglishLettersOnly(test)).isFalse();
    }



}