package bowling.player;

import bowling.frame.Frame;
import bowling.frame.Frames;

public class Player {
    private int currentRound;
    private Frames frames;

    private Player() {
        this.currentRound = 1;
        this.frames = Frames.init();
    }

    public void rollTheBall(final int countOfFallenPins) {
        frames.rollTheBall(countOfFallenPins);
    }
}
