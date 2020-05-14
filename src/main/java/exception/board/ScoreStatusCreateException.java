package exception.board;

import exception.master.BowlingException;

public class ScoreStatusCreateException extends BowlingException {
    public ScoreStatusCreateException(String message) {
        super(message);
    }
}
