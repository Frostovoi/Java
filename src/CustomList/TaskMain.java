package CustomList;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TaskMain {
    public static void main(String[] args) {
        try(BufferedReader reader = new BufferedReader(new FileReader("TreeTasks"))){
            String task= reader.readLine();
            Task baseTask = new Task(task);
            while ((task=reader.readLine()) != null) {
                String[]curTask = task.split(" ");
                baseTask.add(curTask[0],curTask[1]);
            }
            baseTask.show();
            baseTask.delete("D23");
            baseTask.show();
            baseTask.changeParent("C12","B2");
            baseTask.show();
        }
        catch (IOException exc){
            exc.printStackTrace();
        }
    }
}
