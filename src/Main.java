import java.util.HashSet;
import java.util.Hashtable;
import java.util.Set;
import java.util.concurrent.*;

public class Main {

    public static final int THREADS_COUNT = 4;

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        Callable<Integer> myCallable1 = new MyCallable("Я поток 1");
        Callable<Integer> myCallable2 = new MyCallable("Я поток 2");
        Callable<Integer> myCallable3 = new MyCallable("Я поток 3");
        Callable<Integer> myCallable4 = new MyCallable("Я поток 4");

        final ExecutorService threadPool = Executors.newFixedThreadPool(THREADS_COUNT);

        final Future<Integer> task1 = threadPool.submit(myCallable1);
        final Future<Integer> task2 = threadPool.submit(myCallable2);
        final Future<Integer> task3 = threadPool.submit(myCallable3);
        final Future<Integer> task4 = threadPool.submit(myCallable4);

        showMassage(myCallable1, task1);
        showMassage(myCallable2, task2);
        showMassage(myCallable3, task3);
        showMassage(myCallable4, task4);

        Set<Callable<Integer>> callables = new HashSet<>();
        callables.add(myCallable1);
        callables.add(myCallable2);
        callables.add(myCallable3);
        callables.add(myCallable4);

// получаем результат самой быстрой задачи через метод invokeAny
        final int resultOfTask = threadPool.invokeAny(callables);
        System.out.println("Результат самой быстрой задачи " + resultOfTask);
        System.out.println("Завершаю все потоки.");
        threadPool.shutdown();

    }

    public static void showMassage(Callable<Integer> myCallable, Future<Integer> task) throws ExecutionException, InterruptedException {
        System.out.println(myCallable + " отправил сообщения " + task.get() + " раз ");
    }
}
