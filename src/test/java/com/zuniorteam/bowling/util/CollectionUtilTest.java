package com.zuniorteam.bowling.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("컬렉션 커스텀 유틸 테스트")
class CollectionUtilTest {

    @DisplayName("simpleMap")
    @Test
    void testSimpleMap() {
        //given
        final List<MockClazz> mockClazzes = new ArrayList<>();

        mockClazzes.add(new MockClazz(1));
        mockClazzes.add(new MockClazz(2));
        mockClazzes.add(new MockClazz(3));

        //then
        final List<Integer> values = CollectionUtil.simpleMap(mockClazzes, MockClazz::getValue);

        //then
        assertThat(values).containsExactly(1, 2, 3);
    }

    public static class MockClazz {

        private int value;

        public MockClazz(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

}