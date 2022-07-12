package StackCalculator.Exceptions;

public class EmptyStackException extends RuntimeException {

    public EmptyStackException() {
        super("Stack is Empty");
    }
}
