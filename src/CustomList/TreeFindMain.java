package CustomList;

public class TreeFindMain {
    public static void main(String[] args) {
        TreeFind treeFind = new TreeFind();
        treeFind.insert(10);
        treeFind.insert(20);
        treeFind.insert(5);
        treeFind.insert(7);

        treeFind.show();

        System.out.println(treeFind.toString());
    }
}
