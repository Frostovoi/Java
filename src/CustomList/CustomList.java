package CustomList;

import java.util.Arrays;

public class CustomList<T> {
    private transient Object[] a;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;

    public CustomList() {
        a = new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    public CustomList(int capacity) {
        a = new Object[capacity];
        size = 0;
    }

    public void add(T item) {
        if (size == a.length) {
            a = Arrays.copyOf(a, a.length * 2);
        }
        a[size] = item;
        size++;
    }

    public void add(int index, T item) {
        if (index > size || index < 0)
            throw new IndexOutOfBoundsException();

        if (size == a.length)
            a = Arrays.copyOf(a, a.length * 2);

        for (int i = size; i > index; i--) {
            a[i] = a[i - 1];
        }
        a[index] = item;
        size++;
    }

    public void remove(int index) {
        if (index >= size || index < 0)
            throw new IndexOutOfBoundsException();
        for (int i = index; i < size - 1; i++) {
            a[i] = a[i + 1];
        }
        a = Arrays.copyOf(a, a.length - 1);
        size--;
    }


    public int indexOf(T item) {
        for (int i = 0; i < size; i++) {
            if (a[i].equals(item))
                return i;
        }
        return -1;
    }

    public int lastIndexOf(T item) {
        for (int i = size - 1; i > -1; i--) {
            if (a[i].equals(item))
                return i;
        }
        return -1;
    }


    public int size() {
        return size;
    }

    public T get(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        return (T) a[index];
    }

    public void set(int index, T item) {
        if (index >= size || index < 0)
            throw new IndexOutOfBoundsException();
        a[index] = item;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean contains(T item) {
        return indexOf(item) != -1;
    }





    @SuppressWarnings("unchecked")
    public T[] toArray(T[] a){
        return (T[]) Arrays.copyOf(this.a, size, a.getClass());
    }
}
