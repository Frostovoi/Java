package threads_task;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Главный поток старт");
        List<Thread> threads = new ArrayList<>();

        //Thread p = new Thread(new PThread(), "FFF");

        for (int i = 0; i < 3; i++) {
            MyThread thread = new MyThread("Поток " + (i + 1));
            thread.start();
            //thread.join();
            threads.add(thread);
        }

        threads.forEach(t-> {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        System.out.println("Главный поток завершился");
    }
}
