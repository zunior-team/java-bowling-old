package com.zuniorteam.bowling.core.frame;

import com.zuniorteam.bowling.core.dto.FrameResultDto;
import com.zuniorteam.bowling.core.step.player.StepPlayer;

public interface Frame {

    Frame createNext();
    FrameResultDto play(StepPlayer stepPlayer);
}
