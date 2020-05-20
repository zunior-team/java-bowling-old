package com.zuniorteam.bowling.core;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BowlingGameTest {

    @DisplayName("생성, null 주입시")
    @Test
    void testNewInstanceIfArgsIsNull(){
        assertThrows(AssertionError.class, () -> new BowlingGame(null));
    }

    @DisplayName("play")
    @Test
    void testPlay(){
        assertThrows(AssertionError.class, () -> new BowlingGame(null));
    }

}