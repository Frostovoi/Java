package SomeTasks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ZeroFront {
    public static List<Integer> zeroFront(List<Integer> numbers) {
        return numbers.stream().sorted(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1 == 0)
                    return -1;
                else if (o2 == 0)
                    return 1;
                else
                    return 0;
            }
        }).collect(Collectors.toList());
    }


    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1,0,2,8,1,0,-4,0,-7,2,9,0,1,4,0));
        list.removeIf(t->t % 2 == 0);
        list = (ArrayList<Integer>) zeroFront(list);

    }
}
