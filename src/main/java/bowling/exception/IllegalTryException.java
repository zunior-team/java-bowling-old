package bowling.exception;

public class IllegalTryException extends RuntimeException {
    public IllegalTryException() {
        super("Can't try bowling like this");
    }
}
