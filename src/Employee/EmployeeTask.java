package Employee;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class EmployeeTask {
    public static ArrayList<Employee> readWorkersFile(String fileName){
        ArrayList<Employee> arrayEmployee = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))){
            reader.readLine();
            for (String line = reader.readLine(); line != null; line = reader.readLine()){
                String[] employee = line.split("\\s++");
                arrayEmployee.add(new Employee(employee[0], employee[1], Double.parseDouble(employee[2]), employee[3],
                        Double.parseDouble(employee[4])));
            }
        }
        catch (IOException exc){
            exc.printStackTrace();
        }
        return arrayEmployee;
    }

    public static void readHoursOfFile(ArrayList<Employee> arrayEmployee, String fileName){
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))){
            reader.readLine();
            for (String line = reader.readLine(); line != null; line = reader.readLine()){
                String[] employeeLine = line.split("\\s++");
                String curSurname = employeeLine[1];
                double curHoursWorked = Double.parseDouble(employeeLine[2]);
                for (Employee employee : arrayEmployee){
                    if (employee.getSurname().equals(curSurname))
                        employee.setHoursWorked(curHoursWorked);
                }
            }
        }
        catch (IOException exc){
            exc.printStackTrace();
        }
    }

    public static void printRealSalary(ArrayList<Employee> arrayEmployee){
        System.out.println("Имя" + "\t\t\t" + "Фамилия" + "\t\t" + "Зарплата реальная");
        for(Employee employee : arrayEmployee){
            System.out.println(employee.getName() + "\t\t" + employee.getSurname() + "\t\t" + Math.ceil(employee.realSalary()));
        }
    }

    public static void main(String[] args) {
        ArrayList<Employee> arrayEmployee = readWorkersFile("workers.txt");
        readHoursOfFile(arrayEmployee, "hours_of.txt");
        printRealSalary(arrayEmployee);
    }
}
