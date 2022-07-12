package Inheritance;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Optional;
import java.util.OptionalDouble;

public class Main {
    public static void main(String[] args) {
        ArrayList<Person> people = new ArrayList<>();
        Client client = new Client("Ivan", "Orlov", "VIP");
        Coach coach = new Coach("Oleg", "Popov", new BigDecimal(50000), 5);
        Coach coach2 = new Coach("Alex", "XXX", new BigDecimal(90000), 11);
        Manager manager = new Manager("Anna", "Ivanova", new BigDecimal(30000));

        people.add(client);
        people.add(coach);
        people.add(manager);
        people.add(coach2);

        for(Person p : people) {
            System.out.println(p.getSurname() + " " + p.getName());
        }

      OptionalDouble optionalDouble = people.stream().filter(t->t instanceof Coach).mapToInt(t->((Coach) t).getExperience()).average();
        if (optionalDouble.isPresent())
            System.out.println(optionalDouble.getAsDouble());

        BigDecimal res = people.stream().
                filter(t->t instanceof Coach).
                map(t->((Coach) t).getSalary()).
                reduce(BigDecimal.ZERO, BigDecimal::add);


//        BigDecimal sum = new BigDecimal(0);
//        int count = 0;
//
//        for(Person p : people) {
//            if (p instanceof Coach){
//                sum = sum.add(((Coach) p).getSalary());
//                count++;
//            //System.out.println(p.getSurname());
//            }
//        }
//
//        BigDecimal avg = sum.divide(new BigDecimal(count));
//        System.out.println(avg);
    }
}
