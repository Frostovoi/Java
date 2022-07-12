package CustomList;

import java.util.NoSuchElementException;

public class CustomLList {


    private static class Node {
        int item;
        Node next;
        Node previous;
        Node(int item) {
            this.item = item;
        }
    }

    private Node head;
    private Node tail;
    private int size;


    public void addLast(int item) {
        Node node = new Node(item);

        if (isEmpty()) {
            head = node;
            tail = node;
        }
        else {
            tail.next = node;
            node.previous = tail;
            tail = node;
        }
        size++;
    }

    public void addFirst(int item) {
        Node node = new Node(item);

        if (isEmpty()) {
            head = node;
            tail = node;
        }
        else {
            node.next = head;
            head.previous = node;
            head = node;
        }
        size++;
    }

    public void add(int index, int item) {
        if (index > size || index < 0)
            throw new IndexOutOfBoundsException();
        if (index == 0)
            addFirst(item);
        else if (index == size)
            addLast(item);
        else {
            Node node = new Node(item);
            Node tempNode = findNode(index);
            Node prevNode = tempNode.previous;
            node.next = tempNode;
            node.previous = prevNode;
            prevNode.next = node;
            tempNode.previous = node;
            size++;
        }
    }

    public void removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        head = head.next;
        if (head != null)
            head.previous = null;
        else
            tail = null;
        size--;
    }

    public void removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        tail = tail.previous;
        if (tail != null){
            tail.next = null;
        }
        else
            head = null;
        size--;
    }

    public void remove(int index) {
        if (isEmpty())
            throw new NoSuchElementException();
        if (index >= size || index < 0)
            throw new IndexOutOfBoundsException();
        if (index == 0)
            removeFirst();
        else if (index == size - 1)
            removeLast();
        else {
            Node curNode = findNode(index);
            Node prevNode = curNode.previous;
            Node nextNode = curNode.next;
            prevNode.next = nextNode;
            nextNode.previous = prevNode;
            size--;
        }
    }

    private Node findNode(int index) {
        if (index < size / 2) {
            Node p = head;
            for(int i = 0; i < index; i++){
                p = p.next;
            }
            return p;
        }
        else {
            Node p = tail;
            for (int i = 0; i < size - index - 1; i++) {
                p = p.previous;
            }
            return p;
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }



    public int[] toArray(){
        int[] a = new int[size];
        Node p = head;
        int i = 0;
        while (p != null) {
            a[i] = p.item;
            p = p.next;
            i++;

    }
        return a;
    }

    public int get(int index){
        if (index >= size || index < 0)
            throw new IndexOutOfBoundsException();
        if (index == 0)
            return getFirst();
        else if (index == size - 1)
            return getLast();
        else
            return findNode(index).item;
    }

    public int getFirst(){
        return head.item;
    }

    public int getLast(){
        return tail.item;
    }

    public void set(int index, int item){
        if (index >= size || index < 0)
            throw new IndexOutOfBoundsException();
        findNode(index).item = item;
    }

    public int size() {
        return size;
    }
}
