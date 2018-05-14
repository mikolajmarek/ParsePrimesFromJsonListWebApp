package pl.mj.exception;

public class IncorrectElementInListException extends RuntimeException {
    public IncorrectElementInListException(String message) {
        super(message);
    }
}