package Inheritance;

import java.math.BigDecimal;

public class Coach extends Employee {
    private int experience;


    public Coach(String name, String surname, BigDecimal salary, int experience) {
        super(name, surname, salary);
        this.experience = experience;
    }

    public int getExperience() {
        return experience;
    }
}
