import java.util.concurrent.*;

public class MyCallable implements Callable<Integer> {
    public static final int THREAD_SLEEP_TIME = 2500;
    String name;

    public MyCallable(String threadname) {
        this.name = threadname;
    }

    @Override
    public Integer call() throws Exception {
        int count = 0;
        for (int i = 5; i > 0; i--) {
            Thread.sleep(THREAD_SLEEP_TIME);
            System.out.println(name + " Всем привет!");
            count++;
        }
        return count;
    }

    @Override
    public String toString() {
        return name;
    }
}
