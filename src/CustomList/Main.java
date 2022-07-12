package CustomList;

import java.util.ArrayList;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        CustomList list = new CustomList();
        list.add(10);
        list.add(20);
        list.add(5);

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        ArrayList<Integer> arrayList = new ArrayList<>();

        LinkedList<Integer>items = new LinkedList<>();
    }
}
