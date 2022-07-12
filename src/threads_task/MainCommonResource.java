package threads_task;

class CommonResource {
    public int x;

    public synchronized void process() {
        x = 0;
        for (int i = 0; i < 10; i++) {
            x++;
            System.out.println(x);
        }
    }
}

class CustomThread extends Thread {
    private final CommonResource resource;

    public CustomThread(CommonResource resource, String name) {
        super(name);
        this.resource = resource;
    }

    @Override
    public void run() {
//        synchronized (resource) {
//            resource.x = 0;
//            for (int i = 0; i < 10; i++) {
//                resource.x++;
//                System.out.println(getName() + " " + resource.x);
//            }
//        }
       resource.process();
    }


}

public class MainCommonResource {
    public static void main(String[] args) {
        CommonResource resource = new CommonResource();

        for (int i = 0; i < 3; i++) {
            CustomThread thread = new CustomThread(resource,"Поток " + (i + 1));
            thread.start();
        }


    }
}