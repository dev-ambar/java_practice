package multiThreading;

import java.net.StandardSocketOptions;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class SemaphoreExample {

    public static void main(String args[]) throws InterruptedException {
        Semaphore sm = new Semaphore(3);
        ExecutorService service = Executors.newFixedThreadPool(50);
        IntStream.range(0,100).forEach(i ->  service.execute(new Task(sm)));
         service.shutdown();
         service.awaitTermination(1, TimeUnit.MINUTES);
    }

}

class Task implements Runnable
{

    private final Semaphore sm;

    public Task(Semaphore sm) {
        this.sm = sm ;
    }

    public void run() {
        try {

            System.out.println("work again start processing ");
            sm.acquire();
            SomeService.someIoService();
            System.out.println("left work again start processing ");
            sm.release();
        }
         catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}

class SomeService {
    public static void someIoService() throws InterruptedException {
        System.out.println(Thread.currentThread().getName() +"is here");
        Thread.sleep(3000);
        System.out.println("SomeIo service task has been completed");
    }
}