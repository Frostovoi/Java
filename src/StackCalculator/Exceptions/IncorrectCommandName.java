package StackCalculator.Exceptions;

public class IncorrectCommandName extends RuntimeException {
    public IncorrectCommandName() {
        super("Команды с указанным именем не существует");
    }
}
