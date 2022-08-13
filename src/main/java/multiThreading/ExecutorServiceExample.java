package multiThreading;

import java.util.Random;
import java.util.concurrent.*;

public class ExecutorServiceExample {

    public static  void main(String args[]) throws ExecutionException, InterruptedException {
        /*int coreCount = Runtime.getRuntime().availableProcessors();
        System.out.println("coreCount number is : "+coreCount);
        ExecutorService executorService = Executors.newFixedThreadPool(coreCount);*/
        /*ExecutorService executorService = Executors.newCachedThreadPool();*/
/*        ScheduledExecutorService  executorService = Executors.newScheduledThreadPool(10);
        executorService.schedule(new Task(),10, TimeUnit.SECONDS) ;
        executorService.scheduleAtFixedRate(new Task(),15 ,10,TimeUnit.SECONDS);
        executorService.scheduleWithFixedDelay(new Task(),15 ,10,TimeUnit.SECONDS);
        executorService.isTerminated();*/
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        for(int i = 0; i <=100;i++)
        {
            Future<Integer> f = executorService.submit(new CallTask());
             System.out.println(f.get());
        }
        System.out.println("Currently thread"+Thread.currentThread().getName()+ " is started");
    }
}

class RunTask implements Runnable
{
    public void run() {
        System.out.println("Currently thread"+Thread.currentThread().getName()+ " is started");
    }
}

class CallTask implements Callable<Integer>
{
    public Integer call() throws Exception {
        Thread.sleep(3000);
        System.out.println("Currently thread"+Thread.currentThread().getName()+ " is started");
        return  new Random().nextInt();
    }
}
