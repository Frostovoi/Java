package Patterns.ObserverPattern.Elevator.elevators;

public class VeryInformativeAutomaticElevator extends InformativeAutomaticElevator {

    public VeryInformativeAutomaticElevator(int storeys) {
        super(storeys);
    }

    @Override
    protected void upN(int N) {
        System.out.println("Лифт едет вверх на " + N + " этажей");
        super.upN(N);
    }

    @Override
    protected void downN(int N) {
        System.out.println("Лифт едет вниз на " + N + " этажей");
        super.downN(N);
    }
}
