package StackCalculator.Exceptions;

public class StackException extends  RuntimeException {

    public StackException() {
        super("Something goes wrong");
    }


    public StackException(String message) {
        super(message);
    }
}
