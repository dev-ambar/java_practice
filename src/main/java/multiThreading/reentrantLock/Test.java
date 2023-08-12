package multiThreading.reentrantLock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

public class Test {
    private static final Integer MAX_THREAD_POOL = 2;

    public static void main(String[] args) {

        ExecutorService  executorService = Executors.newFixedThreadPool(MAX_THREAD_POOL);
        ReentrantLock re = new ReentrantLock();
        Worker w1 = new Worker(re,"Worker1");
        Worker w2 = new Worker(re,"Worker2");
        Worker w3 = new Worker(re,"Worker3");
        Worker w4 = new Worker(re,"Worker4");

        executorService.execute(w1);
        executorService.execute(w2);
        executorService.execute(w3);
        executorService.execute(w4);
        executorService.shutdown();
    }

}
