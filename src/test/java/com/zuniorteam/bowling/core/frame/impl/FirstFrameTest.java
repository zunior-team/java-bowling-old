package com.zuniorteam.bowling.core.frame.impl;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.zuniorteam.bowling.core.frame.AbstractFrame.FIRST_FRAME;
import static org.assertj.core.api.Assertions.assertThat;

class FirstFrameTest {

    @DisplayName("생성")
    @Test
    void testNewInstance(){
        assertThat(new FirstFrame()).extracting("frameNumber").isEqualTo(FIRST_FRAME);
    }

}