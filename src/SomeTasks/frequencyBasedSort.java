package SomeTasks;

import java.util.*;
import java.util.stream.Collectors;

public class frequencyBasedSort {
    public static List<Integer> sortList(List<Integer> numbers) {
        HashMap <Integer,Integer> map = new HashMap<>();
        for (var num : numbers) {
            map.put(num, map.getOrDefault(num,0) + 1);
        }

//        List<Map.Entry<Integer, Integer>> newNumbers =map.entrySet().stream()
//                .sorted(Map.Entry.<Integer, Integer>comparingByKey().reversed())
//                .sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed()).collect(Collectors.toList());

        List<Map.Entry<Integer, Integer>> newNumbers =map.entrySet().stream()
                   .sorted(new Comparator<Map.Entry<Integer, Integer>>() {
                       @Override
                       public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                           if (o1.getValue() > o2.getValue())
                               return 1;
                           else if (o1.getValue() < o2.getValue())
                               return -1;
                           return Integer.compare(o1.getKey(), o2.getKey());
                       }
                   }.reversed()).collect(Collectors.toList());

        List<Integer> lastNumbers = new ArrayList<>();
        for (var number : newNumbers) {
            for (int i = 0; i < number.getValue(); i++) {
                lastNumbers.add(number.getKey());
            }
        }
        return lastNumbers;
    }

    public static void main(String[] args) {
        ArrayList <Integer> numbers = new ArrayList<>(Arrays.asList(1,2,3,4,5,1,2,2,3,3,1));
        System.out.println(sortList(numbers));


    }
}
