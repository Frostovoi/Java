package Inheritance;

import java.math.BigDecimal;

public class Employee extends Person {
    private BigDecimal salary;

    public Employee(String name, String surname, BigDecimal salary) {
        super(name, surname);
        this.salary = salary;
    }

    public BigDecimal getSalary() {
        return salary;
    }
}
