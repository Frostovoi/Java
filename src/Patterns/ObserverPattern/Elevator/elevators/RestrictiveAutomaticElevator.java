package Patterns.ObserverPattern.Elevator.elevators;

import java.util.HashSet;

public class RestrictiveAutomaticElevator extends AutomaticElevator {
    private HashSet <Integer> restrictedStoreys = new HashSet<>();
    public RestrictiveAutomaticElevator(int storeys) {
        super(storeys);
    }


    public void restrictStorey(int storey) {
        restrictedStoreys.add(storey);
    }

    @Override
    public void moveTo(int storey) {
        if (!restrictedStoreys.contains(storey))
            super.moveTo(storey);
    }
}
