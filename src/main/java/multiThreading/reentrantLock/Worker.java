package multiThreading.reentrantLock;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.locks.ReentrantLock;

public class Worker implements Runnable{

    ReentrantLock re;
    String name;

    public Worker(ReentrantLock r1 , String n1)
    {
        this.re = r1;
        this.name = n1;
    }


    @Override
    public void run() {

        boolean workDone = false;
        while(!workDone)
        {
            // getting  outer re return true if getting the re
           boolean ans =  re.tryLock();
           if(ans)
           {
               try{
                   Date d = new Date();
                   SimpleDateFormat ft = new SimpleDateFormat("hh:mm:ss");
                   System.out.println("Task Name ->"+ name +"outer re acquired at"+ ft.format(d)+
                           "doing outer work");
                   Thread.sleep(1500);

                   // getting inner Lock
                   re.lock();
                   try{
                       d = new Date();
                       ft = new SimpleDateFormat("hh:mm:ss");
                       System.out.println("Task Name ->"+ name +"Inner re acquired at"+ ft.format(d)+
                               "doing Inner work");
                       System.out.println("lock hold count is ->"+re.getHoldCount());
                       Thread.sleep(1500);
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }
                   finally {
                       // release inner lock
                       System.out.println("task name" +name + "releasing inner lock the lock");
                       re.unlock();
                   }
                   System.out.println("lock hold count is ->"+re.getHoldCount());
                   System.out.println("task name" +name + "work done");
                   workDone = true;
               }
               catch (InterruptedException e) {
                   e.printStackTrace();
               }
               finally {
                   // outer lock release
                   System.out.println("task name" +name + "releasing outer lock the lock");
                    re.unlock();
                   System.out.println("lock hold count is ->"+re.getHoldCount());

               }

           }
           else
               System.out.println("task name" +name + "waiting  for  lock ");
              try
              {
                  Thread.sleep(1000);
              }
              catch (InterruptedException e) {
                  e.printStackTrace();
              }
        }
    }
}

