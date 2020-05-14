package exception;

import exception.bowling.BowlingException;

public class PlayerCreateException extends BowlingException {

    public PlayerCreateException(String message) {
        super(message);
    }
}
