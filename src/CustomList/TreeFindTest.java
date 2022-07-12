package CustomList;

import org.junit.Test;

import static org.junit.Assert.*;

public class TreeFindTest {

    @Test
    public void countAll() {
        TreeFind tree = new TreeFind();
        tree.insert(5);
        tree.insert(2);
        tree.insert(8);
        tree.insert(3);
        tree.insert(9);
        tree.insert(1);
        int actual = tree.countAll();
        int expected = 6;
        assertEquals(expected,actual);

    }

    @Test
    public void treeLevel() {
        TreeFind tree = new TreeFind();
        tree.insert(5);
        tree.insert(2);
        tree.insert(8);
        tree.insert(3);
        tree.insert(9);
        tree.insert(1);
        int actual = tree.treeLevel();
        int expected = 3;
        assertEquals(expected,actual);
    }
}