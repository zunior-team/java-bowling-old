package com.zuniorteam.bowling;

import com.zuniorteam.bowling.core.dto.PitchResult;
import com.zuniorteam.bowling.core.frame.Frame;
import com.zuniorteam.bowling.core.frame.impl.NormalFrame;
import com.zuniorteam.bowling.core.pitch.Pitch;
import com.zuniorteam.bowling.core.user.User;
import com.zuniorteam.bowling.core.value.FrameNumber;
import com.zuniorteam.bowling.core.value.PinSize;
import com.zuniorteam.bowling.core.value.PitchType;
import com.zuniorteam.bowling.view.InputConsole;
import com.zuniorteam.bowling.view.OutputConsole;

import java.util.ArrayList;
import java.util.List;

import static com.zuniorteam.bowling.InputRender.getFallenPin;

public class GameBoard {

    private final InputConsole inputConsole = new InputConsole();
    private final OutputConsole outputConsole = new OutputConsole();

    public void startGame() {
        final User user = InputRender.getUser(inputConsole.readUsername());
        final String username = user.getUsername();

        final Frame firstFrame = new NormalFrame(FrameNumber.FIRST);
        final Pitch firstPitch = new Pitch(firstFrame, PitchType.FIRST);

        playPitch(firstPitch, username, new ArrayList<>());
    }

    private void playPitch(Pitch pitch, String username, List<PitchResult> pitchResults) {
        if(pitch.equals(Pitch.END)){
            return;
        }

        final PinSize fallenPinSize = getFallenPin(inputConsole.readFallenPin(pitch.getFrameNumber()));
        final PitchResult playResult = pitch.play(fallenPinSize);
        pitchResults.add(playResult);

        outputConsole.writeScore(username, pitchResults);

        playPitch(pitch.next(), username, pitchResults);
    }

}
