package bowling.player;

import bowling.frame.Frames;
import bowling.state.State;
import bowling.utils.StringUtils;

import java.util.List;

public class Player {
    public static final int LENGTH_OF_PLAYER_NAME = 3;
    private final String name;
    private final Frames frames;

    private Player(final String name) {
        validate(name);

        this.name = name;
        this.frames = Frames.init();
    }

    private void validate(String name) {
        if (StringUtils.isEmpty(name)) {
            throw new IllegalArgumentException("Player name is null or empty");
        }

        if (name.length() != LENGTH_OF_PLAYER_NAME) {
            throw new IllegalArgumentException("Player name must be " + LENGTH_OF_PLAYER_NAME + " english letter");
        }
    }

    public static Player init(final String name) {
        return new Player(name);
    }

    public void play(final int count) {
        frames.rollTheBall(count);
    }

    public boolean isGameEnd() {
        return frames.isAllFrameEnd();
    }

    public String getName() {
        return name;
    }

    public List<State> getStates() {
        return frames.getStates();
    }
}
