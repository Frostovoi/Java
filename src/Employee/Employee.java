package Employee;

public class Employee {
    private String name;
    private String surname;
    private String position;
    private double salary;
    private double workRate;
    private double hoursWorked;
    private double salaryPerHour;

    Employee(String name, String surname, double salary, String position, double workRate){
        this.name = name;
        this.surname = surname;
        this.salary = salary;
        this.position = position;
        this.workRate = workRate;
    }

    public double realSalary(){
        double hoursDiff = workRate - hoursWorked;
        double realSalary;
        if (hoursDiff < 0)
            realSalary = salary * hoursWorked / workRate;
        else
            realSalary = salary + hoursDiff * salaryPerHour * 2;
        return realSalary;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getWorkRate() {
        return workRate;
    }

    public void setWorkRate(double workRate) {
        this.workRate = workRate;
    }

    public double getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(double hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public double getSalaryPerHour() {
        return salaryPerHour;
    }

    public void setSalaryPerHour(double salaryPerHour) {
        this.salaryPerHour = salaryPerHour;
    }
}
