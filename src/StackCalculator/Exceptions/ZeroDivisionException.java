package StackCalculator.Exceptions;

public class ZeroDivisionException extends RuntimeException {
    public ZeroDivisionException() {
        super("Деление на ноль");
    }
}
