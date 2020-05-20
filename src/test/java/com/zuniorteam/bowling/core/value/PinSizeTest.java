package com.zuniorteam.bowling.core.value;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static com.zuniorteam.bowling.core.value.PinSize.of;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;


@DisplayName("PinSize 테스트")
class PinSizeTest {

    @DisplayName("유효하지 않은 값으로 생성")
    @ParameterizedTest
    @ValueSource(ints = {PinSize.MIN_PIN_SIZE - 1, PinSize.MAX_PIN_SIZE + 1})
    void testNewInstanceIfInvalidValue(int value) {
        assertThrows(IllegalArgumentException.class, () -> of(value));
    }

    @DisplayName("더하기")
    @ParameterizedTest
    @CsvSource({"1,2,3", "2,4,6", "0,5,5"})
    void testAdd(int x, int y, int expected) {
        assertThat(of(x).add(of(y))).isEqualTo(of(expected));
    }

    @DisplayName("빼기")
    @ParameterizedTest
    @CsvSource({"3,2,1", "4,3,1", "5,5,0"})
    void testSubtract(int x, int y, int expected) {
        assertThat(of(x).subtract(of(y))).isEqualTo(of(expected));
    }

    @DisplayName("비교")
    @ParameterizedTest
    @CsvSource({"3,2,MORE", "4,3,MORE", "5,5,SAME", "1,2,LESS"})
    void testCompareTo(int x, int y, Compared expected) {
        assertThat(of(x).compareTo(of(y))).isEqualTo(expected);
    }
}