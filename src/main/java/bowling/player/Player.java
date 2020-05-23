package bowling.player;

import bowling.frame.Frames;
import bowling.utils.StringUtils;

public class Player {
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
}
