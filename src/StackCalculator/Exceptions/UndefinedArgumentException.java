package StackCalculator.Exceptions;

public class UndefinedArgumentException extends StackException {

    public UndefinedArgumentException() {
        super("Переменная отсутствует в словаре");
    }
}
