package Patterns.ObserverPattern.Elevator;

import Patterns.ObserverPattern.Elevator.elevators.*;
import Patterns.ObserverPattern.Elevator.exceptions.IncorrectTypeElevator;

public class FactoryElevator {
    public static SimpleElevator create(int type, int storeys) {
        if (type == 1)
            return new AutomaticElevator(storeys);
        else if (type == 2)
            return new InformativeAutomaticElevator(storeys);
        else if (type == 3)
            return new VeryInformativeAutomaticElevator(storeys);
        else if (type == 4)
            return new RestrictiveAutomaticElevator(storeys);
        else
            throw new IncorrectTypeElevator();
    }
}
