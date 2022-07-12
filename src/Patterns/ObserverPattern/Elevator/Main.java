package Patterns.ObserverPattern.Elevator;

import Patterns.ObserverPattern.Elevator.elevators.SimpleElevator;
import Patterns.ObserverPattern.Elevator.exceptions.ElevatorException;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<SimpleElevator> elevators = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < 5; i++) {
            System.out.println("Выберите тип");
            int type = scanner.nextInt();

            System.out.println("Введите кол-во этажей");
            int storeys = scanner.nextInt();

            try {
                SimpleElevator elevator = FactoryElevator.create(type, storeys);
                elevators.add(elevator);
            } catch (ElevatorException exc) {
                System.out.println(exc.getMessage());
                i--;
            }
        }
        Random random = new Random();
        for(var elevator : elevators){
            elevator.moveTo(random.nextInt(elevator.getStoreys()));
        }


    }
}
