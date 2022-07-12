package Patterns.ObserverPattern.Elevator.exceptions;

public class InvalidMovementOperation extends ElevatorException {

    public InvalidMovementOperation() {
        super("Patterns.ObserverPattern.Elevator can't move this direction");
    }
}
