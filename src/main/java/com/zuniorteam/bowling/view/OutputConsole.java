package com.zuniorteam.bowling.view;

import com.zuniorteam.bowling.core.dto.PitchResult;
import com.zuniorteam.bowling.view.render.ScoreRender;

import java.util.List;

public class OutputConsole {

    public void writeScore(String username, List<PitchResult> pitchResults) {
        System.out.println(ScoreRender.rend(username, pitchResults));
    }

}
