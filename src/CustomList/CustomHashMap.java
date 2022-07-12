package CustomList;

import java.util.*;

public class CustomHashMap<K, V> {
    private final static int DEFAULT_CAPACITY = 10;
    private Node<K, V> [] table;
    private int count;
    private K[] keySet;
    private int sizeKeys;


    private static class Node<T, V>{
        T key;
        V value;
        Node<T, V> next;
        Node(T key, V value){
            this.key = key;
            this.value = value;
        }

    }

    private void rehash(){
        CustomHashMap <K,V> customHashMap = new CustomHashMap<K, V>();
        customHashMap.table = new Node[table.length*2];
        for(var node : table) {
            if (node != null) {
                while (node != null) {
                    customHashMap.put(node.key,node.value);
                    node = node.next;
                }
            }
        }
        table = customHashMap.table;
    }

    public CustomHashMap(){
        this.table = new Node[DEFAULT_CAPACITY];
        count = 0;
    }

    private int hashFunction(int k) {
        return k % table.length;
    }

    public void put(K key, V value){
        if (containsKey(key))
            throw new IllegalArgumentException();

        Node <K, V> node = new Node<K, V>(key, value);
        int pos = hashFunction(key.hashCode());
        node.next = table[pos];
        table[pos] = node;
        count++;
        if ((double)table.length/(double) count >= 0.7 ) {
            rehash();
        }
    }


    public boolean containsKey(K key) {
        int pos = hashFunction(key.hashCode());
        if (table[pos] == null)
            return false;
        Node <K,V> p = table[pos];
        while (p != null) {
            if (p.key.equals(key))
                return true;
            p = p.next;
        }
        return false;
    }

    public V get(K key){
        if (!containsKey(key)) {
            throw new IllegalArgumentException();
        }
        int pos = hashFunction(key.hashCode());
        Node<K,V> p = table[pos];
        while (!p.key.equals(key)){
            p = p.next;
        }
        return p.value;
    }

    public void remove(K key) {
        if (!containsKey(key)){
            throw new IllegalArgumentException();
        }
        int pos = hashFunction(key.hashCode());
        Node <K,V> p = table[pos];
        Node <K,V> next = p.next;
        if (p.key.equals(key)) {
           table[pos] = p.next;
        }
        else {
            while (next != null) {
                if (next.key.equals(key)) {
                    p.next = next.next;
                    break;
                }
                p = p.next;
                next = p.next;
            }
        }

    }



    public int size (){
        return count;
    }



}
