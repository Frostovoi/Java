package Patterns.ObserverPattern.Elevator.exceptions;

public class InvalidStoreysException extends ElevatorException {
    private int storeys;

    public InvalidStoreysException(int storeys) {
        this.storeys = storeys;
    }

    @Override
    public String getMessage() {
        return String.format("Incorrect storeys: %d", storeys);
    }
}
