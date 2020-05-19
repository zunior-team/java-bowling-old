package com.zuniorteam.bowling.core.frame.impl;

import com.zuniorteam.bowling.core.value.FrameNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class FirstFrameTest {

    @DisplayName("생성")
    @Test
    void testNewInstance(){
        assertThat(new FirstFrame()).extracting("frameNumber").isEqualTo(FrameNumber.FIRST);
    }

}