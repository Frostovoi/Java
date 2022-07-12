package CustomList;

import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.*;

public class CustomLListTest {

    @Test
    public void addLast() {
        int[] expected = {10};
        CustomLList customLList = new CustomLList();
        customLList.addLast(10);
        assertEquals(expected.length,customLList.size());

        assertArrayEquals(expected, customLList.toArray());

        int[] expected2 = {10,30,20};
        customLList.addLast(30);
        customLList.addLast(20);
        assertEquals(expected2.length,customLList.size());
        assertArrayEquals(expected2, customLList.toArray());

    }

    @Test
    public void addFirst() {

        int[] expected = {10};
        CustomLList customLList = new CustomLList();
        customLList.addFirst(10);
        assertEquals(expected.length,customLList.size());

        assertArrayEquals(expected, customLList.toArray());


        CustomLList customLList1 = new CustomLList();
        int[] expected2 = {10,30,20};
        customLList1.addFirst(20);
        customLList1.addFirst(30);
        customLList1.addFirst(10);
        assertEquals(expected2.length,customLList1.size());
        assertArrayEquals(expected2, customLList1.toArray());
    }

    @Test
    public void add() {
        int[] expected = {1,9,5,4,8,8,1,0};
        CustomLList customLList = new CustomLList();
        customLList.addLast(9);
        customLList.addLast(5);
        customLList.addLast(8);
        customLList.addLast(8);
        customLList.addLast(1);

        customLList.add(0,1);   //195881
        customLList.add(6,0);   //1958810
        customLList.add(3,4);   //19548810

        assertEquals(expected.length,customLList.size());
        assertArrayEquals(expected,customLList.toArray());


    }

    @Test
    public void removeFirst() {
        int[] expected = {};
        CustomLList customLList = new CustomLList();
        customLList.addLast(10);
        customLList.removeFirst();
        assertEquals(expected.length, customLList.size());
        assertArrayEquals(expected,customLList.toArray());

        int[] expected2 = {10,20,30};
        customLList.addLast(10);
        customLList.addLast(20);
        customLList.addLast(30);
        customLList.addFirst(10);
        customLList.addFirst(10);
        customLList.removeFirst();
        customLList.removeFirst();
        assertEquals(expected2.length,customLList.size());
        assertArrayEquals(expected2,customLList.toArray());


    }

    @Test
    public void removeLast() {
        int[] expected = {};
        CustomLList customLList = new CustomLList();
        customLList.addLast(10);
        customLList.removeLast();
        assertEquals(expected.length, customLList.size());
        assertArrayEquals(expected,customLList.toArray());

        int[] expected2 = {10,20,30};
        customLList.addLast(10);
        customLList.addLast(20);
        customLList.addLast(30);
        customLList.addLast(10);
        customLList.addLast(10);
        customLList.removeLast();
        customLList.removeLast();
        assertEquals(expected2.length,customLList.size());
        assertArrayEquals(expected2,customLList.toArray());
    }

    @Test
    public void remove() {
        int[] expected = {};
        CustomLList customLList = new CustomLList();
        customLList.addLast(10);
        customLList.remove(0); //removeFirst
        assertEquals(expected.length, customLList.size());
        assertArrayEquals(expected,customLList.toArray());

        int[] expected2 = {10,20,30};
        customLList.addLast(10);
        customLList.addLast(20);
        customLList.addLast(30);
        customLList.addLast(10);
        customLList.addLast(10);
        customLList.remove(3);
        customLList.remove(3); //removeLast
        assertEquals(expected2.length,customLList.size());
        assertArrayEquals(expected2,customLList.toArray());
    }

    @Test
    public void isEmpty() {
        CustomLList customLList = new CustomLList();
        assertTrue(customLList.isEmpty());

        customLList.addLast(10);
        customLList.removeFirst();
        assertTrue(customLList.isEmpty());

        customLList.addLast(20);
        customLList.removeLast();
        assertTrue(customLList.isEmpty());

        customLList.addFirst(30);
        customLList.removeFirst();
        assertTrue(customLList.isEmpty());

        customLList.addFirst(40);
        customLList.removeLast();
        assertTrue(customLList.isEmpty());

        customLList.add(0,10);
        customLList.add(0,20);
        customLList.add(1,30);
        customLList.removeLast();
        customLList.remove(1);
        customLList.removeFirst();
        assertTrue(customLList.isEmpty());

    }

    @Test
    public void toArray() {
        int[] expected = {};
        CustomLList actual = new CustomLList();
        assertArrayEquals(expected,actual.toArray());
        actual.addFirst(1);
        actual.removeLast();
        assertArrayEquals(expected,actual.toArray());

        int[] expected1 = {10,20,40,30,8,1,9,6,1024,2,1};
        actual.addLast(10);
        actual.addLast(20);
        actual.addLast(40);
        actual.addLast(30);
        actual.addLast(8);
        actual.addLast(1);
        actual.addLast(9);
        actual.addLast(6);
        actual.addLast(1024);
        actual.addLast(2);
        actual.addLast(1);
        assertArrayEquals(expected1,actual.toArray());
    }



    @Test
    public void getFirst() {
        int expected = 8;
        CustomLList actual = new CustomLList();
        actual.addLast(8);
        int actualFirst = actual.getFirst();
        assertEquals(expected,actualFirst);

        actual.addFirst(1);
        actual.addFirst(8);
        actualFirst = actual.getFirst();
        assertEquals(expected,actualFirst);
    }

    @Test
    public void getLast() {
        int expected = 8;
        CustomLList actual = new CustomLList();
        actual.addLast(8);
        int actualLast = actual.getLast();
        assertEquals(expected, actualLast);

        actual.addLast(1);
        actual.addLast(8);
        actualLast = actual.getLast();
        assertEquals(expected, actualLast);
    }

    @Test
    public void get() {
        int expected = 8;
        CustomLList actual = new CustomLList();
        actual.addLast(8);
        int actualItem = actual.get(0);
        assertEquals(expected, actualItem);

        actual.addLast(1);
        actual.addLast(8);
        actualItem = actual.get(0);
        assertEquals(expected,actualItem);
        actualItem = actual.get(2);
        assertEquals(expected,actualItem);

        actual.addLast(2);
        actual.addLast(2);
        actualItem = actual.get(2);
        assertEquals(expected,actualItem);

    }

    @Test
    public void set() {
        int expected = 8;
        CustomLList actualLList = new CustomLList();
        actualLList.addLast(1);
        actualLList.set(0,8);
        int actual = actualLList.get(0);
        assertEquals(expected,actual);
        actualLList.addFirst(1);
        actualLList.addLast(1);
        actualLList.addLast(1);

        actualLList.set(0,8);
        actual = actualLList.get(0);
        assertEquals(expected, actual);

        actualLList.set(2,8);
        actual = actualLList.get(2);
        assertEquals(expected, actual);

        actualLList.set(3,8);
        actual = actualLList.get(3);
        assertEquals(expected, actual);
    }


    @Test(expected = IndexOutOfBoundsException.class)
    public void indexException(){
        CustomLList actual = new CustomLList();
        actual.get(1);
        actual.remove(1);
        actual.add(1,8);
        actual.set(1,1);
    }

    @Test(expected = NoSuchElementException.class)
    public void elementException(){
        CustomLList actual = new CustomLList();
        actual.removeFirst();
        actual.removeLast();
    }
}