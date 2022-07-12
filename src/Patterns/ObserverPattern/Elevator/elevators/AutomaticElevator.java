package Patterns.ObserverPattern.Elevator.elevators;

import Patterns.ObserverPattern.Elevator.exceptions.InvalidMovementOperation;

public class AutomaticElevator extends SimpleElevator {

    public AutomaticElevator(int storeys) {
        super(storeys);
    }

    protected void upN(int N) {
        if (getCurrentStorey() + N > getStoreys() || N < 1)
            throw new InvalidMovementOperation();
        for (int i = 0; i < N; i++) {
            up();
        }
    }

    protected void downN(int N) {
        if (getCurrentStorey() - N <= 0 || N < 1)
            throw new InvalidMovementOperation();
        for (int i = 0; i < N; i++) {
            down();
        }
    }

    @Override
    public void  moveTo(int storey) {
        if (storey < 1 || storey > getStoreys())
            throw new InvalidMovementOperation();
        if (getCurrentStorey() < storey)
            upN(storey - getCurrentStorey());
        else
            downN(getCurrentStorey() - storey);
    }
}
