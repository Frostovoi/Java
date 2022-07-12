package Patterns.ObserverPattern.Elevator.exceptions;

public class ElevatorException extends RuntimeException {
    public ElevatorException() {
        super("Unknown elevator error");
    }

    public ElevatorException(String msg) {
        super(msg);
    }
}
