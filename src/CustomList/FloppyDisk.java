package CustomList;

import java.io.FileNotFoundException;

public class FloppyDisk {
    private static int DEFAULT_MEMORY;
    private int memory;
    private Node free;
    private Node reserved;

    FloppyDisk(int memory){
        DEFAULT_MEMORY = memory;
        this.memory = memory;
        free = new Node(memory);
    }
    private static class Node{
        int size;
        String filename;
        Node next;
        Node(int size){
            this.size = size;
        }

    }
    public void save(int size, String filename) {
        if (memory == DEFAULT_MEMORY) {
            if (size < free.size) {
                free.size -= size;
                Node reserved = new Node(size);
                reserved.filename = filename;
                return;
            }
        }
        Node p = new Node(size);
        p.filename = filename;
        Node find = free;
        Node prev = null;
        while (find.size < p.size) {
            if (find.next == null)
                throw new OutOfMemoryError();
            prev = find;
            find = find.next;

        }
        find.size -= size;
        if (find.size == 0) {
            if (prev != null) {
                prev.next = find.next;
                find = null;
            }
            else{
                free = free.next;
            }
        }
        p.next = reserved;
        reserved = p;
    }


    public void remove(String filename) {
        Node p = reserved;
        while (p != null) {
            if (p.next.filename.equals(filename)) {

                p.next = p.next.next;
                int size = p.size;
                Node newP = new Node(size);
                newP.next = free;
                free = newP;
                p.next = null;
                return;
            }
            p = p.next;
        }
    }
}
