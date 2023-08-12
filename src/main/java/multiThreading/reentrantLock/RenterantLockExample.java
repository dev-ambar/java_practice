package multiThreading.reentrantLock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class RenterantLockExample {

     private static Lock lock = new ReentrantLock();
     static int i = 0;

    private static void accessResource()
    {
        lock.lock();
        try
        {

        // update the shared resource
             i++;
            System.out.println(Thread.currentThread().getName()+"Increasing the count ->"+i);
        }
        finally {
            lock.unlock();
        }

    }
   /// Using tryLock
    private static void accessAnotherResource() throws InterruptedException {
        //Boolean tryLock = re.tryLock();
        Boolean tryLock = lock.tryLock(5L, TimeUnit.SECONDS);

        if(tryLock)
        {
            try {
                // update the resource
            }
            finally {
                lock.unlock();
            }

        }
        else
        {
             // process the records.
        }


    }

    public static void main(String[] args) {

        Thread t1 = new Thread(()->  accessResource());
        t1.start();
        Thread t2 = new Thread(()->  accessResource());
        t2.start();


        Thread t3 = new Thread(()->  accessResource());
        t3.start();
        Thread t4 = new Thread(()->  accessResource());
        t4.start();
    }

}
