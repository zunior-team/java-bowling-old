package com.zuniorteam.bowling.core.user;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @DisplayName("이름이 없을 때")
    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {" ", "  "})
    void testNewInstanceIfInvalidUsername(String username){
        assertThrows(IllegalArgumentException.class, () -> new User(username));
    }

}