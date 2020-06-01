package domain;

import java.util.Objects;

public class Bowling {

    private final Player player;
    private final Frames frames;

    private Bowling(Player player) {
        Objects.requireNonNull(player, "player cannot be null");
        this.player = player;
        this.frames = Frames.newInstance();
    }

    public static Bowling newInstance(Player player) {
        return new Bowling(player);
    }

    public Player getPlayer() {
        return player;
    }

    public Frames getFrames() {
        return frames;
    }

    public boolean isEnd() {
        return frames.isEnd();
    }

    public void throwBowlingBall(int inputFallenPins) {
        frames.throwBowlingBall(inputFallenPins);
    }
}
