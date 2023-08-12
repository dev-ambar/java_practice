package multiThreading;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

// using Lock and condition
public class ProducerConsumer {

     private List<Object> queue = new LinkedList<>();
     private final Integer MAX_SIZE = 16;
     private ReentrantLock lock = new ReentrantLock();
     private Condition notFull = lock.newCondition();
     private Condition notEmpty = lock.newCondition();

     public void pushElement() {
          int i = 0;
          while (i < 100) {
               lock.lock();
               try {
                    while (queue.size() == MAX_SIZE) {
                         System.out.println("Producer wait for to make an place to add element");
                         try {
                              notFull.await();
                              Thread.sleep(1000);
                         } catch (InterruptedException e) {
                              e.printStackTrace();
                         }
                    }
                    System.out.println("Producer " +Thread.currentThread().getName()+ " add element-> " + i + "in buffer");
                    queue.add(i);
                    i++;
                    notEmpty.signalAll();

               } finally {
                    lock.unlock();
               }
          }
     }

     public void popElement() {
          int j = 0;
          while (j< 100) {
               lock.lock();
               try {
                    while (queue.isEmpty()) {
                         System.out.println(" buffer is fully empty so Consumer wait for to add element");
                         try {
                              notEmpty.await();
                              Thread.sleep(1000);
                         } catch (InterruptedException e) {
                              e.printStackTrace();
                         }
                    }
                    Object obj = queue.remove(queue.size() - 1);
                    System.out.println("Consumer " +Thread.currentThread().getName()+ "consumes the element from buffer -> " + obj);
                    notFull.signalAll();
                    j++;

               } finally {
                    lock.unlock();
               }

          }

     }
}

  class  PCRunner
 {
      public static void main(String[] args) {

           ProducerConsumer pc = new ProducerConsumer();

           Thread t1 = new Thread(()-> pc.pushElement());
           Thread t2 = new Thread(()-> pc.pushElement());

           Thread t3 = new Thread(()-> pc.popElement());
           Thread t4 = new Thread(()-> pc.popElement());

           ExecutorService exe = Executors.newFixedThreadPool(100);
            exe.execute(t1);
            exe.execute(t2);
            exe.execute(t3);
            exe.execute(t4);
            exe.shutdown();
      }
 }
