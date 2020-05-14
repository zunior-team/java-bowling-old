package exception.player;

import exception.master.BowlingException;

public class PlayerCreateException extends BowlingException {

    public PlayerCreateException(String message) {
        super(message);
    }
}
