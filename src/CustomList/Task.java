package CustomList;

import java.util.ArrayList;
import java.util.List;

public class Task {
    private String name;
    private Task parent;
    private List<Task> children = new ArrayList<Task>();
    private int cost;

    public Task(String name) {
        this.name = name;
    }
    public Task(String name, int cost) {
        this.name = name;
    }

    public void add(String parentName, String taskName) {
        Task parent = findTask(this, parentName);
        if (parent != null){
            Task r = new Task(taskName);
            parent.children.add(r);
            r.parent = parent;
        }
    }

    public void show(){
        show(this, 0);
    }

    public void delete(String taskName) {
        Task task = findTask(this, taskName);
        if (task != null)
            task.parent.children.remove(task);
    }

    public void changeParent(String taskName, String parentName) {
        Task parentTask = findTask(this, parentName);
        Task task = findTask(this, taskName);
        if (task != null && parentTask != null){
            task.parent.children.remove(task);
            task.parent = parentTask;
            parentTask.children.add(task);
        }
    }

    private void show(Task t, int level) {
        for (int i = 0; i < level; i++) {
            System.out.print("   ");
        }
        System.out.println(t.name);
        for(Task p : t.children) {
            show(p, level + 1);
        }
    }

    private Task findTask(Task t, String name) {
        if (t.name.equals(name))
            return t;
        for (Task p : t.children) {
            Task r = findTask(p, name);
            if (r != null)
                return r;
        }
        return null;
    }

    public int getCost() {
        return cost;
    }
}
