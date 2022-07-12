package StackCalculator.Exceptions;

public class IncorrectArgumentException extends RuntimeException {
    public IncorrectArgumentException() {
        super("Задан некоректный аргумент");
    }
}
