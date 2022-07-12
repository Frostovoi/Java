package Patterns.ObserverPattern.Elevator.elevators;

import Patterns.ObserverPattern.Elevator.exceptions.InvalidMovementOperation;
import Patterns.ObserverPattern.Elevator.exceptions.InvalidStoreysException;

public abstract class SimpleElevator {
    private int storeys;
    private int currentStorey;

    public SimpleElevator(int storeys) {
        if (storeys < 1) {
            throw new InvalidStoreysException(storeys);
        }
        this.storeys = storeys;
        currentStorey = 1;
    }

    protected void up(){
        if (currentStorey == storeys)
            throw new InvalidMovementOperation();
        else
            currentStorey += 1;
    }

    protected void down() {
        if (currentStorey == 1)
            throw new InvalidMovementOperation();
        else
            currentStorey -= 1;
    }

    public int getStoreys() {
        return storeys;
    }

    public int getCurrentStorey() {
        return currentStorey;
    }

    public abstract void moveTo(int storey);
}
