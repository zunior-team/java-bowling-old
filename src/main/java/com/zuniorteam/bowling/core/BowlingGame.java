package com.zuniorteam.bowling.core;

import com.zuniorteam.bowling.core.dto.FrameResultDto;
import com.zuniorteam.bowling.core.frame.Frame;
import com.zuniorteam.bowling.core.frame.impl.FirstFrame;
import com.zuniorteam.bowling.core.frame.impl.NormalFrame;
import com.zuniorteam.bowling.core.step.player.StepPlayer;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static com.zuniorteam.bowling.core.frame.Frame.FIRST_FRAME;

public class BowlingGame {

    public static final int NUMBER_OF_PIN = 10;

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
        while (Objects.nonNull(nextFrame = nextFrame.createNext())) {
            frameResults.add(nextFrame.play(stepPlayer));
        }

        return frameResults;
    }
}
