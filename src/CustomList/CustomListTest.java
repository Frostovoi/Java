package CustomList;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.*;

public class CustomListTest {

    @Test
    public void add() {
        Integer[] expected = {10,20,30};

        CustomList<Integer> list = new CustomList<Integer>();
        for (int i = 0; i < expected.length; i++) {
            list.add(expected[i]);
        }

        assertEquals(expected.length, list.size());

        Integer[] actual = list.toArray(new Integer[0]);
        HashMap<Integer,Integer> s = new HashMap<>();

        assertArrayEquals(expected, actual);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void getIncorrectIndex(){
        CustomList<Integer> list = new CustomList<Integer>();
        list.add(1,1);
        list.remove(1);
        list.get(1);
        list.set(1,1);
    }

    @Test
    public void addIndex(){
        Integer[] expected = {10,30,40,20};
        CustomList<Integer> customList = new CustomList<Integer>();
        customList.add(10);
        customList.add(30);
        customList.add(20);
        customList.add(2,40);

        assertEquals(expected.length, customList.size());

        Integer[] actual = customList.toArray(new Integer[0]);


        assertArrayEquals(expected,actual);
    }

    @Test
    public void remove(){
        Integer[] expected = {10,20,40};

        CustomList<Integer> customList = new CustomList<Integer>();

        customList.add(10);
        customList.add(20);
        customList.add(30);
        customList.add(40);

        customList.remove(2);

        assertEquals(expected.length, customList.size());

        Integer[] actual = customList.toArray(new Integer[0]);

        assertArrayEquals(expected, actual);
    }

    @Test
    public void indexOf(){
        CustomList<Integer> customList = new CustomList<Integer>();

        customList.add(3);
        customList.add(1);
        customList.add(9);
        customList.add(5);

        int index = customList.indexOf(9);
        int expected = 2;
        assertEquals(expected,index);

        index = customList.indexOf(5);
        expected = 3;
        assertEquals(expected,index);

        index = customList.indexOf(3);
        expected = 0;
        assertEquals(expected,index);

        index = customList.indexOf(4);
        expected = -1;
        assertEquals(expected,index);

    }

    @Test
    public void lastIndexOf(){
        CustomList<Integer> customList = new CustomList<Integer>();

        customList.add(3);
        customList.add(3);
        customList.add(9);
        customList.add(5);
        customList.add(5);
        customList.add(5);

        int index = customList.lastIndexOf(9);
        int expected = 2;
        assertEquals(expected,index);

        index = customList.lastIndexOf(3);
        expected = 1;
        assertEquals(expected,index);

        index = customList.lastIndexOf(5);
        expected = 5;
        assertEquals(expected,index);

        index = customList.indexOf(4);
        expected = -1;
        assertEquals(expected,index);

    }

    @Test
    public void contains(){
        CustomList<Integer> customList = new CustomList<Integer>();
        assertFalse(customList.contains(1));

        customList.add(2);
        assertFalse(customList.contains(1));
        assertTrue(customList.contains(2));

    }

    @Test
    public void isEmpty(){
        CustomList<Integer> customList = new CustomList<Integer>();
        assertTrue(customList.isEmpty());

        customList.add(1);
        assertFalse(customList.isEmpty());

        customList.remove(0);
        assertTrue(customList.isEmpty());

    }

}