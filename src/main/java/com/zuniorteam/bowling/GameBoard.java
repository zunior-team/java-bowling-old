package com.zuniorteam.bowling;

import com.zuniorteam.bowling.core.BowlingGame;
import com.zuniorteam.bowling.core.dto.FrameResultDto;
import com.zuniorteam.bowling.core.step.player.impl.RandomStepPlayer;
import com.zuniorteam.bowling.core.user.User;
import com.zuniorteam.bowling.view.InputConsole;
import com.zuniorteam.bowling.view.OutputConsole;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class GameBoard {

    private final InputConsole inputConsole = new InputConsole();
    private final OutputConsole outputConsole = new OutputConsole();

    public void startGame() {
        final User user = InputRender.getUser(inputConsole.readUsername());
        final BowlingGame bowlingGame = new BowlingGame(new RandomStepPlayer(ThreadLocalRandom.current()));

        final List<FrameResultDto> frameResults = bowlingGame.play();

        outputConsole.writeResult(user, frameResults);
    }
}
