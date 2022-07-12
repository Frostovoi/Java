package SomeTasks;

import java.util.*;
import java.util.stream.Collectors;

public class StreamApiTask {
    static boolean CheckOdd(int number) {
        return  number % 2 == 0;
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(20, 70, 55, 79, 22));

        int count = (int)list.stream().filter(StreamApiTask::CheckOdd).count();
        System.out.println("Кол-во четных = " + count);

        List<Integer> oddNumbers = list.stream().filter(t -> t % 2 == 0).collect(Collectors.toList());
        oddNumbers.forEach(System.out::println);

        Optional<Integer> res = list.stream().max(Integer::compareTo);
        if (res.isPresent()) {
            System.out.println(res.get());
        }
    }
}
