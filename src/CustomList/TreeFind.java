package CustomList;

public class TreeFind {
    private static class Node {
        int item;
        Node left;
        Node right;

        Node(int item) {
            this.item = item;
        }
    }

    private Node root;

    public void insert(int item) {
        root = insert(root, item);
    }

    public void show() {
        show(root, 0);
    }

    public boolean contains(int item) {
        return findNode(root, item) != null;
    }

    private Node findNode(Node p, int item) {
        if (p == null)
            return null;
        if (p.item == item)
            return p;
        if (p.item > item)
            return findNode(p.left, item);
        else
            return findNode(p.right, item);
    }

    private Node insert(Node p, int item) {
        if (p == null)
            return new Node(item);
        if (p.item > item)
            p.left = insert(p.left, item);
        else if (p.item < item)
            p.right = insert(p.right, item);
        return p;
    }

    private void show(Node p, int level) {
        if (p != null) {
            show(p.right, level + 1);
            for (int i = 0; i < level; i++) {
                System.out.print("  ");
            }
            System.out.println(p.item);
            show(p.left, level + 1);
        }
    }

    public int countAll() {
        return countAll(root, 0);
    }

    private int countAll(Node p, int count) {
        if (p == null) {
            return count;
        } else {
            count++;
            count = countAll(p.right, count);
            count = countAll(p.left, count);
        }
        return count;
    }

    public int treeLevel() {
        return treeLevel(root, 0);
    }

    private int treeLevel(Node p, int level) {
        int rLevel, lLevel;
        if (p == null) {
            return level;
        } else {
            level++;
            rLevel = treeLevel(p.right, level);
            lLevel = treeLevel(p.left, level);
        }
        return Math.max(rLevel, lLevel);
    }


    public TreeFind multiplicationTwo() {
        TreeFind tree = new TreeFind();
        multiplicationTwo(this.root, tree);
        return tree;
    }

    private void multiplicationTwo(Node p, TreeFind tree) {
        if (p == null)
            return;
        tree.insert(p.item * 2);
        multiplicationTwo(p.right, tree);
        multiplicationTwo(p.left, tree);
    }

    public boolean containsSubTree(TreeFind tree) {
        if (contains(tree.root.item)) {
            Node p = findNode(this.root, tree.root.item);
            return containsSubTree(p, tree.root);
        }
        return false;
    }

    private boolean containsSubTree(Node p, Node tree) {
        if (tree == null)
            return true;
        if (p == null)
            return false;
        boolean left, right;
        if (p.item != tree.item)
            return false;
        left = containsSubTree(p.left, tree.left);
        right = containsSubTree(p.right, tree.right);
        return left && right;
    }

    public TreeFind filterOdd() {
        TreeFind tree = new TreeFind();
        filterOdd(root, tree);
        return tree;
    }

    private void filterOdd(Node p, TreeFind tree) {
        if (p == null)
            return;
        if (p.item % 2 == 0)
            tree.insert(tree.root, p.item);
        filterOdd(p.left, tree);
        filterOdd(p.right, tree);
    }

    public TreeFind subTree (int item) {
        TreeFind tree = new TreeFind();
        tree.root = findNode(this.root, item);
        return tree;
    }

    public String toString() {
        return toString(root);
    }

    private String toString(Node p) {
        if (p == null)
            return "";
        String result = String.valueOf(p.item) + " ";
        result += toString(p.left);
        result += toString(p.right);
        return result;

    }
}


//посчитать кол-во элементов
//определить высоту дерева
//перевести дерево в строку
//получить поддерево
//получить новое дерево полученное путем умножения каждого элемента на 2
//получить новое дерево путем фильтрации элементов (например отобрать только четные)
//проверка на вхождение поддерева