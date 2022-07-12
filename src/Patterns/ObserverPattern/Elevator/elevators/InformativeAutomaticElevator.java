package Patterns.ObserverPattern.Elevator.elevators;

public class InformativeAutomaticElevator extends AutomaticElevator{
    public InformativeAutomaticElevator(int storeys) {
        super(storeys);
    }

    @Override
    protected void up() {
        super.up();
        System.out.println("Номер текущего этажа:" + getCurrentStorey());
    }

    @Override
    protected void down() {
        super.down();
        System.out.println("Номер текущего этажа:" + getCurrentStorey());
    }
}
