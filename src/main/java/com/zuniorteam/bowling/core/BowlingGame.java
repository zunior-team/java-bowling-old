package com.zuniorteam.bowling.core;

import com.zuniorteam.bowling.core.dto.FrameResultDto;
import com.zuniorteam.bowling.core.frame.Frame;
import com.zuniorteam.bowling.core.frame.impl.FirstFrame;
import com.zuniorteam.bowling.core.step.player.StepPlayer;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static com.zuniorteam.bowling.core.frame.AbstractFrame.END;

public class BowlingGame {

    private final StepPlayer stepPlayer;

    public BowlingGame(StepPlayer stepPlayer){
        assert stepPlayer != null;

        this.stepPlayer = stepPlayer;
    }

    public List<FrameResultDto> play() {
        final List<FrameResultDto> frameResults = new ArrayList<>();

        final Frame firstFrame = new FirstFrame();
        frameResults.add(firstFrame.play(stepPlayer));

        Frame nextFrame = firstFrame;
        while ((nextFrame = nextFrame.createNext()) != END) {
            frameResults.add(nextFrame.play(stepPlayer));
        }

        return frameResults;
    }
}
